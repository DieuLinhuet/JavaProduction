package com.t3h.demoarray;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by ducnd on 06/03/2017.
 */
public class QuanLyHocSinh {
    private HocSinh hs[];

    public QuanLyHocSinh() {
        hs = new HocSinh[5];
        hs[0] = new HocSinh("ha", 20);
        hs[1] = new HocSinh("Nam", 5);
        hs[2] = new HocSinh("Thai", 19);
        hs[3] = new HocSinh("Tien", 21);
        hs[4] = new HocSinh("Minh", 40);
    }

    public void sapXepTuoiTangDan(){
        Comparator<HocSinh> comparator = new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh h1, HocSinh hs2) {
                if ( h1.getTuoi() == hs2.getTuoi() ) {
                    return 0;
                }
                if ( h1.getTuoi() > hs2.getTuoi() ) {
                    return 1;
                }else {
                    return -1;
                }
            }
        };

        Arrays.sort(hs, comparator);
        System.out.println("sdfkjshfksdhf");
    }
}
