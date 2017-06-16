package com.t3h.daovang.models;

import java.awt.*;

/**
 * Created by dieulinh on 6/16/17.
 */
public class Object2D {
    protected int sizeImg;
    protected int x;
    protected int y;
    protected Image image;

    public Object2D(){}

    public Object2D(int x, int y, Image image, int sizeImg) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.sizeImg = sizeImg;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(image, x, y, sizeImg, sizeImg, null);
    }

    Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(x, y, sizeImg, sizeImg);
        return rectangle;
    }

}
