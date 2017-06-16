package com.t3h.tank90.gui.obj;

import java.awt.*;

/**
 * Created by ducnd on 05/04/2017.
 */
public class ItemMap extends Obj2D {
    private int imgID;
    public ItemMap(Image img, int x, int y, int size, int imgID) {
        super(img, x, y, size);
        this.imgID = imgID;
    }


    public int getID() {
        return imgID;
    }
}
