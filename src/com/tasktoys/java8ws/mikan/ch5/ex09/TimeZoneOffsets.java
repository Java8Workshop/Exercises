/*
 * Copyright(C) 2014-2015 Java 8 Workshop participants. All rights reserved.
 * https://github.com/aosn/java8
 */

package com.tasktoys.java8ws.mikan.ch5.ex09;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author mikan
 */
public class TimeZoneOffsets {

    private TimeZoneOffsets() {
        // static use only
    }

    public static List<String> getTimeZones(Instant instant, int limit) {
        Objects.requireNonNull(instant);
        if (limit < 1) {
            throw new IllegalArgumentException("limit requires 1 or larger: " + limit);
        }
        final int seconds = limit * 60 * 60;
        return ZoneId.getAvailableZoneIds().stream()
                .map(z -> instant.atZone(ZoneId.of(z)))
                .filter(z -> z.getOffset().getTotalSeconds() < seconds && z.getOffset().getTotalSeconds() > -seconds)
                .map(z -> z.getOffset() + " (" + z.getZone().toString() + ")")
                .collect(Collectors.toList());
    }
}
