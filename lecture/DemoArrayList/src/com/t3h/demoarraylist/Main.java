package com.t3h.demoarraylist;

import com.t3h.demoarraylist.ob.Cho;
import com.t3h.demoarraylist.ob.HocSinh;
import com.t3h.demoarraylist.ob.Pet;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducnd on 08/03/2017.
 */
public class Main {
    public static void main(String[] args) {
//        QuanLyPet quanLyPet = new QuanLyPet();
//        Pet pet1 = new Cho("kiki");
//        quanLyPet.themPet(pet1);
//        Pet pet2 = new Cho("huiui");
//        quanLyPet.themPet(pet2);
//        quanLyPet.inTTPetS();
//
//        System.out.println("===============");
//        QuanLyHocSinh quanLyHocSinh = new QuanLyHocSinh();
//        quanLyHocSinh.themHocSinh(new HocSinh("Nam", 20));
//        quanLyHocSinh.themHocSinh(new HocSinh("Ha", 22));
//        quanLyHocSinh.inTTHSS();

//
//        QuanLyChung<Pet> quanLyChung = new QuanLyChung<>();
//        quanLyChung.addObject(new Cho("hihi"));
//        quanLyChung.addObject(new Cho("hihi"));
//        quanLyChung.addObject(new Cho("sdfsdf"));
//        quanLyChung.addObject(new Cho("sdfsdf"));
//        quanLyChung.addObject(new Cho("sdfsdf"));
//
//
//        Pet pet = quanLyChung.getObject(0);
//        pet.choi();
//
//
//
//
//
//
//
//
//
//
//        QuanLyChung<HocSinh> quanLyChungHs = new QuanLyChung<>();
//
//        quanLyChungHs.addObject();


//        try {
//            String strNumber = "0";
//            int number = Integer.valueOf(strNumber);
//            int other = 1;
//            int result = other/number;
//            System.out.println("Number: " + number);
//
//
//        }catch (NumberFormatException e){
//            JOptionPane.showMessageDialog(null, "Khong phai la so");
//        }catch (ArithmeticException e) {
//            JOptionPane.showMessageDialog(null, "by zero");
//        }
        try {
            chia(1, 0);
        }catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "by zero");
        }



    }

    public static int chia(int a, int b) throws ArithmeticException {
        return a / b;
    }


}
