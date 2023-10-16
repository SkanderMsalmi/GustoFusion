package com.gustofusion.gestionreservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.format.DateTimeFormatter;

@Configuration
public class DateTimeFormatterConfig {
    public static final DateTimeFormatter ISO_8601_FORMATTER = DateTimeFormatter.ISO_OFFSET_DATE_TIME;
}
