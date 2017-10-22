package com.dieulinh.crytography;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DieuLinh on 12/09/2017 at 06:34.
 */
public interface Mathematics {
    /**
     * Input: co so b, so tu nhien num ( co so 10)
     * Output: chuyen num tu co so 10 sang co so b
     */
    static String baseBExpention(int b, long num) {
        String result = "";
        long q = num;
        while (q != 0) {
            long ak = q % b;
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

//    Tính b^n mod m
    static long modularExponentitation(long b, long n, long m) {
        long result = 1;
        BigInteger modular = new BigInteger(m+"");
        long power = b % m;
        String binaryNum = baseBExpention(2, n);
        int len = binaryNum.length();
        for (int i = len - 1; i >= 0; i--) {
            BigInteger bigInteger = new BigInteger(power+"");
            int ai = Integer.parseInt(String.valueOf(binaryNum.charAt(i)));
            if (ai == 1) {
                result = Long.parseLong(bigInteger.multiply((new BigInteger(result+""))).mod(modular).toString());

            }
            power = Long.parseLong(bigInteger.multiply(bigInteger).mod(modular).toString());
        }
        return result;
    }

    /**
     * num1 >= 0
     * num2 >= 0
     */
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

//    Tính a^-1 mod m
    static long inverseOfModular(long a, long m) {
        long m0 = m;
        long a0 = a;
        long t0 = 0;
        long t = 1;
        long q = m0 / a0;
        long r = m0 - q* a0;
        while (r > 0){
            long temp = (t0 - q*t) % m;
            t0 = t;
            t = temp;
            m0 = a0;
            a0 = r;
            q = m0 / a0;
            r = m0 - a0*q;
        }
        if (a0 != 1){
            System.out.println( a + " has no inverse modulo " + m);
            return -1;
        }
        if (t < 0){
            return m + t;
        }
        return t;
    }

    static int findPrimitiveElement(long a){
        ArrayList<Integer> nums = new ArrayList<>();
        for (int i = 1; i < a; i++){
            if (a % i == 0){
                nums.add(i);
            }
        }
        int sizeOfNums = nums.size();
        for (int i = 0; i < sizeOfNums; i++){
            for (int j = i; j < sizeOfNums; j++){
                if (Math.pow(nums.get(i), nums.get(j)) % a == (a-1)){
                    return i;
                }
            }
        }
        return 1;
    }

    static boolean isPrime(long num){
        for (int i = 2; i < Math.sqrt(num); i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }

//    Shanks Algorithm: Tính a: alpha^a = beta (mod p)
    static long shanks(long p, long alpha, long beta){
        long m = (long) (Math.sqrt(p-1) + 1);
        List<Long> list1 = new ArrayList<>();
        List<Long> list2 = new ArrayList<>();
        long alpha1 = modularExponentitation(alpha, m, p);
        for (int i = 0; i < m-1; i++){
            long temp = modularExponentitation(alpha1, i, p);
            list1.add(temp);

            long temp2 = inverseOfModular(alpha, p);
            long temp3 = modularExponentitation(temp2, i, p);
            long temp4 = modularExponentitation(beta*temp3, 1, p);
            list2.add(temp4);
        }
        for (int i = 0; i < m-1; i++){
            if (list2.contains(list1.get(i))){
                int j = list2.indexOf(list1.get(i));
                return modularExponentitation((m*i+j), 1, p-1);
            }
        }
        return -1;
    }

//
    static List<Long> pohigHellman(long n, long alpha, long beta, long c){
        List<Long> result = new ArrayList<>();
        long j = 0;
        long bi = beta;
        while (j <= c - 1){
        }
        return result;
    }

}
