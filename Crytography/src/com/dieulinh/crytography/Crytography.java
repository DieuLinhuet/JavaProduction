package com.dieulinh.crytography;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by DieuLinh on 03/09/2017 at 08:02.
 */
public interface Crytography {
    /**
     * Mật mã Caesar:
     * Mã hóa bằng cách dịch mỗi ký tự 3 đơn vị, sau đó mod 26
     * Giải mã làm ngược lại
     */

    static void encrytCaesar(String text) {
        char[] c = text.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i++) {
            if (c[i] != ' ') {
                c[i] = (char) (((c[i] - 62) % 26) + 65);
            }
        }
        StringBuilder textBuilder = new StringBuilder();
        for (char aC : c) {
            textBuilder.append(aC);
        }
        System.out.println(textBuilder);
    }

    static void decryptCaesar(String text) {
        char[] c = text.toCharArray();
        int len = c.length;
        for (int i = 0; i < len; i++) {
            if (c[i] != ' ') {
                c[i] = (char) ((c[i] + 62) % 26 + 65);
            }
        }
        StringBuilder textBuilder = new StringBuilder();
        for (char iC :
                c) {
            textBuilder.append(iC);
        }
        System.out.println(textBuilder);
    }

    /**
     * Mật mã Afine:
     * Mã hóa: y = (a*x + b) mod 26
     * Giải maz: x = (y - b)*a^-1 mod 26
     * a*-1 là nghịch đảo của a mod 26
     */

    static void decryptAfine(String text, int a, int b) {
        char[] arr = text.toCharArray();
        int len = arr.length;
        long a1 = Mathematics.inverseOfModular(a, 26);
        for (int i = 0; i < len; i++) {
            if (arr[i] != ' ') {
                arr[i] = (char) ((((arr[i] - 65 - b) * a1) % 26) + 65);
            }
        }
        StringBuilder textBuilder = new StringBuilder();
        for (char iC : arr) {
            textBuilder.append(iC);
        }
        System.out.println(textBuilder);
    }

    static void encryptAfine(String text, int a, int b) {
        if (Mathematics.gcd(a, 26) != 1) {
            System.out.println("???");
            return;
        }
        char[] arr = text.toCharArray();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (arr[i] != ' ') {
                arr[i] = (char) ((a * (arr[i] - 65) + b) % 26 + 65);
            }
        }
        StringBuilder textBuilder = new StringBuilder();
        for (char iC :
                arr) {
            textBuilder.append(iC);
        }
        System.out.println(textBuilder);
    }

    /**
     * Mật mã Vigener:
     * Mã hóa: cho bộ key m ký tự, chia text thành các bộ m ký tự (x1, x2, ..., xn)
     * (y1, y2, ..., yn) = (x1 + k1, x2 + k2, ..., xn + kn) mod 26
     * Giải mã:
     * (x1, x2, ..., xn) = (y1 - k1, y2 - k2, ..., yn - kn) mod 26
     */

    static String encryptVigener(String text, String code) {
        String result = "";
        int m = code.length();
        int len = text.length();
        if (len % m != 0) {
            int temp = m * (len / m + 1) - len;
            for (int i = 0; i < temp; i++) {
                text += "Z";
            }
        }
        char[] texts = text.toCharArray();
        char[] keys = code.toCharArray();
        int num = texts.length / m;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < m; j++) {
                char c = (char) ((((texts[j + i * m] + keys[j]) - 2 * 65) % 26) + 65);
                result += c;
            }
        }
        return result;
    }

    static String decryptVigener(String codeText, String keyText) {
        String text = "";
        char[] texts = codeText.toCharArray();
        char[] keys = keyText.toCharArray();
        int m = keys.length;
        int lentText = texts.length;
        int num = lentText / m;
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < m; j++) {
                char c = (char) (((texts[j + i * m] - keys[j]) % 26) + 65);
                text += c;
            }
        }
        return text;
    }

    /**
     * Mã hóa RSA: 2 số nguyên tố p, q, e là so nguyen to cung nhau voi (p-1)(q-1)
     * n = p.q -> y = x^e mod n
     * Giai ma: d = e^-1 mod n
     * x = y^e mod n
     */

    static long encryptRSA(long p, long q, long e, long x) {
        long n = p * q;
        return Mathematics.modularExponentitation(x, e, n);
    }

    static long decryptRSA(long p, long q, long e, long y) {
        long theta = (p - 1) * (q - 1);
        long n = p * q;
        long d = Mathematics.inverseOfModular(e, n);
        return Mathematics.modularExponentitation(y, d, n);
    }

    /**
     * Hệ mật Elgamal:
     * Mã hóa: K(p, alpha, a, beta), beta = alpha^a mod p, p là số nguyên tố, a là phần tử nguyên thủy
     * e(x, k) = (y1, y2), k là số bất kỳ thuộc Z(p-1)
     * y1 = alpha^k mod p
     * y2 = x.beta^k mod p
     * Giải mã: x = y2(y1^a)^-1 mod p
     */

    static long[] encryptElGamal(long p, long alpha, long a, long x, long k) {
        long beta = Mathematics.modularExponentitation(alpha, a, p);
        System.out.println(beta);
        long[] y = new long[2];
        y[0] = Mathematics.modularExponentitation(alpha, k, p);
        long temp = Mathematics.modularExponentitation(beta, k, p);
        y[1] = Long.parseLong((new BigInteger(x+"")).multiply(new BigInteger(temp+""))
                .mod(new BigInteger(p+"")).toString());
        return y;
    }

    static long decryptElGamal(long p, long a, long[] y){
        long x1 = Mathematics.inverseOfModular(y[0], p);
        long x2 = Mathematics.modularExponentitation(x1, a, p);
        return Long.parseLong(new BigInteger(y[1]+"").multiply(new BigInteger(x2+""))
                .mod(new BigInteger(p+"")).toString());


    }

}
