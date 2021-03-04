package com.example.retriesdemo.utils;

import java.util.Optional;

public class StringUtils {

    public static String reverse(String s) {
        var inputText = Optional
                .ofNullable(s)
                .orElseThrow(IllegalArgumentException::new);

        final int N = inputText.length();

        var strBuilder = new StringBuilder();

        for (int i = N - 1; i >= 0; i--) {
            strBuilder.append(inputText.charAt(i));
        }

        return strBuilder.toString();
    }

}
