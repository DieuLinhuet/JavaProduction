package com.t3h.bohanhvi;

/**
 * Created by ducnd on 22/02/2017.
 */
public class Cho extends DongVat implements IHanhViDV {
    public Cho(String ten) {
        super(ten);
    }

    @Override
    public void keu() {
        System.out.println("gogo");
    }

    @Override
    public void an() {
        System.out.println("xuong");
    }
}
