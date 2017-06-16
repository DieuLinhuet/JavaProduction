package com.t3h.stringdemo;

public class BigInteger {
    public static String add(String a, String b) {
        while (b.length() < a.length()) {
            b = "0" + b;
        }
        while (a.length() < b.length()) {
            a = "0" + a;
        }

        String sum = "";
        int carry = 0;

        for (int i = a.length() - 1; i >= 0; i--) {
            int x = (a.charAt(i) - 48)
                    + (b.charAt(i) - 48)
                    + carry;
            carry = x / 10;
            sum = x % 10 + sum;
        }
        if (carry == 1) {
            sum = "1" + sum;
        }

        return sum;
    }

}