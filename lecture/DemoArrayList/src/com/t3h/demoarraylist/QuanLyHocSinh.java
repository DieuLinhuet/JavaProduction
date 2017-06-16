package com.t3h.demoarraylist;

import com.t3h.demoarraylist.ob.HocSinh;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ducnd on 08/03/2017.
 */
public class QuanLyHocSinh {
    private List<HocSinh> hocSinhs;

    public QuanLyHocSinh() {
        hocSinhs = new ArrayList<>();
    }

    public void themHocSinh(HocSinh hocSinh) {
        hocSinhs.add(hocSinh);
    }

    public void xoaHocSinh(int index) {
        hocSinhs.remove(index);
    }

    public void inTTHSS(){
        for ( HocSinh hs : hocSinhs ) {
            hs.intTT();
        }
    }


    public void sapXepHocSinhTheoTuoi(){
        Comparator<HocSinh> comparator = new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                if (o1.getTuoi() == o2.getTuoi()) {
                    return 0;
                }
                if ( o1.getTuoi() > o2.getTuoi() ) {
                    return 1;
                }
                return -1;
            }
        };
        Collections.sort(hocSinhs, comparator);
    }

    public void sapXepTheoTen(){
        Comparator<HocSinh> comparator = new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                String ten1 = o1.getTen();
                String ten2 = o2.getTen();
                if ( ten1.equals(ten2)) {
                    return 0;
                }

                int compar = ten1.compareTo(ten2);
                if ( compar > 0 ) {
                    return 1;
                }
                return -1;
            }
        };
        Collections.sort(hocSinhs, comparator);
    }


    public void sapXepTheoTuoiTen(){
        Comparator<HocSinh> comparator = new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh o1, HocSinh o2) {
                if ( o1.getTuoi() > o2.getTuoi() ) {
                    return  1;
                }

                if ( o1.getTuoi() < o1.getTuoi()) {
                    return -1;
                }

                String ten1 = o1.getTen();
                String ten2 = o2.getTen();
                int compa = ten1.compareTo(ten2);
                if ( compa > 0 ) {
                    return 1;
                }
                if ( compa < 0 ) {
                    return -1;
                }
                return 0;
            }
        };
    }


}
