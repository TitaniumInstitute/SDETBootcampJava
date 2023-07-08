package com.ti.java;

public class EnumExample {

    static final String FIRE_FOX = "webdriver,firefox";
    static final String CHROME = "webdriver,chrome";

    public static void main(String[] args) {
        int today = WeekDays.WEDNESDAY.rankig;

        System.out.println(today);
        System.out.println(WeekDays.SATURDAY.event);

        System.out.println(selectBrowser(Browsers.EDGE));
    }

    private static String selectBrowser(Browsers b) {
        String broweerSelected = switch (b) {
            case EDGE -> "Opening Edge browser";
            case CHROME -> "Opening Chrome browser";
            case FIREFOX -> "Opening Firefox browser";
            default -> "Bad option";
        };
        return broweerSelected;
    }
}
