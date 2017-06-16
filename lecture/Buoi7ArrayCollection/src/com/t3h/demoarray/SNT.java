package com.t3h.demoarray;

/**
 * Created by ducnd on 06/03/2017.
 */
public class SNT {

    public static boolean ktNt(int so){
        int can = (int)Math.sqrt(so);
        for ( int i =2; i < can; i++ ) {
            if ( so % i == 0 ) {
                return false;
            }
        }
        return true;
    }


}
