package com.dieulinh.crytography;

/**
 * Created by DieuLinh on 12/09/2017 at 06:34.
 */
public interface Mathematics {
    /**
     * Input: co so b, so tu nhien num ( co so 10)
     * Output: chuyen num tu co so 10 sang co so b
     */
    static String baseBExpention(int b, int num) {
        String result = "";
        int q = num;
        while (q != 0) {
            int ak = q % b;
            q = q / b;
            result = ak + result;
        }
        return result;
    }

    static String binaryAdd(String binary1, String binary2) {
        String binarySum = "";
        int len;
        if (binary1.length() > binary2.length()) {
            binary1 = "0" + binary1;
            len = binary1.length();
            int num = len - binary2.length();
            for (int i = 0; i < num; i++) {
                binary2 = "0" + binary2;
            }
        } else if (binary1.length() < binary2.length()) {
            binary2 = "0" + binary2;
            len = binary2.length();
            int num = len - binary1.length();
            for (int i = 0; i < num; i++) {
                binary1 = "0" + binary1;
            }
        } else {
            if (binary1.charAt(0) != 0 || binary2.charAt(0) != 0) {
                binary1 = "0" + binary1;
                binary2 = "0" + binary2;
            }
            len = binary1.length();
        }
        int c = 0;
        for (int i = len - 1; i >= 0; i--) {
            int x1 = Integer.parseInt(String.valueOf(binary1.charAt(i)));
            int x2 = Integer.parseInt(String.valueOf(binary2.charAt(i)));
            int d = (x1 + x2 + c) / 2;
            int si = (x1 + x2 + c) - 2 * d;
            c = d;
            binarySum = si + binarySum;
        }
        if (c != 0) {
            binarySum = c + binarySum;
        }
        return binarySum;
    }

    static String binaryMul(String binary1, String binary2) {
        String result = "0";
        int len;
        if (binary1.length() > binary2.length()) {
            len = binary2.length();
        } else if (binary1.length() < binary2.length()) {
            len = binary1.length();
        } else {
            len = binary1.length();
        }
        String[] c = new String[len];
        for (int i = len - 1; i >= 0; i--) {
            int x2 = Integer.parseInt(String.valueOf(binary2.charAt(i)));
            if (x2 == 1) {
                c[len - 1 - i] = binary1;
                for (int j = 0; j < len - 1 - i; j++) {
                    c[len - 1 - i] += "0";
                }
            } else {
                c[len - 1 - i] = "0";
            }
        }
        for (int i = 0; i < len; i++) {
            result = binaryAdd(result, c[i]);
        }

        return result;
    }

    static int modularExponentitation(int b, int m) {
        int result = 1;
        int power = b % m;
        String binaryNum = baseBExpention(2, b);
        int len = binaryNum.length();
        for (int i = len - 1; i >= 0; i--) {
            int ai = Integer.parseInt(String.valueOf(binaryNum.charAt(i)));
            if (ai == 1) {
                result = (result * power) % m;
            }
            power = (power * power) % m;
        }
        return result;
    }

    static int gcd(int num1, int num2) {
        if (num1 > num2) {
            return gcd(num2, num1 - num2);
        }
        if (num1 < num2) {
            return gcd(num2 - num1, num1);
        } else {
            return num1;
        }
    }

    static int inverseOfModular(int a, int m) {
        int a0 = m;
        int b0 = a;
        int t = 1;
        int t0 = 0;
        int s0 = 1;
        int s = 0;
        int q = a0 / b0;
        int r = a0 - q * b0;
        while (r > 0) {
            int temp = t0 - q * t;
            t0 = t;
            t = temp;
            temp = s0 - q * s;
            s0 = s;
            s = temp;
            a0 = b0;
            b0 = r;
            q = a0 / b0;
            r = a0 - q * b0;
        }
        return t % m;
    }


}
