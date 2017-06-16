package com.t3h.demoarraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ducnd on 08/03/2017.
 */
public class QuanLyChung<T> {
    private List<T> list;

    public QuanLyChung(){
        list = new ArrayList<>();
    }

    public void addObject(T t ){
        list.add(t);
    }

    public T getObject(int index){
        return list.get(index);
    }
}
