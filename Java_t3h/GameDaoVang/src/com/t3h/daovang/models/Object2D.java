package com.t3h.daovang.models;

import java.awt.*;

/**
 * Created by dieulinh on 6/16/17.
 */
public class Object2D {
    int sizeImg;
    int x;
    int y;
    Image image;

    Object2D(){}

    Object2D(int x, int y, Image image, int sizeImg) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.sizeImg = sizeImg;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(image, x, y, sizeImg, sizeImg, null);
    }

    Rectangle getRectangle() {
        return new Rectangle(x, y, sizeImg, sizeImg);
    }

}
