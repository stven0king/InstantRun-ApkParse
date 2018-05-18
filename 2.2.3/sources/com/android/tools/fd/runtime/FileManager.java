package com.android.tools.fd.runtime;

import android.content.Context;
import android.util.Log;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileManager {
    public static final String CLASSES_DEX_SUFFIX = ".dex";
    private static final String FILE_NAME_ACTIVE = "active";
    private static final String FOLDER_NAME_LEFT = "left";
    private static final String FOLDER_NAME_RIGHT = "right";
    private static final String RELOAD_DEX_PREFIX = "reload";
    private static final String RESOURCE_FILE_NAME = "resources.ap_";
    private static final String RESOURCE_FOLDER_NAME = "resources";
    private static final boolean USE_EXTRACTED_RESOURCES = false;
    private static boolean sHavePurgedTempDexFolder;

    private static File getDataFolder() {
        return new File(Paths.getDataDirectory(AppInfo.applicationId));
    }

    private static File getResourceFile(File base) {
        return new File(base, "resources.ap_");
    }

    private static File getDexFileFolder(File base, boolean createIfNecessary) {
        File file = new File(base, Paths.DEX_DIRECTORY_NAME);
        if (!createIfNecessary || file.isDirectory() || file.mkdirs()) {
            return file;
        }
        Log.e(BootstrapApplication.LOG_TAG, "Failed to create directory " + file);
        return null;
    }

    private static File getTempDexFileFolder(File base) {
        return new File(base, "dex-temp");
    }

    public static File getNativeLibraryFolder() {
        return new File(Paths.getMainApkDataDirectory(AppInfo.applicationId), "lib");
    }

    public static File getReadFolder() {
        return new File(getDataFolder(), leftIsActive() ? FOLDER_NAME_LEFT : FOLDER_NAME_RIGHT);
    }

    public static void swapFolders() {
        setLeftActive(!leftIsActive());
    }

    public static File getWriteFolder(boolean wipe) {
        File folder = new File(getDataFolder(), leftIsActive() ? FOLDER_NAME_RIGHT : FOLDER_NAME_LEFT);
        if (wipe && folder.exists()) {
            delete(folder);
            if (!folder.mkdirs()) {
                Log.e(BootstrapApplication.LOG_TAG, "Failed to create folder " + folder);
            }
        }
        return folder;
    }

    private static void delete(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File child : files) {
                    delete(child);
                }
            }
        }
        if (!file.delete()) {
            Log.e(BootstrapApplication.LOG_TAG, "Failed to delete file " + file);
        }
    }

    private static boolean leftIsActive() {
        File pointer = new File(getDataFolder(), FILE_NAME_ACTIVE);
        if (!pointer.exists()) {
            return true;
        }
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(pointer));
            boolean equals = FOLDER_NAME_LEFT.equals(reader.readLine());
            reader.close();
            return equals;
        } catch (IOException e) {
            return true;
        } catch (Throwable th) {
            reader.close();
        }
    }

    private static void setLeftActive(boolean active) {
        File folder = getDataFolder();
        File pointer = new File(folder, FILE_NAME_ACTIVE);
        if (pointer.exists()) {
            if (!pointer.delete()) {
                Log.e(BootstrapApplication.LOG_TAG, "Failed to delete file " + pointer);
            }
        } else if (!folder.exists()) {
            if (!folder.mkdirs()) {
                Log.e(BootstrapApplication.LOG_TAG, "Failed to create directory " + folder);
                return;
            }
            return;
        }
        Writer writer;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pointer), "UTF-8"));
            writer.write(active ? FOLDER_NAME_LEFT : FOLDER_NAME_RIGHT);
            writer.close();
        } catch (IOException e) {
        } catch (Throwable th) {
            writer.close();
        }
    }

    public static void checkInbox() {
        File inbox = new File(Paths.getInboxDirectory(AppInfo.applicationId));
        if (inbox.isDirectory()) {
            File resources = new File(inbox, "resources.ap_");
            if (resources.isFile()) {
                if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                    Log.v(BootstrapApplication.LOG_TAG, "Processing resource file from inbox (" + resources + ")");
                }
                byte[] bytes = readRawBytes(resources);
                if (bytes != null) {
                    startUpdate();
                    writeAaptResources("resources.ap_", bytes);
                    finishUpdate(true);
                    if (!resources.delete() && Log.isLoggable(BootstrapApplication.LOG_TAG, 6)) {
                        Log.e(BootstrapApplication.LOG_TAG, "Couldn't remove inbox resource file: " + resources);
                    }
                }
            }
        }
    }

    public static File getExternalResourceFile() {
        File file = getResourceFile(getReadFolder());
        if (file.exists()) {
            return file;
        }
        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Cannot find external resources, not patching them in");
        }
        return null;
    }

    public static List<String> getDexList(Context context, long apkModified) {
        File[] dexFiles;
        File dataFolder = getDataFolder();
        long newestHotswapPatch = getMostRecentTempDexTime(dataFolder);
        File dexFolder = getDexFileFolder(dataFolder, false);
        boolean extractedSlices = false;
        if (dexFolder == null || !dexFolder.isDirectory()) {
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                Log.v(BootstrapApplication.LOG_TAG, "No local dex slice folder: First run since installation.");
            }
            dexFolder = getDexFileFolder(dataFolder, true);
            if (dexFolder == null) {
                Log.wtf(BootstrapApplication.LOG_TAG, "Couldn't create dex code folder");
                return Collections.emptyList();
            }
            dexFiles = extractSlices(dexFolder, null, -1);
            extractedSlices = dexFiles.length > 0;
        } else {
            dexFiles = dexFolder.listFiles();
        }
        if (dexFiles == null || dexFiles.length == 0) {
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                Log.v(BootstrapApplication.LOG_TAG, "Cannot find dex classes, not patching them in");
            }
            return Collections.emptyList();
        }
        long newestColdswapPatch = apkModified;
        if (!extractedSlices && dexFiles.length > 0) {
            long oldestColdSwapPatch = apkModified;
            for (File dex : dexFiles) {
                long dexModified = dex.lastModified();
                oldestColdSwapPatch = Math.min(dexModified, oldestColdSwapPatch);
                newestColdswapPatch = Math.max(dexModified, newestColdswapPatch);
            }
            if (oldestColdSwapPatch < apkModified) {
                if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                    Log.v(BootstrapApplication.LOG_TAG, "One or more slices were older than APK: extracting newer slices");
                }
                dexFiles = extractSlices(dexFolder, dexFiles, apkModified);
            }
        } else if (newestHotswapPatch > 0) {
            purgeTempDexFiles(dataFolder);
        }
        if (newestHotswapPatch > newestColdswapPatch) {
            String message = "Your app does not have the latest code changes because it was restarted manually. Please run from IDE instead.";
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                Log.v(BootstrapApplication.LOG_TAG, message);
            }
            Restarter.showToastWhenPossible(context, message);
        }
        List<String> list = new ArrayList(dexFiles.length);
        for (File dex2 : dexFiles) {
            if (dex2.getName().endsWith(CLASSES_DEX_SUFFIX)) {
                list.add(dex2.getPath());
            }
        }
        Collections.sort(list, Collections.reverseOrder());
        return list;
    }

    private static File[] extractSlices(File dexFolder, File[] dexFolderFiles, long apkModified) {
        File[] fileArr;
        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Extracting slices into " + dexFolder);
        }
        InputStream stream = BootstrapApplication.class.getResourceAsStream("/instant-run.zip");
        if (stream == null) {
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 6)) {
                Log.e(BootstrapApplication.LOG_TAG, "Could not find slices in APK; aborting.");
            }
            return new File[0];
        }
        List<File> arrayList = new ArrayList(30);
        Set<String> sliceNames = new HashSet(30);
        try {
            ZipInputStream zipInputStream = new ZipInputStream(stream);
            byte[] buffer = new byte[2000];
            ZipEntry entry = zipInputStream.getNextEntry();
            while (entry != null) {
                String name = entry.getName();
                if (!name.startsWith("META-INF") && !entry.isDirectory() && name.indexOf(47) == -1 && name.endsWith(CLASSES_DEX_SUFFIX)) {
                    String sliceName = Paths.DEX_SLICE_PREFIX + name;
                    sliceNames.add(sliceName);
                    File dest = new File(dexFolder, sliceName);
                    arrayList.add(dest);
                    if (apkModified <= 0 || dest.lastModified() <= apkModified) {
                        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                            Log.v(BootstrapApplication.LOG_TAG, "Extracting slice " + name + " into " + dest);
                        }
                        File parent = dest.getParentFile();
                        if (parent == null || parent.exists() || parent.mkdirs()) {
                            OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(dest));
                            while (true) {
                                try {
                                    int bytesRead = zipInputStream.read(buffer);
                                    if (bytesRead == -1) {
                                        break;
                                    }
                                    bufferedOutputStream.write(buffer, 0, bytesRead);
                                } catch (IOException ioe) {
                                    Log.wtf(BootstrapApplication.LOG_TAG, "Failed to extract slices into directory " + dexFolder, ioe);
                                    fileArr = new File[0];
                                    try {
                                        zipInputStream.close();
                                    } catch (IOException e) {
                                    }
                                    try {
                                        stream.close();
                                        return fileArr;
                                    } catch (IOException e2) {
                                        return fileArr;
                                    }
                                } catch (Throwable th) {
                                    try {
                                        zipInputStream.close();
                                    } catch (IOException e3) {
                                    }
                                }
                            }
                            bufferedOutputStream.close();
                            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                                Log.v(BootstrapApplication.LOG_TAG, "File written at " + System.currentTimeMillis());
                                Log.v(BootstrapApplication.LOG_TAG, "File last modified reported : " + dest.lastModified());
                            }
                        } else {
                            Log.wtf(BootstrapApplication.LOG_TAG, "Failed to create directory " + dest);
                            fileArr = new File[0];
                            try {
                                zipInputStream.close();
                            } catch (IOException e4) {
                            }
                            return fileArr;
                        }
                    } else if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                        Log.v(BootstrapApplication.LOG_TAG, "Ignoring slice " + name + ": newer on disk than in APK");
                    }
                }
                entry = zipInputStream.getNextEntry();
            }
            if (dexFolderFiles != null) {
                for (File file : dexFolderFiles) {
                    if (!sliceNames.contains(file.getName())) {
                        if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                            Log.v(BootstrapApplication.LOG_TAG, "Removing old slice " + file);
                        }
                        if (!file.delete() && Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                            Log.v(BootstrapApplication.LOG_TAG, "Could not delete " + file);
                        }
                    }
                }
            }
            fileArr = (File[]) arrayList.toArray(new File[arrayList.size()]);
            try {
                zipInputStream.close();
            } catch (IOException e5) {
            }
            try {
                stream.close();
                return fileArr;
            } catch (IOException e6) {
                return fileArr;
            }
        } finally {
            try {
                stream.close();
            } catch (IOException e7) {
            }
        }
    }

    public static File getTempDexFile() {
        File dataFolder = getDataFolder();
        File dexFolder = getTempDexFileFolder(dataFolder);
        if (dexFolder.exists()) {
            if (!sHavePurgedTempDexFolder) {
                purgeTempDexFiles(dataFolder);
            }
        } else if (dexFolder.mkdirs()) {
            sHavePurgedTempDexFolder = true;
        } else {
            Log.e(BootstrapApplication.LOG_TAG, "Failed to create directory " + dexFolder);
            return null;
        }
        File[] files = dexFolder.listFiles();
        int max = -1;
        if (files != null) {
            for (File file : files) {
                String name = file.getName();
                if (name.startsWith(RELOAD_DEX_PREFIX) && name.endsWith(CLASSES_DEX_SUFFIX)) {
                    try {
                        int version = Integer.decode(name.substring(RELOAD_DEX_PREFIX.length(), name.length() - CLASSES_DEX_SUFFIX.length())).intValue();
                        if (version > max) {
                            max = version;
                        }
                    } catch (NumberFormatException e) {
                    }
                }
            }
        }
        File file2 = new File(dexFolder, String.format("%s0x%04x%s", new Object[]{RELOAD_DEX_PREFIX, Integer.valueOf(max + 1), CLASSES_DEX_SUFFIX}));
        if (!Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            return file2;
        }
        Log.v(BootstrapApplication.LOG_TAG, "Writing new dex file: " + file2);
        return file2;
    }

    public static boolean writeRawBytes(File destination, byte[] bytes) {
        BufferedOutputStream output;
        try {
            output = new BufferedOutputStream(new FileOutputStream(destination));
            output.write(bytes);
            output.flush();
            output.close();
            return true;
        } catch (IOException ioe) {
            Log.wtf(BootstrapApplication.LOG_TAG, "Failed to write file, clean project and rebuild " + destination, ioe);
            throw new RuntimeException(String.format("InstantRun could not write file %1$s, clean project and rebuild ", new Object[]{destination}));
        } catch (Throwable th) {
            output.close();
        }
    }

    public static boolean extractZip(File destination, byte[] zipBytes) {
        return extractZip(destination, new ByteArrayInputStream(zipBytes));
    }

    public static boolean extractZip(File destDir, InputStream inputStream) {
        boolean z = false;
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        byte[] buffer = new byte[2000];
        ZipEntry entry = zipInputStream.getNextEntry();
        while (entry != null) {
            String name = entry.getName();
            if (!(name.startsWith("META-INF") || entry.isDirectory())) {
                File dest = new File(destDir, name);
                File parent = dest.getParentFile();
                if (parent == null || parent.exists() || parent.mkdirs()) {
                    OutputStream src = new BufferedOutputStream(new FileOutputStream(dest));
                    while (true) {
                        try {
                            int bytesRead = zipInputStream.read(buffer);
                            if (bytesRead == -1) {
                                break;
                            }
                            src.write(buffer, 0, bytesRead);
                        } catch (IOException ioe) {
                            try {
                                Log.e(BootstrapApplication.LOG_TAG, "Failed to extract zip contents into directory " + destDir, ioe);
                            } finally {
                                try {
                                    zipInputStream.close();
                                } catch (IOException e) {
                                }
                            }
                        } catch (Throwable th) {
                            src.close();
                        }
                    }
                    src.close();
                } else {
                    Log.e(BootstrapApplication.LOG_TAG, "Failed to create directory " + dest);
                    try {
                        zipInputStream.close();
                        break;
                    } catch (IOException e2) {
                    }
                }
            }
            entry = zipInputStream.getNextEntry();
        }
        z = true;
        try {
            zipInputStream.close();
        } catch (IOException e3) {
        }
        return z;
    }

    public static void startUpdate() {
        getWriteFolder(true);
    }

    public static void finishUpdate(boolean wroteResources) {
        if (wroteResources) {
            swapFolders();
        }
    }

    public static File writeDexShard(byte[] bytes, String name) {
        File dexFolder = getDexFileFolder(getDataFolder(), true);
        if (dexFolder == null) {
            return null;
        }
        File file = new File(dexFolder, name);
        writeRawBytes(file, bytes);
        return file;
    }

    public static void writeAaptResources(String relativePath, byte[] bytes) {
        File file = getResourceFile(getWriteFolder(false));
        File folder = file.getParentFile();
        if (folder.isDirectory() || folder.mkdirs()) {
            if (relativePath.equals("resources.ap_")) {
                writeRawBytes(file, bytes);
            } else {
                writeRawBytes(file, bytes);
            }
        } else if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
            Log.v(BootstrapApplication.LOG_TAG, "Cannot create local resource file directory " + folder);
        }
    }

    public static String writeTempDexFile(byte[] bytes) {
        File file = getTempDexFile();
        if (file != null) {
            writeRawBytes(file, bytes);
            return file.getPath();
        }
        Log.e(BootstrapApplication.LOG_TAG, "No file to write temp dex content to");
        return null;
    }

    public static long getMostRecentTempDexTime(File dataFolder) {
        long newest = 0;
        File dexFolder = getTempDexFileFolder(dataFolder);
        if (dexFolder.isDirectory()) {
            File[] files = dexFolder.listFiles();
            if (files != null) {
                newest = 0;
                for (File file : files) {
                    if (file.getPath().endsWith(CLASSES_DEX_SUFFIX)) {
                        newest = Math.max(newest, file.lastModified());
                    }
                }
            }
        }
        return newest;
    }

    public static void purgeTempDexFiles(File dataFolder) {
        sHavePurgedTempDexFolder = true;
        File dexFolder = getTempDexFileFolder(dataFolder);
        if (dexFolder.isDirectory()) {
            File[] files = dexFolder.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getPath().endsWith(CLASSES_DEX_SUFFIX) && !file.delete()) {
                        Log.e(BootstrapApplication.LOG_TAG, "Could not delete temp dex file " + file);
                    }
                }
            }
        }
    }

    public static long getFileSize(String path) {
        if (path.equals("resources.ap_")) {
            File file = getExternalResourceFile();
            if (file != null) {
                return file.length();
            }
        }
        return -1;
    }

    public static byte[] getCheckSum(String path) {
        if (path.equals("resources.ap_")) {
            File file = getExternalResourceFile();
            if (file != null) {
                return getCheckSum(file);
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getCheckSum(java.io.File r10) {
        /*
        r8 = 6;
        r7 = "MD5";
        r1 = java.security.MessageDigest.getInstance(r7);	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
        r7 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r7];	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
        r7 = new java.io.FileInputStream;	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
        r7.<init>(r10);	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
        r3.<init>(r7);	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
    L_0x0016:
        r5 = r3.read(r0);	 Catch:{ all -> 0x002a }
        r7 = -1;
        if (r5 != r7) goto L_0x0025;
    L_0x001d:
        r7 = r1.digest();	 Catch:{ all -> 0x002a }
        r3.close();	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
    L_0x0024:
        return r7;
    L_0x0025:
        r7 = 0;
        r1.update(r0, r7, r5);	 Catch:{ all -> 0x002a }
        goto L_0x0016;
    L_0x002a:
        r7 = move-exception;
        r3.close();	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
        throw r7;	 Catch:{ NoSuchAlgorithmException -> 0x002f, IOException -> 0x0044, Throwable -> 0x0069 }
    L_0x002f:
        r2 = move-exception;
        r7 = "InstantRun";
        r7 = android.util.Log.isLoggable(r7, r8);
        if (r7 == 0) goto L_0x0042;
    L_0x0039:
        r7 = "InstantRun";
        r8 = "Couldn't look up message digest";
        android.util.Log.e(r7, r8, r2);
    L_0x0042:
        r7 = 0;
        goto L_0x0024;
    L_0x0044:
        r4 = move-exception;
        r7 = "InstantRun";
        r7 = android.util.Log.isLoggable(r7, r8);
        if (r7 == 0) goto L_0x0042;
    L_0x004e:
        r7 = "InstantRun";
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Failed to read file ";
        r8 = r8.append(r9);
        r8 = r8.append(r10);
        r8 = r8.toString();
        android.util.Log.e(r7, r8, r4);
        goto L_0x0042;
    L_0x0069:
        r6 = move-exception;
        r7 = "InstantRun";
        r7 = android.util.Log.isLoggable(r7, r8);
        if (r7 == 0) goto L_0x0042;
    L_0x0073:
        r7 = "InstantRun";
        r8 = "Unexpected checksum exception";
        android.util.Log.e(r7, r8, r6);
        goto L_0x0042;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.tools.fd.runtime.FileManager.getCheckSum(java.io.File):byte[]");
    }

    public static byte[] readRawBytes(File source) {
        BufferedInputStream input;
        try {
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                Log.v(BootstrapApplication.LOG_TAG, "Reading the bytes for file " + source);
            }
            long length = source.length();
            if (length > 2147483647L) {
                if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                    Log.v(BootstrapApplication.LOG_TAG, "File too large (" + length + ")");
                }
                return null;
            }
            byte[] result = new byte[((int) length)];
            input = new BufferedInputStream(new FileInputStream(source));
            int index = 0;
            int remaining = result.length - 0;
            while (remaining > 0) {
                int numRead = input.read(result, index, remaining);
                if (numRead == -1) {
                    break;
                }
                index += numRead;
                remaining -= numRead;
            }
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                Log.v(BootstrapApplication.LOG_TAG, "Returning length " + result.length + " for file " + source);
            }
            input.close();
            return result;
        } catch (IOException ioe) {
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 6)) {
                Log.e(BootstrapApplication.LOG_TAG, "Failed to read file " + source, ioe);
            }
            if (Log.isLoggable(BootstrapApplication.LOG_TAG, 2)) {
                Log.v(BootstrapApplication.LOG_TAG, "I/O error, no bytes returned for " + source);
            }
            return null;
        } catch (Throwable th) {
            input.close();
        }
    }
}
