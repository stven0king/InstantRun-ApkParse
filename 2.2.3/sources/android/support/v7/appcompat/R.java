package android.support.v7.appcompat;

import com.android.tools.fd.runtime.IncrementalChange;
import com.android.tools.fd.runtime.InstantReloadException;

public final class R {
    public static volatile transient /* synthetic */ IncrementalChange $change;
    public static final long serialVersionUID = 0;

    public static final class anim {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_fade_in = 2131034112;
        public static final int abc_fade_out = 2131034113;
        public static final int abc_grow_fade_in_from_bottom = 2131034114;
        public static final int abc_popup_enter = 2131034115;
        public static final int abc_popup_exit = 2131034116;
        public static final int abc_shrink_fade_out_from_bottom = 2131034117;
        public static final int abc_slide_in_bottom = 2131034118;
        public static final int abc_slide_in_top = 2131034119;
        public static final int abc_slide_out_bottom = 2131034120;
        public static final int abc_slide_out_top = 2131034121;
        public static final long serialVersionUID = 0;

        anim(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case -1875012668:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$anim"}));
            }
        }

        public static /* synthetic */ Object access$super(anim anim, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$anim"}));
            }
        }

        public anim() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$anim;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$anim;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class attr {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int actionBarDivider = 2130772033;
        public static final int actionBarItemBackground = 2130772034;
        public static final int actionBarPopupTheme = 2130772027;
        public static final int actionBarSize = 2130772032;
        public static final int actionBarSplitStyle = 2130772029;
        public static final int actionBarStyle = 2130772028;
        public static final int actionBarTabBarStyle = 2130772023;
        public static final int actionBarTabStyle = 2130772022;
        public static final int actionBarTabTextStyle = 2130772024;
        public static final int actionBarTheme = 2130772030;
        public static final int actionBarWidgetTheme = 2130772031;
        public static final int actionButtonStyle = 2130772060;
        public static final int actionDropDownStyle = 2130772056;
        public static final int actionLayout = 2130772141;
        public static final int actionMenuTextAppearance = 2130772035;
        public static final int actionMenuTextColor = 2130772036;
        public static final int actionModeBackground = 2130772039;
        public static final int actionModeCloseButtonStyle = 2130772038;
        public static final int actionModeCloseDrawable = 2130772041;
        public static final int actionModeCopyDrawable = 2130772043;
        public static final int actionModeCutDrawable = 2130772042;
        public static final int actionModeFindDrawable = 2130772047;
        public static final int actionModePasteDrawable = 2130772044;
        public static final int actionModePopupWindowStyle = 2130772049;
        public static final int actionModeSelectAllDrawable = 2130772045;
        public static final int actionModeShareDrawable = 2130772046;
        public static final int actionModeSplitBackground = 2130772040;
        public static final int actionModeStyle = 2130772037;
        public static final int actionModeWebSearchDrawable = 2130772048;
        public static final int actionOverflowButtonStyle = 2130772025;
        public static final int actionOverflowMenuStyle = 2130772026;
        public static final int actionProviderClass = 2130772143;
        public static final int actionViewClass = 2130772142;
        public static final int activityChooserViewStyle = 2130772068;
        public static final int alertDialogButtonGroupStyle = 2130772104;
        public static final int alertDialogCenterButtons = 2130772105;
        public static final int alertDialogStyle = 2130772103;
        public static final int alertDialogTheme = 2130772106;
        public static final int allowStacking = 2130772125;
        public static final int alpha = 2130772126;
        public static final int arrowHeadLength = 2130772133;
        public static final int arrowShaftLength = 2130772134;
        public static final int autoCompleteTextViewStyle = 2130772111;
        public static final int background = 2130771980;
        public static final int backgroundSplit = 2130771982;
        public static final int backgroundStacked = 2130771981;
        public static final int backgroundTint = 2130772194;
        public static final int backgroundTintMode = 2130772195;
        public static final int barLength = 2130772135;
        public static final int borderlessButtonStyle = 2130772065;
        public static final int buttonBarButtonStyle = 2130772062;
        public static final int buttonBarNegativeButtonStyle = 2130772109;
        public static final int buttonBarNeutralButtonStyle = 2130772110;
        public static final int buttonBarPositiveButtonStyle = 2130772108;
        public static final int buttonBarStyle = 2130772061;
        public static final int buttonGravity = 2130772183;
        public static final int buttonPanelSideLayout = 2130772001;
        public static final int buttonStyle = 2130772112;
        public static final int buttonStyleSmall = 2130772113;
        public static final int buttonTint = 2130772127;
        public static final int buttonTintMode = 2130772128;
        public static final int checkboxStyle = 2130772114;
        public static final int checkedTextViewStyle = 2130772115;
        public static final int closeIcon = 2130772154;
        public static final int closeItemLayout = 2130771998;
        public static final int collapseContentDescription = 2130772185;
        public static final int collapseIcon = 2130772184;
        public static final int color = 2130772129;
        public static final int colorAccent = 2130772095;
        public static final int colorBackgroundFloating = 2130772102;
        public static final int colorButtonNormal = 2130772099;
        public static final int colorControlActivated = 2130772097;
        public static final int colorControlHighlight = 2130772098;
        public static final int colorControlNormal = 2130772096;
        public static final int colorPrimary = 2130772093;
        public static final int colorPrimaryDark = 2130772094;
        public static final int colorSwitchThumbNormal = 2130772100;
        public static final int commitIcon = 2130772159;
        public static final int contentInsetEnd = 2130771991;
        public static final int contentInsetEndWithActions = 2130771995;
        public static final int contentInsetLeft = 2130771992;
        public static final int contentInsetRight = 2130771993;
        public static final int contentInsetStart = 2130771990;
        public static final int contentInsetStartWithNavigation = 2130771994;
        public static final int controlBackground = 2130772101;
        public static final int customNavigationLayout = 2130771983;
        public static final int defaultQueryHint = 2130772153;
        public static final int dialogPreferredPadding = 2130772054;
        public static final int dialogTheme = 2130772053;
        public static final int displayOptions = 2130771973;
        public static final int divider = 2130771979;
        public static final int dividerHorizontal = 2130772067;
        public static final int dividerPadding = 2130772139;
        public static final int dividerVertical = 2130772066;
        public static final int drawableSize = 2130772131;
        public static final int drawerArrowStyle = 2130771968;
        public static final int dropDownListViewStyle = 2130772085;
        public static final int dropdownListPreferredItemHeight = 2130772057;
        public static final int editTextBackground = 2130772074;
        public static final int editTextColor = 2130772073;
        public static final int editTextStyle = 2130772116;
        public static final int elevation = 2130771996;
        public static final int expandActivityOverflowButtonDrawable = 2130772000;
        public static final int gapBetweenBars = 2130772132;
        public static final int goIcon = 2130772155;
        public static final int height = 2130771969;
        public static final int hideOnContentScroll = 2130771989;
        public static final int homeAsUpIndicator = 2130772059;
        public static final int homeLayout = 2130771984;
        public static final int icon = 2130771977;
        public static final int iconifiedByDefault = 2130772151;
        public static final int imageButtonStyle = 2130772075;
        public static final int indeterminateProgressStyle = 2130771986;
        public static final int initialActivityCount = 2130771999;
        public static final int isLightTheme = 2130771970;
        public static final int itemPadding = 2130771988;
        public static final int layout = 2130772150;
        public static final int listChoiceBackgroundIndicator = 2130772092;
        public static final int listDividerAlertDialog = 2130772055;
        public static final int listItemLayout = 2130772005;
        public static final int listLayout = 2130772002;
        public static final int listMenuViewStyle = 2130772124;
        public static final int listPopupWindowStyle = 2130772086;
        public static final int listPreferredItemHeight = 2130772080;
        public static final int listPreferredItemHeightLarge = 2130772082;
        public static final int listPreferredItemHeightSmall = 2130772081;
        public static final int listPreferredItemPaddingLeft = 2130772083;
        public static final int listPreferredItemPaddingRight = 2130772084;
        public static final int logo = 2130771978;
        public static final int logoDescription = 2130772188;
        public static final int maxButtonHeight = 2130772182;
        public static final int measureWithLargestChild = 2130772137;
        public static final int multiChoiceItemLayout = 2130772003;
        public static final int navigationContentDescription = 2130772187;
        public static final int navigationIcon = 2130772186;
        public static final int navigationMode = 2130771972;
        public static final int overlapAnchor = 2130772146;
        public static final int paddingBottomNoButtons = 2130772148;
        public static final int paddingEnd = 2130772192;
        public static final int paddingStart = 2130772191;
        public static final int paddingTopNoTitle = 2130772149;
        public static final int panelBackground = 2130772089;
        public static final int panelMenuListTheme = 2130772091;
        public static final int panelMenuListWidth = 2130772090;
        public static final int popupMenuStyle = 2130772071;
        public static final int popupTheme = 2130771997;
        public static final int popupWindowStyle = 2130772072;
        public static final int preserveIconSpacing = 2130772144;
        public static final int progressBarPadding = 2130771987;
        public static final int progressBarStyle = 2130771985;
        public static final int queryBackground = 2130772161;
        public static final int queryHint = 2130772152;
        public static final int radioButtonStyle = 2130772117;
        public static final int ratingBarStyle = 2130772118;
        public static final int ratingBarStyleIndicator = 2130772119;
        public static final int ratingBarStyleSmall = 2130772120;
        public static final int searchHintIcon = 2130772157;
        public static final int searchIcon = 2130772156;
        public static final int searchViewStyle = 2130772079;
        public static final int seekBarStyle = 2130772121;
        public static final int selectableItemBackground = 2130772063;
        public static final int selectableItemBackgroundBorderless = 2130772064;
        public static final long serialVersionUID = 0;
        public static final int showAsAction = 2130772140;
        public static final int showDividers = 2130772138;
        public static final int showText = 2130772173;
        public static final int showTitle = 2130772006;
        public static final int singleChoiceItemLayout = 2130772004;
        public static final int spinBars = 2130772130;
        public static final int spinnerDropDownItemStyle = 2130772058;
        public static final int spinnerStyle = 2130772122;
        public static final int splitTrack = 2130772172;
        public static final int srcCompat = 2130772007;
        public static final int state_above_anchor = 2130772147;
        public static final int subMenuArrow = 2130772145;
        public static final int submitBackground = 2130772162;
        public static final int subtitle = 2130771974;
        public static final int subtitleTextAppearance = 2130772175;
        public static final int subtitleTextColor = 2130772190;
        public static final int subtitleTextStyle = 2130771976;
        public static final int suggestionRowLayout = 2130772160;
        public static final int switchMinWidth = 2130772170;
        public static final int switchPadding = 2130772171;
        public static final int switchStyle = 2130772123;
        public static final int switchTextAppearance = 2130772169;
        public static final int textAllCaps = 2130772011;
        public static final int textAppearanceLargePopupMenu = 2130772050;
        public static final int textAppearanceListItem = 2130772087;
        public static final int textAppearanceListItemSmall = 2130772088;
        public static final int textAppearancePopupMenuHeader = 2130772052;
        public static final int textAppearanceSearchResultSubtitle = 2130772077;
        public static final int textAppearanceSearchResultTitle = 2130772076;
        public static final int textAppearanceSmallPopupMenu = 2130772051;
        public static final int textColorAlertDialogListItem = 2130772107;
        public static final int textColorSearchUrl = 2130772078;
        public static final int theme = 2130772193;
        public static final int thickness = 2130772136;
        public static final int thumbTextPadding = 2130772168;
        public static final int thumbTint = 2130772163;
        public static final int thumbTintMode = 2130772164;
        public static final int tickMark = 2130772008;
        public static final int tickMarkTint = 2130772009;
        public static final int tickMarkTintMode = 2130772010;
        public static final int title = 2130771971;
        public static final int titleMargin = 2130772176;
        public static final int titleMarginBottom = 2130772180;
        public static final int titleMarginEnd = 2130772178;
        public static final int titleMarginStart = 2130772177;
        public static final int titleMarginTop = 2130772179;
        public static final int titleMargins = 2130772181;
        public static final int titleTextAppearance = 2130772174;
        public static final int titleTextColor = 2130772189;
        public static final int titleTextStyle = 2130771975;
        public static final int toolbarNavigationButtonStyle = 2130772070;
        public static final int toolbarStyle = 2130772069;
        public static final int track = 2130772165;
        public static final int trackTint = 2130772166;
        public static final int trackTintMode = 2130772167;
        public static final int voiceIcon = 2130772158;
        public static final int windowActionBar = 2130772012;
        public static final int windowActionBarOverlay = 2130772014;
        public static final int windowActionModeOverlay = 2130772015;
        public static final int windowFixedHeightMajor = 2130772019;
        public static final int windowFixedHeightMinor = 2130772017;
        public static final int windowFixedWidthMajor = 2130772016;
        public static final int windowFixedWidthMinor = 2130772018;
        public static final int windowMinWidthMajor = 2130772020;
        public static final int windowMinWidthMinor = 2130772021;
        public static final int windowNoTitle = 2130772013;

        attr(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case -525419612:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$attr"}));
            }
        }

        public static /* synthetic */ Object access$super(attr attr, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$attr"}));
            }
        }

        public attr() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$attr;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$attr;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class bool {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_action_bar_embed_tabs = 2131296256;
        public static final int abc_allow_stacked_button_bar = 2131296257;
        public static final int abc_config_actionMenuItemAllCaps = 2131296258;
        public static final int abc_config_closeDialogWhenTouchOutside = 2131296259;
        public static final int abc_config_showMenuShortcutsWhenKeyboardPresent = 2131296260;
        public static final long serialVersionUID = 0;

        bool(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case 926152733:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$bool"}));
            }
        }

        public static /* synthetic */ Object access$super(bool bool, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$bool"}));
            }
        }

        public bool() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$bool;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$bool;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class color {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_background_cache_hint_selector_material_dark = 2131361855;
        public static final int abc_background_cache_hint_selector_material_light = 2131361856;
        public static final int abc_btn_colored_borderless_text_material = 2131361857;
        public static final int abc_btn_colored_text_material = 2131361858;
        public static final int abc_color_highlight_material = 2131361859;
        public static final int abc_hint_foreground_material_dark = 2131361860;
        public static final int abc_hint_foreground_material_light = 2131361861;
        public static final int abc_input_method_navigation_guard = 2131361793;
        public static final int abc_primary_text_disable_only_material_dark = 2131361862;
        public static final int abc_primary_text_disable_only_material_light = 2131361863;
        public static final int abc_primary_text_material_dark = 2131361864;
        public static final int abc_primary_text_material_light = 2131361865;
        public static final int abc_search_url_text = 2131361866;
        public static final int abc_search_url_text_normal = 2131361794;
        public static final int abc_search_url_text_pressed = 2131361795;
        public static final int abc_search_url_text_selected = 2131361796;
        public static final int abc_secondary_text_material_dark = 2131361867;
        public static final int abc_secondary_text_material_light = 2131361868;
        public static final int abc_tint_btn_checkable = 2131361869;
        public static final int abc_tint_default = 2131361870;
        public static final int abc_tint_edittext = 2131361871;
        public static final int abc_tint_seek_thumb = 2131361872;
        public static final int abc_tint_spinner = 2131361873;
        public static final int abc_tint_switch_thumb = 2131361874;
        public static final int abc_tint_switch_track = 2131361875;
        public static final int accent_material_dark = 2131361797;
        public static final int accent_material_light = 2131361798;
        public static final int background_floating_material_dark = 2131361799;
        public static final int background_floating_material_light = 2131361800;
        public static final int background_material_dark = 2131361801;
        public static final int background_material_light = 2131361802;
        public static final int bright_foreground_disabled_material_dark = 2131361803;
        public static final int bright_foreground_disabled_material_light = 2131361804;
        public static final int bright_foreground_inverse_material_dark = 2131361805;
        public static final int bright_foreground_inverse_material_light = 2131361806;
        public static final int bright_foreground_material_dark = 2131361807;
        public static final int bright_foreground_material_light = 2131361808;
        public static final int button_material_dark = 2131361809;
        public static final int button_material_light = 2131361810;
        public static final int dim_foreground_disabled_material_dark = 2131361814;
        public static final int dim_foreground_disabled_material_light = 2131361815;
        public static final int dim_foreground_material_dark = 2131361816;
        public static final int dim_foreground_material_light = 2131361817;
        public static final int foreground_material_dark = 2131361818;
        public static final int foreground_material_light = 2131361819;
        public static final int highlighted_text_material_dark = 2131361820;
        public static final int highlighted_text_material_light = 2131361821;
        public static final int material_blue_grey_800 = 2131361822;
        public static final int material_blue_grey_900 = 2131361823;
        public static final int material_blue_grey_950 = 2131361824;
        public static final int material_deep_teal_200 = 2131361825;
        public static final int material_deep_teal_500 = 2131361826;
        public static final int material_grey_100 = 2131361827;
        public static final int material_grey_300 = 2131361828;
        public static final int material_grey_50 = 2131361829;
        public static final int material_grey_600 = 2131361830;
        public static final int material_grey_800 = 2131361831;
        public static final int material_grey_850 = 2131361832;
        public static final int material_grey_900 = 2131361833;
        public static final int notification_action_color_filter = 2131361792;
        public static final int notification_icon_bg_color = 2131361834;
        public static final int notification_material_background_media_default_color = 2131361835;
        public static final int primary_dark_material_dark = 2131361836;
        public static final int primary_dark_material_light = 2131361837;
        public static final int primary_material_dark = 2131361838;
        public static final int primary_material_light = 2131361839;
        public static final int primary_text_default_material_dark = 2131361840;
        public static final int primary_text_default_material_light = 2131361841;
        public static final int primary_text_disabled_material_dark = 2131361842;
        public static final int primary_text_disabled_material_light = 2131361843;
        public static final int ripple_material_dark = 2131361844;
        public static final int ripple_material_light = 2131361845;
        public static final int secondary_text_default_material_dark = 2131361846;
        public static final int secondary_text_default_material_light = 2131361847;
        public static final int secondary_text_disabled_material_dark = 2131361848;
        public static final int secondary_text_disabled_material_light = 2131361849;
        public static final long serialVersionUID = 0;
        public static final int switch_thumb_disabled_material_dark = 2131361850;
        public static final int switch_thumb_disabled_material_light = 2131361851;
        public static final int switch_thumb_material_dark = 2131361876;
        public static final int switch_thumb_material_light = 2131361877;
        public static final int switch_thumb_normal_material_dark = 2131361852;
        public static final int switch_thumb_normal_material_light = 2131361853;

        color(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case -1380171202:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$color"}));
            }
        }

        public static /* synthetic */ Object access$super(color color, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$color"}));
            }
        }

        public color() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$color;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$color;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class dimen {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_action_bar_content_inset_material = 2131165196;
        public static final int abc_action_bar_content_inset_with_nav = 2131165197;
        public static final int abc_action_bar_default_height_material = 2131165185;
        public static final int abc_action_bar_default_padding_end_material = 2131165198;
        public static final int abc_action_bar_default_padding_start_material = 2131165199;
        public static final int abc_action_bar_elevation_material = 2131165206;
        public static final int abc_action_bar_icon_vertical_padding_material = 2131165207;
        public static final int abc_action_bar_overflow_padding_end_material = 2131165208;
        public static final int abc_action_bar_overflow_padding_start_material = 2131165209;
        public static final int abc_action_bar_progress_bar_size = 2131165186;
        public static final int abc_action_bar_stacked_max_height = 2131165210;
        public static final int abc_action_bar_stacked_tab_max_width = 2131165211;
        public static final int abc_action_bar_subtitle_bottom_margin_material = 2131165212;
        public static final int abc_action_bar_subtitle_top_margin_material = 2131165213;
        public static final int abc_action_button_min_height_material = 2131165214;
        public static final int abc_action_button_min_width_material = 2131165215;
        public static final int abc_action_button_min_width_overflow_material = 2131165216;
        public static final int abc_alert_dialog_button_bar_height = 2131165184;
        public static final int abc_button_inset_horizontal_material = 2131165217;
        public static final int abc_button_inset_vertical_material = 2131165218;
        public static final int abc_button_padding_horizontal_material = 2131165219;
        public static final int abc_button_padding_vertical_material = 2131165220;
        public static final int abc_cascading_menus_min_smallest_width = 2131165221;
        public static final int abc_config_prefDialogWidth = 2131165189;
        public static final int abc_control_corner_material = 2131165222;
        public static final int abc_control_inset_material = 2131165223;
        public static final int abc_control_padding_material = 2131165224;
        public static final int abc_dialog_fixed_height_major = 2131165190;
        public static final int abc_dialog_fixed_height_minor = 2131165191;
        public static final int abc_dialog_fixed_width_major = 2131165192;
        public static final int abc_dialog_fixed_width_minor = 2131165193;
        public static final int abc_dialog_list_padding_bottom_no_buttons = 2131165225;
        public static final int abc_dialog_list_padding_top_no_title = 2131165226;
        public static final int abc_dialog_min_width_major = 2131165194;
        public static final int abc_dialog_min_width_minor = 2131165195;
        public static final int abc_dialog_padding_material = 2131165227;
        public static final int abc_dialog_padding_top_material = 2131165228;
        public static final int abc_dialog_title_divider_material = 2131165229;
        public static final int abc_disabled_alpha_material_dark = 2131165230;
        public static final int abc_disabled_alpha_material_light = 2131165231;
        public static final int abc_dropdownitem_icon_width = 2131165232;
        public static final int abc_dropdownitem_text_padding_left = 2131165233;
        public static final int abc_dropdownitem_text_padding_right = 2131165234;
        public static final int abc_edit_text_inset_bottom_material = 2131165235;
        public static final int abc_edit_text_inset_horizontal_material = 2131165236;
        public static final int abc_edit_text_inset_top_material = 2131165237;
        public static final int abc_floating_window_z = 2131165238;
        public static final int abc_list_item_padding_horizontal_material = 2131165239;
        public static final int abc_panel_menu_list_width = 2131165240;
        public static final int abc_progress_bar_height_material = 2131165241;
        public static final int abc_search_view_preferred_height = 2131165242;
        public static final int abc_search_view_preferred_width = 2131165243;
        public static final int abc_seekbar_track_background_height_material = 2131165244;
        public static final int abc_seekbar_track_progress_height_material = 2131165245;
        public static final int abc_select_dialog_padding_start_material = 2131165246;
        public static final int abc_switch_padding = 2131165201;
        public static final int abc_text_size_body_1_material = 2131165247;
        public static final int abc_text_size_body_2_material = 2131165248;
        public static final int abc_text_size_button_material = 2131165249;
        public static final int abc_text_size_caption_material = 2131165250;
        public static final int abc_text_size_display_1_material = 2131165251;
        public static final int abc_text_size_display_2_material = 2131165252;
        public static final int abc_text_size_display_3_material = 2131165253;
        public static final int abc_text_size_display_4_material = 2131165254;
        public static final int abc_text_size_headline_material = 2131165255;
        public static final int abc_text_size_large_material = 2131165256;
        public static final int abc_text_size_medium_material = 2131165257;
        public static final int abc_text_size_menu_header_material = 2131165258;
        public static final int abc_text_size_menu_material = 2131165259;
        public static final int abc_text_size_small_material = 2131165260;
        public static final int abc_text_size_subhead_material = 2131165261;
        public static final int abc_text_size_subtitle_material_toolbar = 2131165187;
        public static final int abc_text_size_title_material = 2131165262;
        public static final int abc_text_size_title_material_toolbar = 2131165188;
        public static final int disabled_alpha_material_dark = 2131165264;
        public static final int disabled_alpha_material_light = 2131165265;
        public static final int highlight_alpha_material_colored = 2131165266;
        public static final int highlight_alpha_material_dark = 2131165267;
        public static final int highlight_alpha_material_light = 2131165268;
        public static final int hint_alpha_material_dark = 2131165269;
        public static final int hint_alpha_material_light = 2131165270;
        public static final int hint_pressed_alpha_material_dark = 2131165271;
        public static final int hint_pressed_alpha_material_light = 2131165272;
        public static final int notification_action_icon_size = 2131165273;
        public static final int notification_action_text_size = 2131165274;
        public static final int notification_big_circle_margin = 2131165275;
        public static final int notification_content_margin_start = 2131165202;
        public static final int notification_large_icon_height = 2131165276;
        public static final int notification_large_icon_width = 2131165277;
        public static final int notification_main_column_padding_top = 2131165203;
        public static final int notification_media_narrow_margin = 2131165204;
        public static final int notification_right_icon_size = 2131165278;
        public static final int notification_right_side_padding_top = 2131165200;
        public static final int notification_small_icon_background_padding = 2131165279;
        public static final int notification_small_icon_size_as_large = 2131165280;
        public static final int notification_subtext_size = 2131165281;
        public static final int notification_top_pad = 2131165282;
        public static final int notification_top_pad_large_text = 2131165283;
        public static final long serialVersionUID = 0;

        dimen(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case -162067700:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$dimen"}));
            }
        }

        public static /* synthetic */ Object access$super(dimen dimen, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$dimen"}));
            }
        }

        public dimen() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$dimen;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$dimen;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class drawable {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_ab_share_pack_mtrl_alpha = 2130837504;
        public static final int abc_action_bar_item_background_material = 2130837505;
        public static final int abc_btn_borderless_material = 2130837506;
        public static final int abc_btn_check_material = 2130837507;
        public static final int abc_btn_check_to_on_mtrl_000 = 2130837508;
        public static final int abc_btn_check_to_on_mtrl_015 = 2130837509;
        public static final int abc_btn_colored_material = 2130837510;
        public static final int abc_btn_default_mtrl_shape = 2130837511;
        public static final int abc_btn_radio_material = 2130837512;
        public static final int abc_btn_radio_to_on_mtrl_000 = 2130837513;
        public static final int abc_btn_radio_to_on_mtrl_015 = 2130837514;
        public static final int abc_btn_switch_to_on_mtrl_00001 = 2130837515;
        public static final int abc_btn_switch_to_on_mtrl_00012 = 2130837516;
        public static final int abc_cab_background_internal_bg = 2130837517;
        public static final int abc_cab_background_top_material = 2130837518;
        public static final int abc_cab_background_top_mtrl_alpha = 2130837519;
        public static final int abc_control_background_material = 2130837520;
        public static final int abc_dialog_material_background = 2130837521;
        public static final int abc_edit_text_material = 2130837522;
        public static final int abc_ic_ab_back_material = 2130837523;
        public static final int abc_ic_arrow_drop_right_black_24dp = 2130837524;
        public static final int abc_ic_clear_material = 2130837525;
        public static final int abc_ic_commit_search_api_mtrl_alpha = 2130837526;
        public static final int abc_ic_go_search_api_material = 2130837527;
        public static final int abc_ic_menu_copy_mtrl_am_alpha = 2130837528;
        public static final int abc_ic_menu_cut_mtrl_alpha = 2130837529;
        public static final int abc_ic_menu_overflow_material = 2130837530;
        public static final int abc_ic_menu_paste_mtrl_am_alpha = 2130837531;
        public static final int abc_ic_menu_selectall_mtrl_alpha = 2130837532;
        public static final int abc_ic_menu_share_mtrl_alpha = 2130837533;
        public static final int abc_ic_search_api_material = 2130837534;
        public static final int abc_ic_star_black_16dp = 2130837535;
        public static final int abc_ic_star_black_36dp = 2130837536;
        public static final int abc_ic_star_black_48dp = 2130837537;
        public static final int abc_ic_star_half_black_16dp = 2130837538;
        public static final int abc_ic_star_half_black_36dp = 2130837539;
        public static final int abc_ic_star_half_black_48dp = 2130837540;
        public static final int abc_ic_voice_search_api_material = 2130837541;
        public static final int abc_item_background_holo_dark = 2130837542;
        public static final int abc_item_background_holo_light = 2130837543;
        public static final int abc_list_divider_mtrl_alpha = 2130837544;
        public static final int abc_list_focused_holo = 2130837545;
        public static final int abc_list_longpressed_holo = 2130837546;
        public static final int abc_list_pressed_holo_dark = 2130837547;
        public static final int abc_list_pressed_holo_light = 2130837548;
        public static final int abc_list_selector_background_transition_holo_dark = 2130837549;
        public static final int abc_list_selector_background_transition_holo_light = 2130837550;
        public static final int abc_list_selector_disabled_holo_dark = 2130837551;
        public static final int abc_list_selector_disabled_holo_light = 2130837552;
        public static final int abc_list_selector_holo_dark = 2130837553;
        public static final int abc_list_selector_holo_light = 2130837554;
        public static final int abc_menu_hardkey_panel_mtrl_mult = 2130837555;
        public static final int abc_popup_background_mtrl_mult = 2130837556;
        public static final int abc_ratingbar_indicator_material = 2130837557;
        public static final int abc_ratingbar_material = 2130837558;
        public static final int abc_ratingbar_small_material = 2130837559;
        public static final int abc_scrubber_control_off_mtrl_alpha = 2130837560;
        public static final int abc_scrubber_control_to_pressed_mtrl_000 = 2130837561;
        public static final int abc_scrubber_control_to_pressed_mtrl_005 = 2130837562;
        public static final int abc_scrubber_primary_mtrl_alpha = 2130837563;
        public static final int abc_scrubber_track_mtrl_alpha = 2130837564;
        public static final int abc_seekbar_thumb_material = 2130837565;
        public static final int abc_seekbar_tick_mark_material = 2130837566;
        public static final int abc_seekbar_track_material = 2130837567;
        public static final int abc_spinner_mtrl_am_alpha = 2130837568;
        public static final int abc_spinner_textfield_background_material = 2130837569;
        public static final int abc_switch_thumb_material = 2130837570;
        public static final int abc_switch_track_mtrl_alpha = 2130837571;
        public static final int abc_tab_indicator_material = 2130837572;
        public static final int abc_tab_indicator_mtrl_alpha = 2130837573;
        public static final int abc_text_cursor_material = 2130837574;
        public static final int abc_text_select_handle_left_mtrl_dark = 2130837575;
        public static final int abc_text_select_handle_left_mtrl_light = 2130837576;
        public static final int abc_text_select_handle_middle_mtrl_dark = 2130837577;
        public static final int abc_text_select_handle_middle_mtrl_light = 2130837578;
        public static final int abc_text_select_handle_right_mtrl_dark = 2130837579;
        public static final int abc_text_select_handle_right_mtrl_light = 2130837580;
        public static final int abc_textfield_activated_mtrl_alpha = 2130837581;
        public static final int abc_textfield_default_mtrl_alpha = 2130837582;
        public static final int abc_textfield_search_activated_mtrl_alpha = 2130837583;
        public static final int abc_textfield_search_default_mtrl_alpha = 2130837584;
        public static final int abc_textfield_search_material = 2130837585;
        public static final int abc_vector_test = 2130837586;
        public static final int notification_action_background = 2130837588;
        public static final int notification_bg = 2130837589;
        public static final int notification_bg_low = 2130837590;
        public static final int notification_bg_low_normal = 2130837591;
        public static final int notification_bg_low_pressed = 2130837592;
        public static final int notification_bg_normal = 2130837593;
        public static final int notification_bg_normal_pressed = 2130837594;
        public static final int notification_icon_background = 2130837595;
        public static final int notification_template_icon_bg = 2130837599;
        public static final int notification_template_icon_low_bg = 2130837600;
        public static final int notification_tile_bg = 2130837596;
        public static final int notify_panel_notification_icon_bg = 2130837597;
        public static final long serialVersionUID = 0;

        drawable(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case 5344721:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$drawable"}));
            }
        }

        public static /* synthetic */ Object access$super(drawable drawable, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$drawable"}));
            }
        }

        public drawable() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$drawable;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$drawable;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class id {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int action0 = 2131427419;
        public static final int action_bar = 2131427399;
        public static final int action_bar_activity_content = 2131427328;
        public static final int action_bar_container = 2131427398;
        public static final int action_bar_root = 2131427394;
        public static final int action_bar_spinner = 2131427329;
        public static final int action_bar_subtitle = 2131427365;
        public static final int action_bar_title = 2131427364;
        public static final int action_container = 2131427416;
        public static final int action_context_bar = 2131427400;
        public static final int action_divider = 2131427423;
        public static final int action_image = 2131427417;
        public static final int action_menu_divider = 2131427330;
        public static final int action_menu_presenter = 2131427331;
        public static final int action_mode_bar = 2131427396;
        public static final int action_mode_bar_stub = 2131427395;
        public static final int action_mode_close_button = 2131427366;
        public static final int action_text = 2131427418;
        public static final int actions = 2131427432;
        public static final int activity_chooser_view_content = 2131427367;
        public static final int add = 2131427347;
        public static final int alertTitle = 2131427387;
        public static final int always = 2131427357;
        public static final int beginning = 2131427354;
        public static final int bottom = 2131427362;
        public static final int buttonPanel = 2131427374;
        public static final int cancel_action = 2131427420;
        public static final int checkbox = 2131427390;
        public static final int chronometer = 2131427428;
        public static final int collapseActionView = 2131427358;
        public static final int contentPanel = 2131427377;
        public static final int custom = 2131427384;
        public static final int customPanel = 2131427383;
        public static final int decor_content_parent = 2131427397;
        public static final int default_activity_button = 2131427370;
        public static final int disableHome = 2131427340;
        public static final int edit_query = 2131427401;
        public static final int end = 2131427355;
        public static final int end_padder = 2131427437;
        public static final int expand_activities_button = 2131427368;
        public static final int expanded_menu = 2131427389;
        public static final int home = 2131427332;
        public static final int homeAsUp = 2131427341;
        public static final int icon = 2131427372;
        public static final int icon_group = 2131427433;
        public static final int ifRoom = 2131427359;
        public static final int image = 2131427369;
        public static final int info = 2131427429;
        public static final int line1 = 2131427434;
        public static final int line3 = 2131427436;
        public static final int listMode = 2131427337;
        public static final int list_item = 2131427371;
        public static final int media_actions = 2131427422;
        public static final int middle = 2131427356;
        public static final int multiply = 2131427348;
        public static final int never = 2131427360;
        public static final int none = 2131427342;
        public static final int normal = 2131427338;
        public static final int notification_background = 2131427431;
        public static final int notification_main_column = 2131427425;
        public static final int notification_main_column_container = 2131427424;
        public static final int parentPanel = 2131427376;
        public static final int progress_circular = 2131427333;
        public static final int progress_horizontal = 2131427334;
        public static final int radio = 2131427392;
        public static final int right_icon = 2131427430;
        public static final int right_side = 2131427426;
        public static final int screen = 2131427349;
        public static final int scrollIndicatorDown = 2131427382;
        public static final int scrollIndicatorUp = 2131427378;
        public static final int scrollView = 2131427379;
        public static final int search_badge = 2131427403;
        public static final int search_bar = 2131427402;
        public static final int search_button = 2131427404;
        public static final int search_close_btn = 2131427409;
        public static final int search_edit_frame = 2131427405;
        public static final int search_go_btn = 2131427411;
        public static final int search_mag_icon = 2131427406;
        public static final int search_plate = 2131427407;
        public static final int search_src_text = 2131427408;
        public static final int search_voice_btn = 2131427412;
        public static final int select_dialog_listview = 2131427413;
        public static final long serialVersionUID = 0;
        public static final int shortcut = 2131427391;
        public static final int showCustom = 2131427343;
        public static final int showHome = 2131427344;
        public static final int showTitle = 2131427345;
        public static final int spacer = 2131427375;
        public static final int split_action_bar = 2131427335;
        public static final int src_atop = 2131427350;
        public static final int src_in = 2131427351;
        public static final int src_over = 2131427352;
        public static final int status_bar_latest_event_content = 2131427421;
        public static final int submenuarrow = 2131427393;
        public static final int submit_area = 2131427410;
        public static final int tabMode = 2131427339;
        public static final int text = 2131427415;
        public static final int text2 = 2131427435;
        public static final int textSpacerNoButtons = 2131427381;
        public static final int textSpacerNoTitle = 2131427380;
        public static final int time = 2131427427;
        public static final int title = 2131427373;
        public static final int titleDividerNoCustom = 2131427388;
        public static final int title_template = 2131427386;
        public static final int top = 2131427363;
        public static final int topPanel = 2131427385;
        public static final int up = 2131427336;
        public static final int useLogo = 2131427346;
        public static final int withText = 2131427361;
        public static final int wrap_content = 2131427353;

        id(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case 90883278:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$id"}));
            }
        }

        public static /* synthetic */ Object access$super(id idVar, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$id"}));
            }
        }

        public id() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$id;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$id;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class integer {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_config_activityDefaultDur = 2131492864;
        public static final int abc_config_activityShortDur = 2131492865;
        public static final int cancel_button_image_alpha = 2131492866;
        public static final long serialVersionUID = 0;
        public static final int status_bar_notification_info_maxnum = 2131492867;

        integer(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case 1747552665:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$integer"}));
            }
        }

        public static /* synthetic */ Object access$super(integer integer, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$integer"}));
            }
        }

        public integer() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$integer;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$integer;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class layout {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_action_bar_title_item = 2130968576;
        public static final int abc_action_bar_up_container = 2130968577;
        public static final int abc_action_bar_view_list_nav_layout = 2130968578;
        public static final int abc_action_menu_item_layout = 2130968579;
        public static final int abc_action_menu_layout = 2130968580;
        public static final int abc_action_mode_bar = 2130968581;
        public static final int abc_action_mode_close_item_material = 2130968582;
        public static final int abc_activity_chooser_view = 2130968583;
        public static final int abc_activity_chooser_view_list_item = 2130968584;
        public static final int abc_alert_dialog_button_bar_material = 2130968585;
        public static final int abc_alert_dialog_material = 2130968586;
        public static final int abc_alert_dialog_title_material = 2130968587;
        public static final int abc_dialog_title_material = 2130968588;
        public static final int abc_expanded_menu_layout = 2130968589;
        public static final int abc_list_menu_item_checkbox = 2130968590;
        public static final int abc_list_menu_item_icon = 2130968591;
        public static final int abc_list_menu_item_layout = 2130968592;
        public static final int abc_list_menu_item_radio = 2130968593;
        public static final int abc_popup_menu_header_item_layout = 2130968594;
        public static final int abc_popup_menu_item_layout = 2130968595;
        public static final int abc_screen_content_include = 2130968596;
        public static final int abc_screen_simple = 2130968597;
        public static final int abc_screen_simple_overlay_action_mode = 2130968598;
        public static final int abc_screen_toolbar = 2130968599;
        public static final int abc_search_dropdown_item_icons_2line = 2130968600;
        public static final int abc_search_view = 2130968601;
        public static final int abc_select_dialog_material = 2130968602;
        public static final int notification_action = 2130968604;
        public static final int notification_action_tombstone = 2130968605;
        public static final int notification_media_action = 2130968606;
        public static final int notification_media_cancel_action = 2130968607;
        public static final int notification_template_big_media = 2130968608;
        public static final int notification_template_big_media_custom = 2130968609;
        public static final int notification_template_big_media_narrow = 2130968610;
        public static final int notification_template_big_media_narrow_custom = 2130968611;
        public static final int notification_template_custom_big = 2130968612;
        public static final int notification_template_icon_group = 2130968613;
        public static final int notification_template_lines_media = 2130968614;
        public static final int notification_template_media = 2130968615;
        public static final int notification_template_media_custom = 2130968616;
        public static final int notification_template_part_chronometer = 2130968617;
        public static final int notification_template_part_time = 2130968618;
        public static final int select_dialog_item_material = 2130968619;
        public static final int select_dialog_multichoice_material = 2130968620;
        public static final int select_dialog_singlechoice_material = 2130968621;
        public static final long serialVersionUID = 0;
        public static final int support_simple_spinner_dropdown_item = 2130968622;

        layout(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case -737288867:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$layout"}));
            }
        }

        public static /* synthetic */ Object access$super(layout layout, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$layout"}));
            }
        }

        public layout() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$layout;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$layout;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class string {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int abc_action_bar_home_description = 2131099648;
        public static final int abc_action_bar_home_description_format = 2131099649;
        public static final int abc_action_bar_home_subtitle_description_format = 2131099650;
        public static final int abc_action_bar_up_description = 2131099651;
        public static final int abc_action_menu_overflow_description = 2131099652;
        public static final int abc_action_mode_done = 2131099653;
        public static final int abc_activity_chooser_view_see_all = 2131099654;
        public static final int abc_activitychooserview_choose_application = 2131099655;
        public static final int abc_capital_off = 2131099656;
        public static final int abc_capital_on = 2131099657;
        public static final int abc_font_family_body_1_material = 2131099669;
        public static final int abc_font_family_body_2_material = 2131099670;
        public static final int abc_font_family_button_material = 2131099671;
        public static final int abc_font_family_caption_material = 2131099672;
        public static final int abc_font_family_display_1_material = 2131099673;
        public static final int abc_font_family_display_2_material = 2131099674;
        public static final int abc_font_family_display_3_material = 2131099675;
        public static final int abc_font_family_display_4_material = 2131099676;
        public static final int abc_font_family_headline_material = 2131099677;
        public static final int abc_font_family_menu_material = 2131099678;
        public static final int abc_font_family_subhead_material = 2131099679;
        public static final int abc_font_family_title_material = 2131099680;
        public static final int abc_search_hint = 2131099658;
        public static final int abc_searchview_description_clear = 2131099659;
        public static final int abc_searchview_description_query = 2131099660;
        public static final int abc_searchview_description_search = 2131099661;
        public static final int abc_searchview_description_submit = 2131099662;
        public static final int abc_searchview_description_voice = 2131099663;
        public static final int abc_shareactionprovider_share_with = 2131099664;
        public static final int abc_shareactionprovider_share_with_application = 2131099665;
        public static final int abc_toolbar_collapse_description = 2131099666;
        public static final int search_menu_title = 2131099667;
        public static final long serialVersionUID = 0;
        public static final int status_bar_notification_info_overflow = 2131099668;

        string(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case 1642952388:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$string"}));
            }
        }

        public static /* synthetic */ Object access$super(string string, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$string"}));
            }
        }

        public string() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$string;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$string;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class style {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int AlertDialog_AppCompat = 2131230879;
        public static final int AlertDialog_AppCompat_Light = 2131230880;
        public static final int Animation_AppCompat_Dialog = 2131230881;
        public static final int Animation_AppCompat_DropDownUp = 2131230882;
        public static final int Base_AlertDialog_AppCompat = 2131230884;
        public static final int Base_AlertDialog_AppCompat_Light = 2131230885;
        public static final int Base_Animation_AppCompat_Dialog = 2131230886;
        public static final int Base_Animation_AppCompat_DropDownUp = 2131230887;
        public static final int Base_DialogWindowTitleBackground_AppCompat = 2131230889;
        public static final int Base_DialogWindowTitle_AppCompat = 2131230888;
        public static final int Base_TextAppearance_AppCompat = 2131230783;
        public static final int Base_TextAppearance_AppCompat_Body1 = 2131230784;
        public static final int Base_TextAppearance_AppCompat_Body2 = 2131230785;
        public static final int Base_TextAppearance_AppCompat_Button = 2131230759;
        public static final int Base_TextAppearance_AppCompat_Caption = 2131230786;
        public static final int Base_TextAppearance_AppCompat_Display1 = 2131230787;
        public static final int Base_TextAppearance_AppCompat_Display2 = 2131230788;
        public static final int Base_TextAppearance_AppCompat_Display3 = 2131230789;
        public static final int Base_TextAppearance_AppCompat_Display4 = 2131230790;
        public static final int Base_TextAppearance_AppCompat_Headline = 2131230791;
        public static final int Base_TextAppearance_AppCompat_Inverse = 2131230731;
        public static final int Base_TextAppearance_AppCompat_Large = 2131230792;
        public static final int Base_TextAppearance_AppCompat_Large_Inverse = 2131230732;
        public static final int Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Large = 2131230793;
        public static final int Base_TextAppearance_AppCompat_Light_Widget_PopupMenu_Small = 2131230794;
        public static final int Base_TextAppearance_AppCompat_Medium = 2131230795;
        public static final int Base_TextAppearance_AppCompat_Medium_Inverse = 2131230733;
        public static final int Base_TextAppearance_AppCompat_Menu = 2131230796;
        public static final int Base_TextAppearance_AppCompat_SearchResult = 2131230890;
        public static final int Base_TextAppearance_AppCompat_SearchResult_Subtitle = 2131230797;
        public static final int Base_TextAppearance_AppCompat_SearchResult_Title = 2131230798;
        public static final int Base_TextAppearance_AppCompat_Small = 2131230799;
        public static final int Base_TextAppearance_AppCompat_Small_Inverse = 2131230734;
        public static final int Base_TextAppearance_AppCompat_Subhead = 2131230800;
        public static final int Base_TextAppearance_AppCompat_Subhead_Inverse = 2131230735;
        public static final int Base_TextAppearance_AppCompat_Title = 2131230801;
        public static final int Base_TextAppearance_AppCompat_Title_Inverse = 2131230736;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Menu = 2131230868;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle = 2131230802;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse = 2131230803;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Title = 2131230804;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse = 2131230805;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionMode_Subtitle = 2131230806;
        public static final int Base_TextAppearance_AppCompat_Widget_ActionMode_Title = 2131230807;
        public static final int Base_TextAppearance_AppCompat_Widget_Button = 2131230808;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Borderless_Colored = 2131230875;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Colored = 2131230876;
        public static final int Base_TextAppearance_AppCompat_Widget_Button_Inverse = 2131230869;
        public static final int Base_TextAppearance_AppCompat_Widget_DropDownItem = 2131230891;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Header = 2131230809;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Large = 2131230810;
        public static final int Base_TextAppearance_AppCompat_Widget_PopupMenu_Small = 2131230811;
        public static final int Base_TextAppearance_AppCompat_Widget_Switch = 2131230812;
        public static final int Base_TextAppearance_AppCompat_Widget_TextView_SpinnerItem = 2131230813;
        public static final int Base_TextAppearance_Widget_AppCompat_ExpandedMenu_Item = 2131230892;
        public static final int Base_TextAppearance_Widget_AppCompat_Toolbar_Subtitle = 2131230814;
        public static final int Base_TextAppearance_Widget_AppCompat_Toolbar_Title = 2131230815;
        public static final int Base_ThemeOverlay_AppCompat = 2131230897;
        public static final int Base_ThemeOverlay_AppCompat_ActionBar = 2131230898;
        public static final int Base_ThemeOverlay_AppCompat_Dark = 2131230899;
        public static final int Base_ThemeOverlay_AppCompat_Dark_ActionBar = 2131230900;
        public static final int Base_ThemeOverlay_AppCompat_Dialog = 2131230743;
        public static final int Base_ThemeOverlay_AppCompat_Dialog_Alert = 2131230744;
        public static final int Base_ThemeOverlay_AppCompat_Light = 2131230901;
        public static final int Base_Theme_AppCompat = 2131230816;
        public static final int Base_Theme_AppCompat_CompactMenu = 2131230893;
        public static final int Base_Theme_AppCompat_Dialog = 2131230737;
        public static final int Base_Theme_AppCompat_DialogWhenLarge = 2131230721;
        public static final int Base_Theme_AppCompat_Dialog_Alert = 2131230738;
        public static final int Base_Theme_AppCompat_Dialog_FixedSize = 2131230894;
        public static final int Base_Theme_AppCompat_Dialog_MinWidth = 2131230739;
        public static final int Base_Theme_AppCompat_Light = 2131230817;
        public static final int Base_Theme_AppCompat_Light_DarkActionBar = 2131230895;
        public static final int Base_Theme_AppCompat_Light_Dialog = 2131230740;
        public static final int Base_Theme_AppCompat_Light_DialogWhenLarge = 2131230722;
        public static final int Base_Theme_AppCompat_Light_Dialog_Alert = 2131230741;
        public static final int Base_Theme_AppCompat_Light_Dialog_FixedSize = 2131230896;
        public static final int Base_Theme_AppCompat_Light_Dialog_MinWidth = 2131230742;
        public static final int Base_V11_ThemeOverlay_AppCompat_Dialog = 2131230747;
        public static final int Base_V11_Theme_AppCompat_Dialog = 2131230745;
        public static final int Base_V11_Theme_AppCompat_Light_Dialog = 2131230746;
        public static final int Base_V12_Widget_AppCompat_AutoCompleteTextView = 2131230755;
        public static final int Base_V12_Widget_AppCompat_EditText = 2131230756;
        public static final int Base_V21_ThemeOverlay_AppCompat_Dialog = 2131230822;
        public static final int Base_V21_Theme_AppCompat = 2131230818;
        public static final int Base_V21_Theme_AppCompat_Dialog = 2131230819;
        public static final int Base_V21_Theme_AppCompat_Light = 2131230820;
        public static final int Base_V21_Theme_AppCompat_Light_Dialog = 2131230821;
        public static final int Base_V22_Theme_AppCompat = 2131230866;
        public static final int Base_V22_Theme_AppCompat_Light = 2131230867;
        public static final int Base_V23_Theme_AppCompat = 2131230870;
        public static final int Base_V23_Theme_AppCompat_Light = 2131230871;
        public static final int Base_V7_ThemeOverlay_AppCompat_Dialog = 2131230906;
        public static final int Base_V7_Theme_AppCompat = 2131230902;
        public static final int Base_V7_Theme_AppCompat_Dialog = 2131230903;
        public static final int Base_V7_Theme_AppCompat_Light = 2131230904;
        public static final int Base_V7_Theme_AppCompat_Light_Dialog = 2131230905;
        public static final int Base_V7_Widget_AppCompat_AutoCompleteTextView = 2131230907;
        public static final int Base_V7_Widget_AppCompat_EditText = 2131230908;
        public static final int Base_Widget_AppCompat_ActionBar = 2131230909;
        public static final int Base_Widget_AppCompat_ActionBar_Solid = 2131230910;
        public static final int Base_Widget_AppCompat_ActionBar_TabBar = 2131230911;
        public static final int Base_Widget_AppCompat_ActionBar_TabText = 2131230823;
        public static final int Base_Widget_AppCompat_ActionBar_TabView = 2131230824;
        public static final int Base_Widget_AppCompat_ActionButton = 2131230825;
        public static final int Base_Widget_AppCompat_ActionButton_CloseMode = 2131230826;
        public static final int Base_Widget_AppCompat_ActionButton_Overflow = 2131230827;
        public static final int Base_Widget_AppCompat_ActionMode = 2131230912;
        public static final int Base_Widget_AppCompat_ActivityChooserView = 2131230913;
        public static final int Base_Widget_AppCompat_AutoCompleteTextView = 2131230757;
        public static final int Base_Widget_AppCompat_Button = 2131230828;
        public static final int Base_Widget_AppCompat_ButtonBar = 2131230832;
        public static final int Base_Widget_AppCompat_ButtonBar_AlertDialog = 2131230915;
        public static final int Base_Widget_AppCompat_Button_Borderless = 2131230829;
        public static final int Base_Widget_AppCompat_Button_Borderless_Colored = 2131230830;
        public static final int Base_Widget_AppCompat_Button_ButtonBar_AlertDialog = 2131230914;
        public static final int Base_Widget_AppCompat_Button_Colored = 2131230872;
        public static final int Base_Widget_AppCompat_Button_Small = 2131230831;
        public static final int Base_Widget_AppCompat_CompoundButton_CheckBox = 2131230833;
        public static final int Base_Widget_AppCompat_CompoundButton_RadioButton = 2131230834;
        public static final int Base_Widget_AppCompat_CompoundButton_Switch = 2131230916;
        public static final int Base_Widget_AppCompat_DrawerArrowToggle = 2131230720;
        public static final int Base_Widget_AppCompat_DrawerArrowToggle_Common = 2131230917;
        public static final int Base_Widget_AppCompat_DropDownItem_Spinner = 2131230835;
        public static final int Base_Widget_AppCompat_EditText = 2131230758;
        public static final int Base_Widget_AppCompat_ImageButton = 2131230836;
        public static final int Base_Widget_AppCompat_Light_ActionBar = 2131230918;
        public static final int Base_Widget_AppCompat_Light_ActionBar_Solid = 2131230919;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabBar = 2131230920;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabText = 2131230837;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabText_Inverse = 2131230838;
        public static final int Base_Widget_AppCompat_Light_ActionBar_TabView = 2131230839;
        public static final int Base_Widget_AppCompat_Light_PopupMenu = 2131230840;
        public static final int Base_Widget_AppCompat_Light_PopupMenu_Overflow = 2131230841;
        public static final int Base_Widget_AppCompat_ListMenuView = 2131230921;
        public static final int Base_Widget_AppCompat_ListPopupWindow = 2131230842;
        public static final int Base_Widget_AppCompat_ListView = 2131230843;
        public static final int Base_Widget_AppCompat_ListView_DropDown = 2131230844;
        public static final int Base_Widget_AppCompat_ListView_Menu = 2131230845;
        public static final int Base_Widget_AppCompat_PopupMenu = 2131230846;
        public static final int Base_Widget_AppCompat_PopupMenu_Overflow = 2131230847;
        public static final int Base_Widget_AppCompat_PopupWindow = 2131230922;
        public static final int Base_Widget_AppCompat_ProgressBar = 2131230748;
        public static final int Base_Widget_AppCompat_ProgressBar_Horizontal = 2131230749;
        public static final int Base_Widget_AppCompat_RatingBar = 2131230848;
        public static final int Base_Widget_AppCompat_RatingBar_Indicator = 2131230873;
        public static final int Base_Widget_AppCompat_RatingBar_Small = 2131230874;
        public static final int Base_Widget_AppCompat_SearchView = 2131230923;
        public static final int Base_Widget_AppCompat_SearchView_ActionBar = 2131230924;
        public static final int Base_Widget_AppCompat_SeekBar = 2131230849;
        public static final int Base_Widget_AppCompat_SeekBar_Discrete = 2131230925;
        public static final int Base_Widget_AppCompat_Spinner = 2131230850;
        public static final int Base_Widget_AppCompat_Spinner_Underlined = 2131230723;
        public static final int Base_Widget_AppCompat_TextView_SpinnerItem = 2131230851;
        public static final int Base_Widget_AppCompat_Toolbar = 2131230926;
        public static final int Base_Widget_AppCompat_Toolbar_Button_Navigation = 2131230852;
        public static final int Platform_AppCompat = 2131230750;
        public static final int Platform_AppCompat_Light = 2131230751;
        public static final int Platform_ThemeOverlay_AppCompat = 2131230853;
        public static final int Platform_ThemeOverlay_AppCompat_Dark = 2131230854;
        public static final int Platform_ThemeOverlay_AppCompat_Light = 2131230855;
        public static final int Platform_V11_AppCompat = 2131230752;
        public static final int Platform_V11_AppCompat_Light = 2131230753;
        public static final int Platform_V14_AppCompat = 2131230760;
        public static final int Platform_V14_AppCompat_Light = 2131230761;
        public static final int Platform_V21_AppCompat = 2131230856;
        public static final int Platform_V21_AppCompat_Light = 2131230857;
        public static final int Platform_V25_AppCompat = 2131230877;
        public static final int Platform_V25_AppCompat_Light = 2131230878;
        public static final int Platform_Widget_AppCompat_Spinner = 2131230754;
        public static final int RtlOverlay_DialogWindowTitle_AppCompat = 2131230769;
        public static final int RtlOverlay_Widget_AppCompat_ActionBar_TitleItem = 2131230770;
        public static final int RtlOverlay_Widget_AppCompat_DialogTitle_Icon = 2131230771;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem = 2131230772;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_InternalGroup = 2131230773;
        public static final int RtlOverlay_Widget_AppCompat_PopupMenuItem_Text = 2131230774;
        public static final int RtlOverlay_Widget_AppCompat_SearchView_MagIcon = 2131230780;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown = 2131230775;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Icon1 = 2131230776;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Icon2 = 2131230777;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Query = 2131230778;
        public static final int RtlOverlay_Widget_AppCompat_Search_DropDown_Text = 2131230779;
        public static final int RtlUnderlay_Widget_AppCompat_ActionButton = 2131230781;
        public static final int RtlUnderlay_Widget_AppCompat_ActionButton_Overflow = 2131230782;
        public static final int TextAppearance_AppCompat = 2131230927;
        public static final int TextAppearance_AppCompat_Body1 = 2131230928;
        public static final int TextAppearance_AppCompat_Body2 = 2131230929;
        public static final int TextAppearance_AppCompat_Button = 2131230930;
        public static final int TextAppearance_AppCompat_Caption = 2131230931;
        public static final int TextAppearance_AppCompat_Display1 = 2131230932;
        public static final int TextAppearance_AppCompat_Display2 = 2131230933;
        public static final int TextAppearance_AppCompat_Display3 = 2131230934;
        public static final int TextAppearance_AppCompat_Display4 = 2131230935;
        public static final int TextAppearance_AppCompat_Headline = 2131230936;
        public static final int TextAppearance_AppCompat_Inverse = 2131230937;
        public static final int TextAppearance_AppCompat_Large = 2131230938;
        public static final int TextAppearance_AppCompat_Large_Inverse = 2131230939;
        public static final int TextAppearance_AppCompat_Light_SearchResult_Subtitle = 2131230940;
        public static final int TextAppearance_AppCompat_Light_SearchResult_Title = 2131230941;
        public static final int TextAppearance_AppCompat_Light_Widget_PopupMenu_Large = 2131230942;
        public static final int TextAppearance_AppCompat_Light_Widget_PopupMenu_Small = 2131230943;
        public static final int TextAppearance_AppCompat_Medium = 2131230944;
        public static final int TextAppearance_AppCompat_Medium_Inverse = 2131230945;
        public static final int TextAppearance_AppCompat_Menu = 2131230946;
        public static final int TextAppearance_AppCompat_Notification = 2131230762;
        public static final int TextAppearance_AppCompat_Notification_Info = 2131230858;
        public static final int TextAppearance_AppCompat_Notification_Info_Media = 2131230859;
        public static final int TextAppearance_AppCompat_Notification_Line2 = 2131230947;
        public static final int TextAppearance_AppCompat_Notification_Line2_Media = 2131230948;
        public static final int TextAppearance_AppCompat_Notification_Media = 2131230860;
        public static final int TextAppearance_AppCompat_Notification_Time = 2131230861;
        public static final int TextAppearance_AppCompat_Notification_Time_Media = 2131230862;
        public static final int TextAppearance_AppCompat_Notification_Title = 2131230763;
        public static final int TextAppearance_AppCompat_Notification_Title_Media = 2131230863;
        public static final int TextAppearance_AppCompat_SearchResult_Subtitle = 2131230949;
        public static final int TextAppearance_AppCompat_SearchResult_Title = 2131230950;
        public static final int TextAppearance_AppCompat_Small = 2131230951;
        public static final int TextAppearance_AppCompat_Small_Inverse = 2131230952;
        public static final int TextAppearance_AppCompat_Subhead = 2131230953;
        public static final int TextAppearance_AppCompat_Subhead_Inverse = 2131230954;
        public static final int TextAppearance_AppCompat_Title = 2131230955;
        public static final int TextAppearance_AppCompat_Title_Inverse = 2131230956;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Menu = 2131230957;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Subtitle = 2131230958;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Subtitle_Inverse = 2131230959;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Title = 2131230960;
        public static final int TextAppearance_AppCompat_Widget_ActionBar_Title_Inverse = 2131230961;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Subtitle = 2131230962;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Subtitle_Inverse = 2131230963;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Title = 2131230964;
        public static final int TextAppearance_AppCompat_Widget_ActionMode_Title_Inverse = 2131230965;
        public static final int TextAppearance_AppCompat_Widget_Button = 2131230966;
        public static final int TextAppearance_AppCompat_Widget_Button_Borderless_Colored = 2131230967;
        public static final int TextAppearance_AppCompat_Widget_Button_Colored = 2131230968;
        public static final int TextAppearance_AppCompat_Widget_Button_Inverse = 2131230969;
        public static final int TextAppearance_AppCompat_Widget_DropDownItem = 2131230970;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Header = 2131230971;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Large = 2131230972;
        public static final int TextAppearance_AppCompat_Widget_PopupMenu_Small = 2131230973;
        public static final int TextAppearance_AppCompat_Widget_Switch = 2131230974;
        public static final int TextAppearance_AppCompat_Widget_TextView_SpinnerItem = 2131230975;
        public static final int TextAppearance_StatusBar_EventContent = 2131230764;
        public static final int TextAppearance_StatusBar_EventContent_Info = 2131230765;
        public static final int TextAppearance_StatusBar_EventContent_Line2 = 2131230766;
        public static final int TextAppearance_StatusBar_EventContent_Time = 2131230767;
        public static final int TextAppearance_StatusBar_EventContent_Title = 2131230768;
        public static final int TextAppearance_Widget_AppCompat_ExpandedMenu_Item = 2131230976;
        public static final int TextAppearance_Widget_AppCompat_Toolbar_Subtitle = 2131230977;
        public static final int TextAppearance_Widget_AppCompat_Toolbar_Title = 2131230978;
        public static final int ThemeOverlay_AppCompat = 2131230993;
        public static final int ThemeOverlay_AppCompat_ActionBar = 2131230994;
        public static final int ThemeOverlay_AppCompat_Dark = 2131230995;
        public static final int ThemeOverlay_AppCompat_Dark_ActionBar = 2131230996;
        public static final int ThemeOverlay_AppCompat_Dialog = 2131230997;
        public static final int ThemeOverlay_AppCompat_Dialog_Alert = 2131230998;
        public static final int ThemeOverlay_AppCompat_Light = 2131230999;
        public static final int Theme_AppCompat = 2131230979;
        public static final int Theme_AppCompat_CompactMenu = 2131230980;
        public static final int Theme_AppCompat_DayNight = 2131230724;
        public static final int Theme_AppCompat_DayNight_DarkActionBar = 2131230725;
        public static final int Theme_AppCompat_DayNight_Dialog = 2131230726;
        public static final int Theme_AppCompat_DayNight_DialogWhenLarge = 2131230729;
        public static final int Theme_AppCompat_DayNight_Dialog_Alert = 2131230727;
        public static final int Theme_AppCompat_DayNight_Dialog_MinWidth = 2131230728;
        public static final int Theme_AppCompat_DayNight_NoActionBar = 2131230730;
        public static final int Theme_AppCompat_Dialog = 2131230981;
        public static final int Theme_AppCompat_DialogWhenLarge = 2131230984;
        public static final int Theme_AppCompat_Dialog_Alert = 2131230982;
        public static final int Theme_AppCompat_Dialog_MinWidth = 2131230983;
        public static final int Theme_AppCompat_Light = 2131230985;
        public static final int Theme_AppCompat_Light_DarkActionBar = 2131230986;
        public static final int Theme_AppCompat_Light_Dialog = 2131230987;
        public static final int Theme_AppCompat_Light_DialogWhenLarge = 2131230990;
        public static final int Theme_AppCompat_Light_Dialog_Alert = 2131230988;
        public static final int Theme_AppCompat_Light_Dialog_MinWidth = 2131230989;
        public static final int Theme_AppCompat_Light_NoActionBar = 2131230991;
        public static final int Theme_AppCompat_NoActionBar = 2131230992;
        public static final int Widget_AppCompat_ActionBar = 2131231000;
        public static final int Widget_AppCompat_ActionBar_Solid = 2131231001;
        public static final int Widget_AppCompat_ActionBar_TabBar = 2131231002;
        public static final int Widget_AppCompat_ActionBar_TabText = 2131231003;
        public static final int Widget_AppCompat_ActionBar_TabView = 2131231004;
        public static final int Widget_AppCompat_ActionButton = 2131231005;
        public static final int Widget_AppCompat_ActionButton_CloseMode = 2131231006;
        public static final int Widget_AppCompat_ActionButton_Overflow = 2131231007;
        public static final int Widget_AppCompat_ActionMode = 2131231008;
        public static final int Widget_AppCompat_ActivityChooserView = 2131231009;
        public static final int Widget_AppCompat_AutoCompleteTextView = 2131231010;
        public static final int Widget_AppCompat_Button = 2131231011;
        public static final int Widget_AppCompat_ButtonBar = 2131231017;
        public static final int Widget_AppCompat_ButtonBar_AlertDialog = 2131231018;
        public static final int Widget_AppCompat_Button_Borderless = 2131231012;
        public static final int Widget_AppCompat_Button_Borderless_Colored = 2131231013;
        public static final int Widget_AppCompat_Button_ButtonBar_AlertDialog = 2131231014;
        public static final int Widget_AppCompat_Button_Colored = 2131231015;
        public static final int Widget_AppCompat_Button_Small = 2131231016;
        public static final int Widget_AppCompat_CompoundButton_CheckBox = 2131231019;
        public static final int Widget_AppCompat_CompoundButton_RadioButton = 2131231020;
        public static final int Widget_AppCompat_CompoundButton_Switch = 2131231021;
        public static final int Widget_AppCompat_DrawerArrowToggle = 2131231022;
        public static final int Widget_AppCompat_DropDownItem_Spinner = 2131231023;
        public static final int Widget_AppCompat_EditText = 2131231024;
        public static final int Widget_AppCompat_ImageButton = 2131231025;
        public static final int Widget_AppCompat_Light_ActionBar = 2131231026;
        public static final int Widget_AppCompat_Light_ActionBar_Solid = 2131231027;
        public static final int Widget_AppCompat_Light_ActionBar_Solid_Inverse = 2131231028;
        public static final int Widget_AppCompat_Light_ActionBar_TabBar = 2131231029;
        public static final int Widget_AppCompat_Light_ActionBar_TabBar_Inverse = 2131231030;
        public static final int Widget_AppCompat_Light_ActionBar_TabText = 2131231031;
        public static final int Widget_AppCompat_Light_ActionBar_TabText_Inverse = 2131231032;
        public static final int Widget_AppCompat_Light_ActionBar_TabView = 2131231033;
        public static final int Widget_AppCompat_Light_ActionBar_TabView_Inverse = 2131231034;
        public static final int Widget_AppCompat_Light_ActionButton = 2131231035;
        public static final int Widget_AppCompat_Light_ActionButton_CloseMode = 2131231036;
        public static final int Widget_AppCompat_Light_ActionButton_Overflow = 2131231037;
        public static final int Widget_AppCompat_Light_ActionMode_Inverse = 2131231038;
        public static final int Widget_AppCompat_Light_ActivityChooserView = 2131231039;
        public static final int Widget_AppCompat_Light_AutoCompleteTextView = 2131231040;
        public static final int Widget_AppCompat_Light_DropDownItem_Spinner = 2131231041;
        public static final int Widget_AppCompat_Light_ListPopupWindow = 2131231042;
        public static final int Widget_AppCompat_Light_ListView_DropDown = 2131231043;
        public static final int Widget_AppCompat_Light_PopupMenu = 2131231044;
        public static final int Widget_AppCompat_Light_PopupMenu_Overflow = 2131231045;
        public static final int Widget_AppCompat_Light_SearchView = 2131231046;
        public static final int Widget_AppCompat_Light_Spinner_DropDown_ActionBar = 2131231047;
        public static final int Widget_AppCompat_ListMenuView = 2131231048;
        public static final int Widget_AppCompat_ListPopupWindow = 2131231049;
        public static final int Widget_AppCompat_ListView = 2131231050;
        public static final int Widget_AppCompat_ListView_DropDown = 2131231051;
        public static final int Widget_AppCompat_ListView_Menu = 2131231052;
        public static final int Widget_AppCompat_NotificationActionContainer = 2131230864;
        public static final int Widget_AppCompat_NotificationActionText = 2131230865;
        public static final int Widget_AppCompat_PopupMenu = 2131231053;
        public static final int Widget_AppCompat_PopupMenu_Overflow = 2131231054;
        public static final int Widget_AppCompat_PopupWindow = 2131231055;
        public static final int Widget_AppCompat_ProgressBar = 2131231056;
        public static final int Widget_AppCompat_ProgressBar_Horizontal = 2131231057;
        public static final int Widget_AppCompat_RatingBar = 2131231058;
        public static final int Widget_AppCompat_RatingBar_Indicator = 2131231059;
        public static final int Widget_AppCompat_RatingBar_Small = 2131231060;
        public static final int Widget_AppCompat_SearchView = 2131231061;
        public static final int Widget_AppCompat_SearchView_ActionBar = 2131231062;
        public static final int Widget_AppCompat_SeekBar = 2131231063;
        public static final int Widget_AppCompat_SeekBar_Discrete = 2131231064;
        public static final int Widget_AppCompat_Spinner = 2131231065;
        public static final int Widget_AppCompat_Spinner_DropDown = 2131231066;
        public static final int Widget_AppCompat_Spinner_DropDown_ActionBar = 2131231067;
        public static final int Widget_AppCompat_Spinner_Underlined = 2131231068;
        public static final int Widget_AppCompat_TextView_SpinnerItem = 2131231069;
        public static final int Widget_AppCompat_Toolbar = 2131231070;
        public static final int Widget_AppCompat_Toolbar_Button_Navigation = 2131231071;
        public static final long serialVersionUID = 0;

        style(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case -1555801716:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$style"}));
            }
        }

        public static /* synthetic */ Object access$super(style style, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$style"}));
            }
        }

        public style() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$style;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$style;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    public static final class styleable {
        public static volatile transient /* synthetic */ IncrementalChange $change = null;
        public static final int[] ActionBar = new int[]{com.tanzx.instantrun.R.attr.height, com.tanzx.instantrun.R.attr.title, com.tanzx.instantrun.R.attr.navigationMode, com.tanzx.instantrun.R.attr.displayOptions, com.tanzx.instantrun.R.attr.subtitle, com.tanzx.instantrun.R.attr.titleTextStyle, com.tanzx.instantrun.R.attr.subtitleTextStyle, com.tanzx.instantrun.R.attr.icon, com.tanzx.instantrun.R.attr.logo, com.tanzx.instantrun.R.attr.divider, com.tanzx.instantrun.R.attr.background, com.tanzx.instantrun.R.attr.backgroundStacked, com.tanzx.instantrun.R.attr.backgroundSplit, com.tanzx.instantrun.R.attr.customNavigationLayout, com.tanzx.instantrun.R.attr.homeLayout, com.tanzx.instantrun.R.attr.progressBarStyle, com.tanzx.instantrun.R.attr.indeterminateProgressStyle, com.tanzx.instantrun.R.attr.progressBarPadding, com.tanzx.instantrun.R.attr.itemPadding, com.tanzx.instantrun.R.attr.hideOnContentScroll, com.tanzx.instantrun.R.attr.contentInsetStart, com.tanzx.instantrun.R.attr.contentInsetEnd, com.tanzx.instantrun.R.attr.contentInsetLeft, com.tanzx.instantrun.R.attr.contentInsetRight, com.tanzx.instantrun.R.attr.contentInsetStartWithNavigation, com.tanzx.instantrun.R.attr.contentInsetEndWithActions, com.tanzx.instantrun.R.attr.elevation, com.tanzx.instantrun.R.attr.popupTheme, com.tanzx.instantrun.R.attr.homeAsUpIndicator};
        public static final int[] ActionBarLayout = new int[]{16842931};
        public static final int ActionBarLayout_android_layout_gravity = 0;
        public static final int ActionBar_background = 10;
        public static final int ActionBar_backgroundSplit = 12;
        public static final int ActionBar_backgroundStacked = 11;
        public static final int ActionBar_contentInsetEnd = 21;
        public static final int ActionBar_contentInsetEndWithActions = 25;
        public static final int ActionBar_contentInsetLeft = 22;
        public static final int ActionBar_contentInsetRight = 23;
        public static final int ActionBar_contentInsetStart = 20;
        public static final int ActionBar_contentInsetStartWithNavigation = 24;
        public static final int ActionBar_customNavigationLayout = 13;
        public static final int ActionBar_displayOptions = 3;
        public static final int ActionBar_divider = 9;
        public static final int ActionBar_elevation = 26;
        public static final int ActionBar_height = 0;
        public static final int ActionBar_hideOnContentScroll = 19;
        public static final int ActionBar_homeAsUpIndicator = 28;
        public static final int ActionBar_homeLayout = 14;
        public static final int ActionBar_icon = 7;
        public static final int ActionBar_indeterminateProgressStyle = 16;
        public static final int ActionBar_itemPadding = 18;
        public static final int ActionBar_logo = 8;
        public static final int ActionBar_navigationMode = 2;
        public static final int ActionBar_popupTheme = 27;
        public static final int ActionBar_progressBarPadding = 17;
        public static final int ActionBar_progressBarStyle = 15;
        public static final int ActionBar_subtitle = 4;
        public static final int ActionBar_subtitleTextStyle = 6;
        public static final int ActionBar_title = 1;
        public static final int ActionBar_titleTextStyle = 5;
        public static final int[] ActionMenuItemView = new int[]{16843071};
        public static final int ActionMenuItemView_android_minWidth = 0;
        public static final int[] ActionMenuView = new int[0];
        public static final int[] ActionMode = new int[]{com.tanzx.instantrun.R.attr.height, com.tanzx.instantrun.R.attr.titleTextStyle, com.tanzx.instantrun.R.attr.subtitleTextStyle, com.tanzx.instantrun.R.attr.background, com.tanzx.instantrun.R.attr.backgroundSplit, com.tanzx.instantrun.R.attr.closeItemLayout};
        public static final int ActionMode_background = 3;
        public static final int ActionMode_backgroundSplit = 4;
        public static final int ActionMode_closeItemLayout = 5;
        public static final int ActionMode_height = 0;
        public static final int ActionMode_subtitleTextStyle = 2;
        public static final int ActionMode_titleTextStyle = 1;
        public static final int[] ActivityChooserView = new int[]{com.tanzx.instantrun.R.attr.initialActivityCount, com.tanzx.instantrun.R.attr.expandActivityOverflowButtonDrawable};
        public static final int ActivityChooserView_expandActivityOverflowButtonDrawable = 1;
        public static final int ActivityChooserView_initialActivityCount = 0;
        public static final int[] AlertDialog = new int[]{16842994, com.tanzx.instantrun.R.attr.buttonPanelSideLayout, com.tanzx.instantrun.R.attr.listLayout, com.tanzx.instantrun.R.attr.multiChoiceItemLayout, com.tanzx.instantrun.R.attr.singleChoiceItemLayout, com.tanzx.instantrun.R.attr.listItemLayout, com.tanzx.instantrun.R.attr.showTitle};
        public static final int AlertDialog_android_layout = 0;
        public static final int AlertDialog_buttonPanelSideLayout = 1;
        public static final int AlertDialog_listItemLayout = 5;
        public static final int AlertDialog_listLayout = 2;
        public static final int AlertDialog_multiChoiceItemLayout = 3;
        public static final int AlertDialog_showTitle = 6;
        public static final int AlertDialog_singleChoiceItemLayout = 4;
        public static final int[] AppCompatImageView = new int[]{16843033, com.tanzx.instantrun.R.attr.srcCompat};
        public static final int AppCompatImageView_android_src = 0;
        public static final int AppCompatImageView_srcCompat = 1;
        public static final int[] AppCompatSeekBar = new int[]{16843074, com.tanzx.instantrun.R.attr.tickMark, com.tanzx.instantrun.R.attr.tickMarkTint, com.tanzx.instantrun.R.attr.tickMarkTintMode};
        public static final int AppCompatSeekBar_android_thumb = 0;
        public static final int AppCompatSeekBar_tickMark = 1;
        public static final int AppCompatSeekBar_tickMarkTint = 2;
        public static final int AppCompatSeekBar_tickMarkTintMode = 3;
        public static final int[] AppCompatTextHelper = new int[]{16842804, 16843117, 16843118, 16843119, 16843120, 16843666, 16843667};
        public static final int AppCompatTextHelper_android_drawableBottom = 2;
        public static final int AppCompatTextHelper_android_drawableEnd = 6;
        public static final int AppCompatTextHelper_android_drawableLeft = 3;
        public static final int AppCompatTextHelper_android_drawableRight = 4;
        public static final int AppCompatTextHelper_android_drawableStart = 5;
        public static final int AppCompatTextHelper_android_drawableTop = 1;
        public static final int AppCompatTextHelper_android_textAppearance = 0;
        public static final int[] AppCompatTextView = new int[]{16842804, com.tanzx.instantrun.R.attr.textAllCaps};
        public static final int AppCompatTextView_android_textAppearance = 0;
        public static final int AppCompatTextView_textAllCaps = 1;
        public static final int[] AppCompatTheme = new int[]{16842839, 16842926, com.tanzx.instantrun.R.attr.windowActionBar, com.tanzx.instantrun.R.attr.windowNoTitle, com.tanzx.instantrun.R.attr.windowActionBarOverlay, com.tanzx.instantrun.R.attr.windowActionModeOverlay, com.tanzx.instantrun.R.attr.windowFixedWidthMajor, com.tanzx.instantrun.R.attr.windowFixedHeightMinor, com.tanzx.instantrun.R.attr.windowFixedWidthMinor, com.tanzx.instantrun.R.attr.windowFixedHeightMajor, com.tanzx.instantrun.R.attr.windowMinWidthMajor, com.tanzx.instantrun.R.attr.windowMinWidthMinor, com.tanzx.instantrun.R.attr.actionBarTabStyle, com.tanzx.instantrun.R.attr.actionBarTabBarStyle, com.tanzx.instantrun.R.attr.actionBarTabTextStyle, com.tanzx.instantrun.R.attr.actionOverflowButtonStyle, com.tanzx.instantrun.R.attr.actionOverflowMenuStyle, com.tanzx.instantrun.R.attr.actionBarPopupTheme, com.tanzx.instantrun.R.attr.actionBarStyle, com.tanzx.instantrun.R.attr.actionBarSplitStyle, com.tanzx.instantrun.R.attr.actionBarTheme, com.tanzx.instantrun.R.attr.actionBarWidgetTheme, com.tanzx.instantrun.R.attr.actionBarSize, com.tanzx.instantrun.R.attr.actionBarDivider, com.tanzx.instantrun.R.attr.actionBarItemBackground, com.tanzx.instantrun.R.attr.actionMenuTextAppearance, com.tanzx.instantrun.R.attr.actionMenuTextColor, com.tanzx.instantrun.R.attr.actionModeStyle, com.tanzx.instantrun.R.attr.actionModeCloseButtonStyle, com.tanzx.instantrun.R.attr.actionModeBackground, com.tanzx.instantrun.R.attr.actionModeSplitBackground, com.tanzx.instantrun.R.attr.actionModeCloseDrawable, com.tanzx.instantrun.R.attr.actionModeCutDrawable, com.tanzx.instantrun.R.attr.actionModeCopyDrawable, com.tanzx.instantrun.R.attr.actionModePasteDrawable, com.tanzx.instantrun.R.attr.actionModeSelectAllDrawable, com.tanzx.instantrun.R.attr.actionModeShareDrawable, com.tanzx.instantrun.R.attr.actionModeFindDrawable, com.tanzx.instantrun.R.attr.actionModeWebSearchDrawable, com.tanzx.instantrun.R.attr.actionModePopupWindowStyle, com.tanzx.instantrun.R.attr.textAppearanceLargePopupMenu, com.tanzx.instantrun.R.attr.textAppearanceSmallPopupMenu, com.tanzx.instantrun.R.attr.textAppearancePopupMenuHeader, com.tanzx.instantrun.R.attr.dialogTheme, com.tanzx.instantrun.R.attr.dialogPreferredPadding, com.tanzx.instantrun.R.attr.listDividerAlertDialog, com.tanzx.instantrun.R.attr.actionDropDownStyle, com.tanzx.instantrun.R.attr.dropdownListPreferredItemHeight, com.tanzx.instantrun.R.attr.spinnerDropDownItemStyle, com.tanzx.instantrun.R.attr.homeAsUpIndicator, com.tanzx.instantrun.R.attr.actionButtonStyle, com.tanzx.instantrun.R.attr.buttonBarStyle, com.tanzx.instantrun.R.attr.buttonBarButtonStyle, com.tanzx.instantrun.R.attr.selectableItemBackground, com.tanzx.instantrun.R.attr.selectableItemBackgroundBorderless, com.tanzx.instantrun.R.attr.borderlessButtonStyle, com.tanzx.instantrun.R.attr.dividerVertical, com.tanzx.instantrun.R.attr.dividerHorizontal, com.tanzx.instantrun.R.attr.activityChooserViewStyle, com.tanzx.instantrun.R.attr.toolbarStyle, com.tanzx.instantrun.R.attr.toolbarNavigationButtonStyle, com.tanzx.instantrun.R.attr.popupMenuStyle, com.tanzx.instantrun.R.attr.popupWindowStyle, com.tanzx.instantrun.R.attr.editTextColor, com.tanzx.instantrun.R.attr.editTextBackground, com.tanzx.instantrun.R.attr.imageButtonStyle, com.tanzx.instantrun.R.attr.textAppearanceSearchResultTitle, com.tanzx.instantrun.R.attr.textAppearanceSearchResultSubtitle, com.tanzx.instantrun.R.attr.textColorSearchUrl, com.tanzx.instantrun.R.attr.searchViewStyle, com.tanzx.instantrun.R.attr.listPreferredItemHeight, com.tanzx.instantrun.R.attr.listPreferredItemHeightSmall, com.tanzx.instantrun.R.attr.listPreferredItemHeightLarge, com.tanzx.instantrun.R.attr.listPreferredItemPaddingLeft, com.tanzx.instantrun.R.attr.listPreferredItemPaddingRight, com.tanzx.instantrun.R.attr.dropDownListViewStyle, com.tanzx.instantrun.R.attr.listPopupWindowStyle, com.tanzx.instantrun.R.attr.textAppearanceListItem, com.tanzx.instantrun.R.attr.textAppearanceListItemSmall, com.tanzx.instantrun.R.attr.panelBackground, com.tanzx.instantrun.R.attr.panelMenuListWidth, com.tanzx.instantrun.R.attr.panelMenuListTheme, com.tanzx.instantrun.R.attr.listChoiceBackgroundIndicator, com.tanzx.instantrun.R.attr.colorPrimary, com.tanzx.instantrun.R.attr.colorPrimaryDark, com.tanzx.instantrun.R.attr.colorAccent, com.tanzx.instantrun.R.attr.colorControlNormal, com.tanzx.instantrun.R.attr.colorControlActivated, com.tanzx.instantrun.R.attr.colorControlHighlight, com.tanzx.instantrun.R.attr.colorButtonNormal, com.tanzx.instantrun.R.attr.colorSwitchThumbNormal, com.tanzx.instantrun.R.attr.controlBackground, com.tanzx.instantrun.R.attr.colorBackgroundFloating, com.tanzx.instantrun.R.attr.alertDialogStyle, com.tanzx.instantrun.R.attr.alertDialogButtonGroupStyle, com.tanzx.instantrun.R.attr.alertDialogCenterButtons, com.tanzx.instantrun.R.attr.alertDialogTheme, com.tanzx.instantrun.R.attr.textColorAlertDialogListItem, com.tanzx.instantrun.R.attr.buttonBarPositiveButtonStyle, com.tanzx.instantrun.R.attr.buttonBarNegativeButtonStyle, com.tanzx.instantrun.R.attr.buttonBarNeutralButtonStyle, com.tanzx.instantrun.R.attr.autoCompleteTextViewStyle, com.tanzx.instantrun.R.attr.buttonStyle, com.tanzx.instantrun.R.attr.buttonStyleSmall, com.tanzx.instantrun.R.attr.checkboxStyle, com.tanzx.instantrun.R.attr.checkedTextViewStyle, com.tanzx.instantrun.R.attr.editTextStyle, com.tanzx.instantrun.R.attr.radioButtonStyle, com.tanzx.instantrun.R.attr.ratingBarStyle, com.tanzx.instantrun.R.attr.ratingBarStyleIndicator, com.tanzx.instantrun.R.attr.ratingBarStyleSmall, com.tanzx.instantrun.R.attr.seekBarStyle, com.tanzx.instantrun.R.attr.spinnerStyle, com.tanzx.instantrun.R.attr.switchStyle, com.tanzx.instantrun.R.attr.listMenuViewStyle};
        public static final int AppCompatTheme_actionBarDivider = 23;
        public static final int AppCompatTheme_actionBarItemBackground = 24;
        public static final int AppCompatTheme_actionBarPopupTheme = 17;
        public static final int AppCompatTheme_actionBarSize = 22;
        public static final int AppCompatTheme_actionBarSplitStyle = 19;
        public static final int AppCompatTheme_actionBarStyle = 18;
        public static final int AppCompatTheme_actionBarTabBarStyle = 13;
        public static final int AppCompatTheme_actionBarTabStyle = 12;
        public static final int AppCompatTheme_actionBarTabTextStyle = 14;
        public static final int AppCompatTheme_actionBarTheme = 20;
        public static final int AppCompatTheme_actionBarWidgetTheme = 21;
        public static final int AppCompatTheme_actionButtonStyle = 50;
        public static final int AppCompatTheme_actionDropDownStyle = 46;
        public static final int AppCompatTheme_actionMenuTextAppearance = 25;
        public static final int AppCompatTheme_actionMenuTextColor = 26;
        public static final int AppCompatTheme_actionModeBackground = 29;
        public static final int AppCompatTheme_actionModeCloseButtonStyle = 28;
        public static final int AppCompatTheme_actionModeCloseDrawable = 31;
        public static final int AppCompatTheme_actionModeCopyDrawable = 33;
        public static final int AppCompatTheme_actionModeCutDrawable = 32;
        public static final int AppCompatTheme_actionModeFindDrawable = 37;
        public static final int AppCompatTheme_actionModePasteDrawable = 34;
        public static final int AppCompatTheme_actionModePopupWindowStyle = 39;
        public static final int AppCompatTheme_actionModeSelectAllDrawable = 35;
        public static final int AppCompatTheme_actionModeShareDrawable = 36;
        public static final int AppCompatTheme_actionModeSplitBackground = 30;
        public static final int AppCompatTheme_actionModeStyle = 27;
        public static final int AppCompatTheme_actionModeWebSearchDrawable = 38;
        public static final int AppCompatTheme_actionOverflowButtonStyle = 15;
        public static final int AppCompatTheme_actionOverflowMenuStyle = 16;
        public static final int AppCompatTheme_activityChooserViewStyle = 58;
        public static final int AppCompatTheme_alertDialogButtonGroupStyle = 94;
        public static final int AppCompatTheme_alertDialogCenterButtons = 95;
        public static final int AppCompatTheme_alertDialogStyle = 93;
        public static final int AppCompatTheme_alertDialogTheme = 96;
        public static final int AppCompatTheme_android_windowAnimationStyle = 1;
        public static final int AppCompatTheme_android_windowIsFloating = 0;
        public static final int AppCompatTheme_autoCompleteTextViewStyle = 101;
        public static final int AppCompatTheme_borderlessButtonStyle = 55;
        public static final int AppCompatTheme_buttonBarButtonStyle = 52;
        public static final int AppCompatTheme_buttonBarNegativeButtonStyle = 99;
        public static final int AppCompatTheme_buttonBarNeutralButtonStyle = 100;
        public static final int AppCompatTheme_buttonBarPositiveButtonStyle = 98;
        public static final int AppCompatTheme_buttonBarStyle = 51;
        public static final int AppCompatTheme_buttonStyle = 102;
        public static final int AppCompatTheme_buttonStyleSmall = 103;
        public static final int AppCompatTheme_checkboxStyle = 104;
        public static final int AppCompatTheme_checkedTextViewStyle = 105;
        public static final int AppCompatTheme_colorAccent = 85;
        public static final int AppCompatTheme_colorBackgroundFloating = 92;
        public static final int AppCompatTheme_colorButtonNormal = 89;
        public static final int AppCompatTheme_colorControlActivated = 87;
        public static final int AppCompatTheme_colorControlHighlight = 88;
        public static final int AppCompatTheme_colorControlNormal = 86;
        public static final int AppCompatTheme_colorPrimary = 83;
        public static final int AppCompatTheme_colorPrimaryDark = 84;
        public static final int AppCompatTheme_colorSwitchThumbNormal = 90;
        public static final int AppCompatTheme_controlBackground = 91;
        public static final int AppCompatTheme_dialogPreferredPadding = 44;
        public static final int AppCompatTheme_dialogTheme = 43;
        public static final int AppCompatTheme_dividerHorizontal = 57;
        public static final int AppCompatTheme_dividerVertical = 56;
        public static final int AppCompatTheme_dropDownListViewStyle = 75;
        public static final int AppCompatTheme_dropdownListPreferredItemHeight = 47;
        public static final int AppCompatTheme_editTextBackground = 64;
        public static final int AppCompatTheme_editTextColor = 63;
        public static final int AppCompatTheme_editTextStyle = 106;
        public static final int AppCompatTheme_homeAsUpIndicator = 49;
        public static final int AppCompatTheme_imageButtonStyle = 65;
        public static final int AppCompatTheme_listChoiceBackgroundIndicator = 82;
        public static final int AppCompatTheme_listDividerAlertDialog = 45;
        public static final int AppCompatTheme_listMenuViewStyle = 114;
        public static final int AppCompatTheme_listPopupWindowStyle = 76;
        public static final int AppCompatTheme_listPreferredItemHeight = 70;
        public static final int AppCompatTheme_listPreferredItemHeightLarge = 72;
        public static final int AppCompatTheme_listPreferredItemHeightSmall = 71;
        public static final int AppCompatTheme_listPreferredItemPaddingLeft = 73;
        public static final int AppCompatTheme_listPreferredItemPaddingRight = 74;
        public static final int AppCompatTheme_panelBackground = 79;
        public static final int AppCompatTheme_panelMenuListTheme = 81;
        public static final int AppCompatTheme_panelMenuListWidth = 80;
        public static final int AppCompatTheme_popupMenuStyle = 61;
        public static final int AppCompatTheme_popupWindowStyle = 62;
        public static final int AppCompatTheme_radioButtonStyle = 107;
        public static final int AppCompatTheme_ratingBarStyle = 108;
        public static final int AppCompatTheme_ratingBarStyleIndicator = 109;
        public static final int AppCompatTheme_ratingBarStyleSmall = 110;
        public static final int AppCompatTheme_searchViewStyle = 69;
        public static final int AppCompatTheme_seekBarStyle = 111;
        public static final int AppCompatTheme_selectableItemBackground = 53;
        public static final int AppCompatTheme_selectableItemBackgroundBorderless = 54;
        public static final int AppCompatTheme_spinnerDropDownItemStyle = 48;
        public static final int AppCompatTheme_spinnerStyle = 112;
        public static final int AppCompatTheme_switchStyle = 113;
        public static final int AppCompatTheme_textAppearanceLargePopupMenu = 40;
        public static final int AppCompatTheme_textAppearanceListItem = 77;
        public static final int AppCompatTheme_textAppearanceListItemSmall = 78;
        public static final int AppCompatTheme_textAppearancePopupMenuHeader = 42;
        public static final int AppCompatTheme_textAppearanceSearchResultSubtitle = 67;
        public static final int AppCompatTheme_textAppearanceSearchResultTitle = 66;
        public static final int AppCompatTheme_textAppearanceSmallPopupMenu = 41;
        public static final int AppCompatTheme_textColorAlertDialogListItem = 97;
        public static final int AppCompatTheme_textColorSearchUrl = 68;
        public static final int AppCompatTheme_toolbarNavigationButtonStyle = 60;
        public static final int AppCompatTheme_toolbarStyle = 59;
        public static final int AppCompatTheme_windowActionBar = 2;
        public static final int AppCompatTheme_windowActionBarOverlay = 4;
        public static final int AppCompatTheme_windowActionModeOverlay = 5;
        public static final int AppCompatTheme_windowFixedHeightMajor = 9;
        public static final int AppCompatTheme_windowFixedHeightMinor = 7;
        public static final int AppCompatTheme_windowFixedWidthMajor = 6;
        public static final int AppCompatTheme_windowFixedWidthMinor = 8;
        public static final int AppCompatTheme_windowMinWidthMajor = 10;
        public static final int AppCompatTheme_windowMinWidthMinor = 11;
        public static final int AppCompatTheme_windowNoTitle = 3;
        public static final int[] ButtonBarLayout = new int[]{com.tanzx.instantrun.R.attr.allowStacking};
        public static final int ButtonBarLayout_allowStacking = 0;
        public static final int[] ColorStateListItem = new int[]{16843173, 16843551, com.tanzx.instantrun.R.attr.alpha};
        public static final int ColorStateListItem_alpha = 2;
        public static final int ColorStateListItem_android_alpha = 1;
        public static final int ColorStateListItem_android_color = 0;
        public static final int[] CompoundButton = new int[]{16843015, com.tanzx.instantrun.R.attr.buttonTint, com.tanzx.instantrun.R.attr.buttonTintMode};
        public static final int CompoundButton_android_button = 0;
        public static final int CompoundButton_buttonTint = 1;
        public static final int CompoundButton_buttonTintMode = 2;
        public static final int[] DrawerArrowToggle = new int[]{com.tanzx.instantrun.R.attr.color, com.tanzx.instantrun.R.attr.spinBars, com.tanzx.instantrun.R.attr.drawableSize, com.tanzx.instantrun.R.attr.gapBetweenBars, com.tanzx.instantrun.R.attr.arrowHeadLength, com.tanzx.instantrun.R.attr.arrowShaftLength, com.tanzx.instantrun.R.attr.barLength, com.tanzx.instantrun.R.attr.thickness};
        public static final int DrawerArrowToggle_arrowHeadLength = 4;
        public static final int DrawerArrowToggle_arrowShaftLength = 5;
        public static final int DrawerArrowToggle_barLength = 6;
        public static final int DrawerArrowToggle_color = 0;
        public static final int DrawerArrowToggle_drawableSize = 2;
        public static final int DrawerArrowToggle_gapBetweenBars = 3;
        public static final int DrawerArrowToggle_spinBars = 1;
        public static final int DrawerArrowToggle_thickness = 7;
        public static final int[] LinearLayoutCompat = new int[]{16842927, 16842948, 16843046, 16843047, 16843048, com.tanzx.instantrun.R.attr.divider, com.tanzx.instantrun.R.attr.measureWithLargestChild, com.tanzx.instantrun.R.attr.showDividers, com.tanzx.instantrun.R.attr.dividerPadding};
        public static final int[] LinearLayoutCompat_Layout = new int[]{16842931, 16842996, 16842997, 16843137};
        public static final int LinearLayoutCompat_Layout_android_layout_gravity = 0;
        public static final int LinearLayoutCompat_Layout_android_layout_height = 2;
        public static final int LinearLayoutCompat_Layout_android_layout_weight = 3;
        public static final int LinearLayoutCompat_Layout_android_layout_width = 1;
        public static final int LinearLayoutCompat_android_baselineAligned = 2;
        public static final int LinearLayoutCompat_android_baselineAlignedChildIndex = 3;
        public static final int LinearLayoutCompat_android_gravity = 0;
        public static final int LinearLayoutCompat_android_orientation = 1;
        public static final int LinearLayoutCompat_android_weightSum = 4;
        public static final int LinearLayoutCompat_divider = 5;
        public static final int LinearLayoutCompat_dividerPadding = 8;
        public static final int LinearLayoutCompat_measureWithLargestChild = 6;
        public static final int LinearLayoutCompat_showDividers = 7;
        public static final int[] ListPopupWindow = new int[]{16843436, 16843437};
        public static final int ListPopupWindow_android_dropDownHorizontalOffset = 0;
        public static final int ListPopupWindow_android_dropDownVerticalOffset = 1;
        public static final int[] MenuGroup = new int[]{16842766, 16842960, 16843156, 16843230, 16843231, 16843232};
        public static final int MenuGroup_android_checkableBehavior = 5;
        public static final int MenuGroup_android_enabled = 0;
        public static final int MenuGroup_android_id = 1;
        public static final int MenuGroup_android_menuCategory = 3;
        public static final int MenuGroup_android_orderInCategory = 4;
        public static final int MenuGroup_android_visible = 2;
        public static final int[] MenuItem = new int[]{16842754, 16842766, 16842960, 16843014, 16843156, 16843230, 16843231, 16843233, 16843234, 16843235, 16843236, 16843237, 16843375, com.tanzx.instantrun.R.attr.showAsAction, com.tanzx.instantrun.R.attr.actionLayout, com.tanzx.instantrun.R.attr.actionViewClass, com.tanzx.instantrun.R.attr.actionProviderClass};
        public static final int MenuItem_actionLayout = 14;
        public static final int MenuItem_actionProviderClass = 16;
        public static final int MenuItem_actionViewClass = 15;
        public static final int MenuItem_android_alphabeticShortcut = 9;
        public static final int MenuItem_android_checkable = 11;
        public static final int MenuItem_android_checked = 3;
        public static final int MenuItem_android_enabled = 1;
        public static final int MenuItem_android_icon = 0;
        public static final int MenuItem_android_id = 2;
        public static final int MenuItem_android_menuCategory = 5;
        public static final int MenuItem_android_numericShortcut = 10;
        public static final int MenuItem_android_onClick = 12;
        public static final int MenuItem_android_orderInCategory = 6;
        public static final int MenuItem_android_title = 7;
        public static final int MenuItem_android_titleCondensed = 8;
        public static final int MenuItem_android_visible = 4;
        public static final int MenuItem_showAsAction = 13;
        public static final int[] MenuView = new int[]{16842926, 16843052, 16843053, 16843054, 16843055, 16843056, 16843057, com.tanzx.instantrun.R.attr.preserveIconSpacing, com.tanzx.instantrun.R.attr.subMenuArrow};
        public static final int MenuView_android_headerBackground = 4;
        public static final int MenuView_android_horizontalDivider = 2;
        public static final int MenuView_android_itemBackground = 5;
        public static final int MenuView_android_itemIconDisabledAlpha = 6;
        public static final int MenuView_android_itemTextAppearance = 1;
        public static final int MenuView_android_verticalDivider = 3;
        public static final int MenuView_android_windowAnimationStyle = 0;
        public static final int MenuView_preserveIconSpacing = 7;
        public static final int MenuView_subMenuArrow = 8;
        public static final int[] PopupWindow = new int[]{16843126, 16843465, com.tanzx.instantrun.R.attr.overlapAnchor};
        public static final int[] PopupWindowBackgroundState = new int[]{com.tanzx.instantrun.R.attr.state_above_anchor};
        public static final int PopupWindowBackgroundState_state_above_anchor = 0;
        public static final int PopupWindow_android_popupAnimationStyle = 1;
        public static final int PopupWindow_android_popupBackground = 0;
        public static final int PopupWindow_overlapAnchor = 2;
        public static final int[] RecycleListView = new int[]{com.tanzx.instantrun.R.attr.paddingBottomNoButtons, com.tanzx.instantrun.R.attr.paddingTopNoTitle};
        public static final int RecycleListView_paddingBottomNoButtons = 0;
        public static final int RecycleListView_paddingTopNoTitle = 1;
        public static final int[] SearchView = new int[]{16842970, 16843039, 16843296, 16843364, com.tanzx.instantrun.R.attr.layout, com.tanzx.instantrun.R.attr.iconifiedByDefault, com.tanzx.instantrun.R.attr.queryHint, com.tanzx.instantrun.R.attr.defaultQueryHint, com.tanzx.instantrun.R.attr.closeIcon, com.tanzx.instantrun.R.attr.goIcon, com.tanzx.instantrun.R.attr.searchIcon, com.tanzx.instantrun.R.attr.searchHintIcon, com.tanzx.instantrun.R.attr.voiceIcon, com.tanzx.instantrun.R.attr.commitIcon, com.tanzx.instantrun.R.attr.suggestionRowLayout, com.tanzx.instantrun.R.attr.queryBackground, com.tanzx.instantrun.R.attr.submitBackground};
        public static final int SearchView_android_focusable = 0;
        public static final int SearchView_android_imeOptions = 3;
        public static final int SearchView_android_inputType = 2;
        public static final int SearchView_android_maxWidth = 1;
        public static final int SearchView_closeIcon = 8;
        public static final int SearchView_commitIcon = 13;
        public static final int SearchView_defaultQueryHint = 7;
        public static final int SearchView_goIcon = 9;
        public static final int SearchView_iconifiedByDefault = 5;
        public static final int SearchView_layout = 4;
        public static final int SearchView_queryBackground = 15;
        public static final int SearchView_queryHint = 6;
        public static final int SearchView_searchHintIcon = 11;
        public static final int SearchView_searchIcon = 10;
        public static final int SearchView_submitBackground = 16;
        public static final int SearchView_suggestionRowLayout = 14;
        public static final int SearchView_voiceIcon = 12;
        public static final int[] Spinner = new int[]{16842930, 16843126, 16843131, 16843362, com.tanzx.instantrun.R.attr.popupTheme};
        public static final int Spinner_android_dropDownWidth = 3;
        public static final int Spinner_android_entries = 0;
        public static final int Spinner_android_popupBackground = 1;
        public static final int Spinner_android_prompt = 2;
        public static final int Spinner_popupTheme = 4;
        public static final int[] SwitchCompat = new int[]{16843044, 16843045, 16843074, com.tanzx.instantrun.R.attr.thumbTint, com.tanzx.instantrun.R.attr.thumbTintMode, com.tanzx.instantrun.R.attr.track, com.tanzx.instantrun.R.attr.trackTint, com.tanzx.instantrun.R.attr.trackTintMode, com.tanzx.instantrun.R.attr.thumbTextPadding, com.tanzx.instantrun.R.attr.switchTextAppearance, com.tanzx.instantrun.R.attr.switchMinWidth, com.tanzx.instantrun.R.attr.switchPadding, com.tanzx.instantrun.R.attr.splitTrack, com.tanzx.instantrun.R.attr.showText};
        public static final int SwitchCompat_android_textOff = 1;
        public static final int SwitchCompat_android_textOn = 0;
        public static final int SwitchCompat_android_thumb = 2;
        public static final int SwitchCompat_showText = 13;
        public static final int SwitchCompat_splitTrack = 12;
        public static final int SwitchCompat_switchMinWidth = 10;
        public static final int SwitchCompat_switchPadding = 11;
        public static final int SwitchCompat_switchTextAppearance = 9;
        public static final int SwitchCompat_thumbTextPadding = 8;
        public static final int SwitchCompat_thumbTint = 3;
        public static final int SwitchCompat_thumbTintMode = 4;
        public static final int SwitchCompat_track = 5;
        public static final int SwitchCompat_trackTint = 6;
        public static final int SwitchCompat_trackTintMode = 7;
        public static final int[] TextAppearance = new int[]{16842901, 16842902, 16842903, 16842904, 16842906, 16843105, 16843106, 16843107, 16843108, com.tanzx.instantrun.R.attr.textAllCaps};
        public static final int TextAppearance_android_shadowColor = 5;
        public static final int TextAppearance_android_shadowDx = 6;
        public static final int TextAppearance_android_shadowDy = 7;
        public static final int TextAppearance_android_shadowRadius = 8;
        public static final int TextAppearance_android_textColor = 3;
        public static final int TextAppearance_android_textColorHint = 4;
        public static final int TextAppearance_android_textSize = 0;
        public static final int TextAppearance_android_textStyle = 2;
        public static final int TextAppearance_android_typeface = 1;
        public static final int TextAppearance_textAllCaps = 9;
        public static final int[] Toolbar = new int[]{16842927, 16843072, com.tanzx.instantrun.R.attr.title, com.tanzx.instantrun.R.attr.subtitle, com.tanzx.instantrun.R.attr.logo, com.tanzx.instantrun.R.attr.contentInsetStart, com.tanzx.instantrun.R.attr.contentInsetEnd, com.tanzx.instantrun.R.attr.contentInsetLeft, com.tanzx.instantrun.R.attr.contentInsetRight, com.tanzx.instantrun.R.attr.contentInsetStartWithNavigation, com.tanzx.instantrun.R.attr.contentInsetEndWithActions, com.tanzx.instantrun.R.attr.popupTheme, com.tanzx.instantrun.R.attr.titleTextAppearance, com.tanzx.instantrun.R.attr.subtitleTextAppearance, com.tanzx.instantrun.R.attr.titleMargin, com.tanzx.instantrun.R.attr.titleMarginStart, com.tanzx.instantrun.R.attr.titleMarginEnd, com.tanzx.instantrun.R.attr.titleMarginTop, com.tanzx.instantrun.R.attr.titleMarginBottom, com.tanzx.instantrun.R.attr.titleMargins, com.tanzx.instantrun.R.attr.maxButtonHeight, com.tanzx.instantrun.R.attr.buttonGravity, com.tanzx.instantrun.R.attr.collapseIcon, com.tanzx.instantrun.R.attr.collapseContentDescription, com.tanzx.instantrun.R.attr.navigationIcon, com.tanzx.instantrun.R.attr.navigationContentDescription, com.tanzx.instantrun.R.attr.logoDescription, com.tanzx.instantrun.R.attr.titleTextColor, com.tanzx.instantrun.R.attr.subtitleTextColor};
        public static final int Toolbar_android_gravity = 0;
        public static final int Toolbar_android_minHeight = 1;
        public static final int Toolbar_buttonGravity = 21;
        public static final int Toolbar_collapseContentDescription = 23;
        public static final int Toolbar_collapseIcon = 22;
        public static final int Toolbar_contentInsetEnd = 6;
        public static final int Toolbar_contentInsetEndWithActions = 10;
        public static final int Toolbar_contentInsetLeft = 7;
        public static final int Toolbar_contentInsetRight = 8;
        public static final int Toolbar_contentInsetStart = 5;
        public static final int Toolbar_contentInsetStartWithNavigation = 9;
        public static final int Toolbar_logo = 4;
        public static final int Toolbar_logoDescription = 26;
        public static final int Toolbar_maxButtonHeight = 20;
        public static final int Toolbar_navigationContentDescription = 25;
        public static final int Toolbar_navigationIcon = 24;
        public static final int Toolbar_popupTheme = 11;
        public static final int Toolbar_subtitle = 3;
        public static final int Toolbar_subtitleTextAppearance = 13;
        public static final int Toolbar_subtitleTextColor = 28;
        public static final int Toolbar_title = 2;
        public static final int Toolbar_titleMargin = 14;
        public static final int Toolbar_titleMarginBottom = 18;
        public static final int Toolbar_titleMarginEnd = 16;
        public static final int Toolbar_titleMarginStart = 15;
        public static final int Toolbar_titleMarginTop = 17;
        public static final int Toolbar_titleMargins = 19;
        public static final int Toolbar_titleTextAppearance = 12;
        public static final int Toolbar_titleTextColor = 27;
        public static final int[] View = new int[]{16842752, 16842970, com.tanzx.instantrun.R.attr.paddingStart, com.tanzx.instantrun.R.attr.paddingEnd, com.tanzx.instantrun.R.attr.theme};
        public static final int[] ViewBackgroundHelper = new int[]{16842964, com.tanzx.instantrun.R.attr.backgroundTint, com.tanzx.instantrun.R.attr.backgroundTintMode};
        public static final int ViewBackgroundHelper_android_background = 0;
        public static final int ViewBackgroundHelper_backgroundTint = 1;
        public static final int ViewBackgroundHelper_backgroundTintMode = 2;
        public static final int[] ViewStubCompat = new int[]{16842960, 16842994, 16842995};
        public static final int ViewStubCompat_android_id = 0;
        public static final int ViewStubCompat_android_inflatedId = 2;
        public static final int ViewStubCompat_android_layout = 1;
        public static final int View_android_focusable = 1;
        public static final int View_android_theme = 0;
        public static final int View_paddingEnd = 3;
        public static final int View_paddingStart = 2;
        public static final int View_theme = 4;
        public static final long serialVersionUID = 0;

        styleable(Object[] objArr, InstantReloadException instantReloadException) {
            switch (((String) objArr[1]).hashCode()) {
                case -1968665286:
                    return;
                case 1885841254:
                    this();
                    return;
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R$styleable"}));
            }
        }

        public static /* synthetic */ Object access$super(styleable styleable, String str, Object... objArr) {
            switch (str.hashCode()) {
                case -2128160755:
                    return super.toString();
                case -1554832987:
                    super.finalize();
                    return null;
                case -1021472056:
                    super.wait(((Number) objArr[0]).longValue());
                    return null;
                case 201261558:
                    return super.getClass();
                case 1403628309:
                    return new Integer(super.hashCode());
                case 1814730534:
                    return new Boolean(super.equals(objArr[0]));
                case 2025021518:
                    return super.clone();
                default:
                    throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R$styleable"}));
            }
        }

        public styleable() {
            IncrementalChange incrementalChange = $change;
            if (incrementalChange != null) {
                Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R$styleable;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
                Object[] objArr2 = (Object[]) objArr[0];
                this(objArr, null);
                objArr2[0] = this;
                incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R$styleable;[Ljava/lang/Object;)V", objArr2);
            }
        }
    }

    R(Object[] objArr, InstantReloadException instantReloadException) {
        switch (((String) objArr[1]).hashCode()) {
            case -1968665286:
                return;
            case -759394817:
                this();
                return;
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{(String) objArr[1], Integer.valueOf(((String) objArr[1]).hashCode()), "android/support/v7/appcompat/R"}));
        }
    }

    public static /* synthetic */ Object access$super(R r, String str, Object... objArr) {
        switch (str.hashCode()) {
            case -2128160755:
                return super.toString();
            case -1554832987:
                super.finalize();
                return null;
            case -1021472056:
                super.wait(((Number) objArr[0]).longValue());
                return null;
            case 201261558:
                return super.getClass();
            case 1403628309:
                return new Integer(super.hashCode());
            case 1814730534:
                return new Boolean(super.equals(objArr[0]));
            case 2025021518:
                return super.clone();
            default:
                throw new InstantReloadException(String.format("String switch could not find '%s' with hashcode %s in %s", new Object[]{str, Integer.valueOf(str.hashCode()), "android/support/v7/appcompat/R"}));
        }
    }

    public R() {
        IncrementalChange incrementalChange = $change;
        if (incrementalChange != null) {
            Object[] objArr = (Object[]) incrementalChange.access$dispatch("init$args.([Landroid/support/v7/appcompat/R;[Ljava/lang/Object;)Ljava/lang/Object;", null, new Object[0]);
            Object[] objArr2 = (Object[]) objArr[0];
            this(objArr, null);
            objArr2[0] = this;
            incrementalChange.access$dispatch("init$body.(Landroid/support/v7/appcompat/R;[Ljava/lang/Object;)V", objArr2);
        }
    }
}
