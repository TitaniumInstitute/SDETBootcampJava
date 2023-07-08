package com.ti.java;

public enum WeekDays {
    MONDAY(2, "Work"),
    TUESDAY(4, "Go to park"),
    WEDNESDAY(5, "Play Piano"),
    THURSDAY(8, "Dance"),
    FRIDAY(10, "Party"),
    SATURDAY(10, "Party crazy"),
    SUNDAY(1, "Rest");

    final int rankig;
    final String event;

    WeekDays(int rankig, String event) {
        this.rankig = rankig;
        this.event = event;
    }
}
