package com.t3h.buoi3;

/**
 * Created by ducnd on 22/02/2017.
 */
public class QuanLy {
    private Lop lop1;
    private Lop lop2;

    public QuanLy(Lop lop1, Lop lop2) {
        this.lop1 = lop1;
        this.lop2 = lop2;
    }

    public void inTTLop(){
        lop1.inLop();
        System.out.println("---------------");
        lop2.inLop();
    }
}
