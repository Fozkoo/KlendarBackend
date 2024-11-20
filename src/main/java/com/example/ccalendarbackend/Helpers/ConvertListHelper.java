package com.example.ccalendarbackend.Helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertListHelper {


    public static List<Long> convertToLongList(String concatenated) {
        if (concatenated == null || concatenated.isEmpty())
            return new ArrayList<>();
        return Arrays.stream(concatenated.split(","))
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }


    public static List<String> splitToStringList(String concatenated) {
        if (concatenated == null || concatenated.isEmpty())
            return new ArrayList<>();
        return Arrays.asList(concatenated.split(","));
    }

}
