package com.t3h.demofile.chuabaitaparray;

import com.t3h.demofile.Utils;

import java.util.Arrays;

/**
 * Created by ducnd on 15/03/2017.
 */
public class ArrayIntManager {
    private int[] arrValue;

    public ArrayIntManager() {
        arrValue = new int[]{1, 2, 3, 5, 4, 6, 7, 8, 9, 8, 7, 6, 5, 11, 12, 13, 15, 14,
                16, 18, 2, 4, 3, 5, 7, 9, 11, 11, 11, 12, 13, 14, 3, 4, 32, 1, 2, 3, 4};
    }

    public void inDayConLienTiep(){
        int end = inRaDayConTangLienTiepDauTien(arrValue);
        int temArray[] = Utils.coppyArray(arrValue, end, arrValue.length);
        end = inRaDayConTangLienTiepDauTien(temArray);
        temArray = Utils.coppyArray(arrValue, end, arrValue.length);

    }

    private int inRaDayConTangLienTiepDauTien(int array[]) {
        for ( int i = 1; i < array.length; i++ ) {
            if ( array[i] < array[i-1] ) {
                int arrCoppy[] = Utils.coppyArray(array, 0, i);
                System.out.println(Arrays.toString(arrCoppy));
                return i;
            }
        }
        return -1;
    }




}
