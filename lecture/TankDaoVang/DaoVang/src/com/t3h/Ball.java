package com.t3h;

import java.awt.*;

/**
 * Created by ducnd on 19/04/2017.
 */
public class Ball {

    private int x;
    private int y;
    private Image img;
    private int size;

    public Ball(int x, int y, Image img, int size) {
        this.x = x;
        this.y = y;
        this.img = img;
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(img, x, y, size, size, null);
    }
}
