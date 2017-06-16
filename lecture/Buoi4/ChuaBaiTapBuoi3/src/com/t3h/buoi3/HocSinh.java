package com.t3h.buoi3;

/**
 * Created by ducnd on 22/02/2017.
 */
public class HocSinh {
    private String hoTen;
    private float diemToan;
    private float diemVan;
    private float diemAnh;

    public HocSinh(String hoTen, float diemToan, float diemVan, float diemAnh) {
        this.hoTen = hoTen;
        this.diemToan = diemToan;
        this.diemVan = diemVan;
        this.diemAnh = diemAnh;
    }

    public void inTT() {
        System.out.println("ten: " + hoTen);
        System.out.println("diem toan: " + diemToan);
        System.out.println("diem anh: " + diemAnh);
        System.out.println("diem van: " + diemVan);
    }

    public float tinhDiemTB() {
        float diemTB = (diemAnh + diemToan + diemVan) / 3;
        return diemTB;
    }
}
