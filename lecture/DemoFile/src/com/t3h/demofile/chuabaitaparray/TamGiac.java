package com.t3h.demofile.chuabaitaparray;

/**
 * Created by ducnd on 15/03/2017.
 */
public class TamGiac {
    private int a;
    private int b;
    private int c;
    private double s;

    public TamGiac(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public void tinhDienDichTamGiac() {
        float p = (float) (a + b + c) / 2;
        s = Math.sqrt(p * (p - a) * (p - c) * (p - c));
    }

    public double getDienTich() {
        return s;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }
}
