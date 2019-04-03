package com.chrosciu.java12demo;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;

public class FirstDayOfWeek {
    private static final Locale locale = Locale.forLanguageTag("pl-PL-u-fw-fri");

    private static LocalDate getFirstDayOfWeek(LocalDate date) {
        return date.with(WeekFields.of(locale).getFirstDayOfWeek());
    }

    public static void main(String[] args) {
        if (null == args || args.length < 1) {
            throw new IllegalArgumentException("At least one argument (date) is needed");
        }
        System.out.println(getFirstDayOfWeek(LocalDate.parse(args[0])));
    }
}
