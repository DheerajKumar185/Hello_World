package com.tech.spring.boot.docker.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class SystemDateTime {

    private SystemDateTime() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static String getDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
