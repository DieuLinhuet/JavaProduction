package com.t3h.tugiac;

/**
 * Created by ducnd on 20/02/2017.
 */
public class HinhVuong extends TucGiac {
    private int canh;

    public HinhVuong( int canh) {
        this.canh = canh;
    }

    @Override
    public void tinhChuVi(){
        chuVi = canh*4;
    }

    @Override
    public void tinhDienTich(){
        dienTich = canh*canh;
    }
}
