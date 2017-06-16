package com.t3h.demoarraylist.ob;

/**
 * Created by ducnd on 08/03/2017.
 */
public class HocSinh {
    private String ten;
    private int tuoi;

    public HocSinh(String ten, int tuoi) {
        this.ten = ten;
        this.tuoi = tuoi;
    }

    public String getTen() {
        return ten;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void intTT(){
        System.out.println("ten: " + ten);
        System.out.println("tuoi: " + tuoi);
    }
}
