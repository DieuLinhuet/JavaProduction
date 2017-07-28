package com.t3h.daovang.models;

import java.awt.*;

/**
 * Created by dieulinh on 6/16/17.
 */
public class ItemMap extends Object2D{
    private String imgId;

    public ItemMap(){}

    ItemMap(int x, int y, Image image, int sizeImg, String imgId) {
        super(x, y, image, sizeImg);
        this.imgId = imgId;
    }

    public ItemMap(String imgId) {
        this.imgId = imgId;
    }

    String getImgId() {
        return imgId;
    }
}
