package com.dieulinh.crytography;

import java.util.Stack;

/**
 * Created by DieuLinh on 03/09/2017 at 08:02.
 */
public interface Crytography {
    /*
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

    /*
    * Mật mã Afine:
    * Mã hóa: y = (a*x + b) mod 26
    * Giải maz: x = (y - b)*a^-1 mod 26
    * a*-1 là nghịch đảo của a mod 26
    */
    static void decryptAfine(String text, int a, int b) {
        char[] arr = text.toCharArray();
        int len = arr.length;
        int a1 = Mathematics.inverseOfModular(a, 26);
        for (int i = 0; i < len; i++) {
            if (arr[i] != ' ') {
                arr[i] = (char) ((((arr[i] - 65 - b)*a1) % 26) + 65);
            }
        }
        StringBuilder textBuilder = new StringBuilder();
        for (char iC :
                arr) {
            textBuilder.append(iC);
        }
        System.out.println(textBuilder);
    }


    static void encryptAfine(String text, int a, int b) {
        if (Mathematics.gcd(a, 26) != 1){
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

}
