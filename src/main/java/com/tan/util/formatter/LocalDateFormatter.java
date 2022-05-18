package com.tan.util.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * @author Tan
 * @version 1.0.0
 * @ClassName LocalDateFormatter.java
 * @Description TODO
 * @createTime 2022-05-12 05:55:00
 */
public class LocalDateFormatter implements Formatter<LocalDate> {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return  LocalDate.parse(text, dateTimeFormatter);
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return dateTimeFormatter.format(object);
    }
}
