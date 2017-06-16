package com.t3h.buoi3;

/**
 * Created by ducnd on 22/02/2017.
 */
public class Lop {
    private String maLop;
    private String tenLop;
    private HocSinh hocSinh1;
    private HocSinh hocSinh2;

    public Lop(HocSinh hocSinh1, HocSinh hocSinh2) {
        this.hocSinh1 = hocSinh1;
        this.hocSinh2 = hocSinh2;
    }

    public Lop(String maLop, String tenLop, HocSinh hocSinh1, HocSinh hocSinh2) {
        this.maLop = maLop;
        this.tenLop = tenLop;
        this.hocSinh1 = hocSinh1;
        this.hocSinh2 = hocSinh2;
    }
    public Lop(String maLop, String tenLop) {
        this.maLop = maLop;
        this.tenLop = tenLop;
    }

    public void nhapDS(HocSinh hocSinh1, HocSinh hocSinh2) {
        this.hocSinh1 = hocSinh1;
        this.hocSinh2 = hocSinh2;
    }

    public void inLop(){
        System.out.println("ma lop: " + maLop);
        System.out.println("ten lop: " + tenLop);
        hocSinh1.inTT();
        hocSinh2.inTT();
    }

}
