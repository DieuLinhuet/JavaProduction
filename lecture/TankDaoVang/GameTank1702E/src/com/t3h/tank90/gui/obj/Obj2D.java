package com.t3h.tank90.gui.obj;

import java.awt.*;

/**
 * Created by ducnd on 05/04/2017.
 */
public abstract class Obj2D {
    protected Image img;
    protected int x, y;
    protected int size;

    public Obj2D(Image img, int x, int y, int size) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, size, size, null);
    }
}
