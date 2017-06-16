package com.t3h.demoarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

/**
 * Created by ducnd on 06/03/2017.
 */
public class ManagerInt {
    private Integer arrayInt[];

    public ManagerInt() {
        inits();
    }

    private void inits() {
        arrayInt = new Integer[10];
        Random rd = new Random();

        for (int i = 0; i < arrayInt.length; i++) {
            arrayInt[i] = rd.nextInt(1000);
        }
    }

    public void printArrayInt() {
        arrayInt.toString();
    }

    //tong cac so nguyen
    public int tongSoNguyen() {
        int tong = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            tong += arrayInt[i];
        }
        return tong;
    }

    //tong le
    public int tongLe() {
        int tongLe = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] % 2 != 0) {
                tongLe += arrayInt[i];
            }
        }
        return tongLe;
    }

    //tong le
    public int tongLeViTriChanNhoHon15() {
        int tongLe = 0;
        if (arrayInt.length < 15) {
            for (int i = 0; i < arrayInt.length; i += 2) {
                if (arrayInt[i] % 2 != 0) {
                    tongLe += arrayInt[i];
                }
            }
        } else {
            for (int i = 0; i < 15; i += 2) {
                if (arrayInt[i] % 2 != 0) {
                    tongLe += arrayInt[i];
                }
            }
        }

        return tongLe;
    }
    //tong so nguyen to

    public int tongNguyenTo() {
        //////
        /////
        int tongNt = 0;
        for (int i = 0; i < arrayInt.length; i++) {
            boolean laNT = SNT.ktNt(arrayInt[i]);
            if (laNT) {
                tongNt += arrayInt[i];
            }
        }
        return tongNt;
    }


    public int timLonNhat() {
        int max = arrayInt[0];
        for (int i = 1; i < arrayInt.length; i++) {
            if ( max < arrayInt[i] ) {
                max = arrayInt[i];
            }
        }
        return max;
    }

    public void sapXepTangDan(){
        for ( int i = 0; i < arrayInt.length; i++ ) {
            for ( int j = i+1; j < arrayInt.length; j++){
                if ( arrayInt[i] > arrayInt[j] ) {
                    int tam = arrayInt[i];
                    arrayInt[i] = arrayInt[j];
                    arrayInt[j] = tam;
                }
            }
        }
    }

    public void sapXepTangSDArray(){
        Arrays.sort(arrayInt);
    }

    public void sapXepGiamDan(){
        Comparator<Integer> compa = new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                if ( i1 == i2 ) {
                    return 0;
                }
                if ( i1 < i2 ) {
                    return 1;
                }else {
                    return -1;
                }
            }
        };
        Arrays.sort(arrayInt, compa);
    }

    public void print(){
        System.out.println(Arrays.toString(arrayInt));
    }

}
