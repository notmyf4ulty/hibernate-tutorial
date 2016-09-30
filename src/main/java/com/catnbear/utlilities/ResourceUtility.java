package com.catnbear.utlilities;

import java.util.Locale;
import java.util.ResourceBundle;

public class ResourceUtility {
    private static final String TRANSLATION_PATH = "bundles.UI_translation";

    public static final ResourceBundle TRANSLATION_BUNDLE_ENG =
            ResourceBundle.getBundle(TRANSLATION_PATH, new Locale("en","EN"));

    public static final ResourceBundle TRANSLATION_BUNDLE_POL =
            ResourceBundle.getBundle(TRANSLATION_PATH, new Locale("pl","PL"));
}