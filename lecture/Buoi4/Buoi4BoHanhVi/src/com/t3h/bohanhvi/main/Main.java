package com.t3h.bohanhvi.main;

import com.t3h.bohanhvi.Cho;
import com.t3h.bohanhvi.DongVat;
import com.t3h.bohanhvi.IHanhViDV;

/**
 * Created by ducnd on 22/02/2017.
 */
public class Main {
    public static void main(String[] args) {
//        DongVat dv = new Cho("kiki");
        IHanhViDV hv = new Cho("milu");
        if ( hv instanceof  Cho ) {
            Cho ch = (Cho)hv;
        }
        if ( hv instanceof DongVat ) {
            DongVat dongVat = (DongVat)hv;
        }
        hv.keu();
        hv.an();

    }
}
