package com.t3h.buoi3.main;

import com.t3h.buoi3.HocSinh;
import com.t3h.buoi3.Lop;
import com.t3h.buoi3.QuanLy;

/**
 * Created by ducnd on 22/02/2017.
 */
public class Main {
    public static void main(String[] args) {
        HocSinh hs1 = new HocSinh("Nguyen Van A", 10, 9, 8);
        HocSinh hs2 = new HocSinh("Nguyen Van B", 10, 5, 8);
        HocSinh hs3 = new HocSinh("Nguyen Van AAA", 10, 5, 8);
        HocSinh hs4 = new HocSinh("Nguyen Van sdf", 10, 10, 8);
        Lop lop1 = new Lop(hs1, hs2);
        Lop lop2 = new Lop(hs3, hs4);






        QuanLy quanLy = new QuanLy(lop1, lop2);
        quanLy.inTTLop();
    }
}
