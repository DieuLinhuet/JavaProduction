package com.t3h.buoi3.main;

import com.t3h.buoi3.GPTB1;

/**
 * Created by ducnd on 20/02/2017.
 */
public class Main {
    public static void main(String[] args) {
//        GPTB1 gptb1 = new GPTB1();
//        gptb1.nhapHeSoA(10);
//        gptb1.nhapHeSoB(12);
//        gptb1.gpt();
//        gptb1.inKetQua();

        GPTB1 b1 = new GPTB1(10, 12);
        b1.gpt();
        b1.inKetQua();

        GPTB1 b2 = new GPTB1(b1);
        System.out.println("hello java");



    }
}
