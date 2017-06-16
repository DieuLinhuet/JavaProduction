package com.t3h.demofile.chuabaitaparray;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducnd on 15/03/2017.
 */
public class DienTichTamMang {
    private ArrayList<TamGiac> tamGiacs;
    private int[] arrInt;

    public DienTichTamMang() {
        arrInt =
                new int[]{2, 3, 5, 2, 3, 5, 12, 2, 4, 23, 33, 44};
        tamGiacs = new ArrayList<>();
        taoTamGiac();
    }

    private void taoTamGiac(){
        for ( int i = 0; i < arrInt.length-2; i++){
            for ( int j = i + 1; j < arrInt.length-1; j++) {
                for ( int k = j + 1; k < arrInt.length; k++ ) {
                    if ( arrInt[i] + arrInt[j] <= arrInt[k]) {
                        continue;
                    }
                    if ( arrInt[i] + arrInt[k] <= arrInt[j]) {
                        continue;
                    }
                    if ( arrInt[j] + arrInt[k] <= arrInt[i]) {
                        continue;
                    }
                    TamGiac tamGiac =
                            new TamGiac(arrInt[i], arrInt[j], arrInt[k]);
                    tamGiacs.add(tamGiac);
                }
            }
        }
    }

    public void tinhDienTichTaCaTamGiac(){
        for ( TamGiac tamGiac : tamGiacs ) {
            tamGiac.tinhDienDichTamGiac();
        }
    }

    public void inRaTamGiacCoDienTichLonNhat(){
        TamGiac tamGiacDienTichLonNhat = tamGiacs.get(0);
        for ( int i = 1; i < tamGiacs.size(); i++) {
            if ( tamGiacDienTichLonNhat.getDienTich() <
                    tamGiacs.get(i).getDienTich() ) {
                tamGiacDienTichLonNhat = tamGiacs.get(i);
            }
        }
        System.out.println("a: " + tamGiacDienTichLonNhat.getA());
        System.out.println("b: " + tamGiacDienTichLonNhat.getB());
        System.out.println("c: " + tamGiacDienTichLonNhat.getC());
        System.out.println("dien tich: " + tamGiacDienTichLonNhat.getDienTich());
    }







}
