package android.support.v4.media.session;

import android.annotation.TargetApi;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.RequiresApi;

@TargetApi(23)
@RequiresApi(23)
class MediaSessionCompatApi23 {

    public interface Callback extends Callback {
        void onPlayFromUri(Uri uri, Bundle bundle);
    }

    static class CallbackProxy<T extends Callback> extends CallbackProxy<T> {
        public CallbackProxy(T callback) {
            super(callback);
        }

        public void onPlayFromUri(Uri uri, Bundle extras) {
            ((Callback) this.mCallback).onPlayFromUri(uri, extras);
        }
    }

    MediaSessionCompatApi23() {
    }

    public static Object createCallback(Callback callback) {
        return new CallbackProxy(callback);
    }
}
