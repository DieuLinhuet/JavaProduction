package com.t3h.buoi3;

/**
 * Created by ducnd on 20/02/2017.
 */
public class GPTB1 {
    private int heSoA, heSoB;
    private float ketQua;
    private String ketLuan;

    public GPTB1(int heSoA, int heSoB){
//        heSoA = heSoA;
//        heSoB = heSoB;
        this.heSoA = heSoA;
        this.heSoB = heSoB;
    }

    public GPTB1(GPTB1 pt){
        heSoA = pt.heSoA;
        heSoB = pt.heSoB;
    }

//    public void nhapHeSoA(int _heSoA){
//        heSoA = _heSoA;
//    }
//
//    public void nhapHeSoB(int _heSoB) {
//        heSoB = _heSoB;
//    }

    public void gpt(){
       if ( heSoA == 0 ) {
           ketLuan = "Khong phai pt bac 1";
           return;
       }

       ketQua = (float)-heSoB/heSoA;
       ketLuan = "Pt co mot nghiem x = " + ketQua;
    }

    public void inKetQua(){
        System.out.println(ketLuan);
    }

}
