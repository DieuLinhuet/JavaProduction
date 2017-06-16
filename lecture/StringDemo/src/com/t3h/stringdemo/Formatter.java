package com.t3h.stringdemo;

public class Formatter {
    public static String formatName(String name) {
        name = name.trim();
        while (name.contains("  ")) {
            name = name.replace("  ", " ");
        }
        name = name.toLowerCase();
        String temp = name.substring(0, 1).toUpperCase();
        for (int i = 1; i < name.length(); i++) {
            if (name.charAt(i - 1) == ' ') {
                temp += name.substring(i, i + 1).toUpperCase();
            } else {
                temp += name.charAt(i);
            }
        }
        return temp;
    }

}