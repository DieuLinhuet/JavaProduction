package com.t3h.demoarraylist;

import com.t3h.demoarraylist.ob.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducnd on 08/03/2017.
 */
public class QuanLyPet {
    private List<Pet> pets;

    public QuanLyPet() {
        pets = new ArrayList<>();
    }

    public void themPet(Pet pet) {
        pets.add(pet);
    }

    public void xoa(int index) {
        pets.remove(index);
    }

    public void inTTPetS(){
        for ( int i = 0; i < pets.size(); i++ ) {
            pets.get(i).choi();
        }
    }
}
