package com.example.ccalendarbackend.Helpers;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;



public class DateTimeHelper {

    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public static String formatTime(Time sqlTime) {
        if (sqlTime == null) return null;
        LocalTime localTime = sqlTime.toLocalTime();
        return localTime.format(TIME_FORMATTER);
    }


    public static String formatDate(Date row) {
        if (row == null) return null;
        LocalDate localDate = row.toLocalDate();
        return localDate.format(DATE_FORMATTER);
    }
}
