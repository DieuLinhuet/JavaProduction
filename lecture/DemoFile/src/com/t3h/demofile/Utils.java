package com.t3h.demofile;

/**
 * Created by ducnd on 15/03/2017.
 */
public class Utils {
    public static int[] coppyArray(int src[], int start, int end) {
        int dst[] = new int[end-start];
        for ( int i = start; i < end; i++ ) {
            dst[i-start] = src[i];
        }
        return dst;
    }
}
