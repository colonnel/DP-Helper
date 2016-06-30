package com.gmail.berezin.serg.dphelper;


public class Utils {
    //Method calculates dpi of graphic res
    public static int calculate(double high, double width, double inches) {
        return (int) (Math.sqrt(Math.pow(high, 2) + Math.pow(width, 2)) / inches);
    }

    //Method sets a destination for graphic res
    public static int setTarget(int dpi) {
        if (dpi <= 120) {
            return R.string.folder_ldpi;
        } else if (dpi > 120 && dpi <= 160) {
            return R.string.folder_mdpi;
        } else if (dpi > 160 && dpi <= 240) {
            return R.string.folder_hdpi;
        } else if (dpi > 240 && dpi <= 320) {
            return R.string.folder_xhdpi;
        } else if (dpi > 320 && dpi <= 480) {
            return R.string.folder_xxhdpi;
        } else if (dpi > 480 && dpi <= 640) {
            return R.string.folder_xxxhdpi;
        } else {
            return 0;
        }
    }
}
