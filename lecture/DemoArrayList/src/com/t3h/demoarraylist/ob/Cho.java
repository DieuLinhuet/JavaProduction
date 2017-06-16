package com.t3h.demoarraylist.ob;

/**
 * Created by ducnd on 08/03/2017.
 */
public class Cho implements Pet {
    private String ten;

    public Cho(String ten) {
        this.ten = ten;
    }

    @Override
    public void choi() {
        System.out.println("di dao");
    }

    public void inTT(){
        System.out.println("ten: " + ten);
        System.out.println("hanh vi: ");
        choi();
    }
}
