package com.dieulinh.crytography.main;

import com.dieulinh.crytography.Crytography;
import com.dieulinh.crytography.Mathematics;

import java.math.BigInteger;

/**
 * Created by DieuLinh on 03/09/2017 at 07:23.
 */
public class Main {
    public static void main(String[] args) {
        /*String text = "AB";
        Crytography.encryptAfine(text, 1, 2);*/

//        System.out.println(Mathematics.inverseOfModular(101, 4620));

        /*String text = "WVKPDUMURHRULLPYLLPUHIQO";
        System.out.println(Crytography.decryptVigener(text, "DHCN"));*/

//        System.out.println(Mathematics.modularExponentitation(3, 644, 645));

//        System.out.println(Crytography.encryptRSA(43, 59, 13, 1819));

        /*long[] tests = Crytography.encryptElGamal(2579, 2, 765, 1299, 853);
//        System.out.println(tests[0] + " " + tests[1]);

        System.out.println(Crytography.decryptElGamal(2579, 765, tests));*/

//        Encrypt "DieuLinh"

//        long x = (long) (3*Math.pow(26,7)+8*Math.pow(26,6)+4*Math.pow(26,5)+20*Math.pow(26,4)
//        + 11*Math.pow(26,3) + 8*Math.pow(26,2) + 13*26 + 7);
//        long q = 1000000;
//        long e = 1000000;
//        while (!Mathematics.isPrime(q)){
//            q++;
//        }
//        while (!Mathematics.isPrime(e)){
//            e++;
//        }
//        long p = e*q;
//        int alpha = 2;
//        long a = 10000019;
//        long k = 1000003;
//
//        while (!Mathematics.isPrime(p)){
//            p++;
//        }
//
//        System.out.println(x);
//        System.out.println(p);

//        435900307699 529918860241

//        long[] test1 = Crytography.encryptElGamal(p, alpha, a, x, k);
//
//        System.out.println(test1[0] + " " + test1[1]);
//
//        System.out.println(Crytography.decryptElGamal(p, a, test1));

//        System.out.println(Crytography.encryptRSA(p, q, Mathematics.inverseOfModular(e, ((p-1)*(q-1))), x));
//        System.out.println(Crytography.decryptRSA(p, q, e, Long.parseLong(new BigInteger("415078205059762608").toString())));
        System.out.println(Mathematics.shanks(458009, 2, 56851));
        System.out.println(Mathematics.modularExponentitation(2, 40007, 458009));
    }
}