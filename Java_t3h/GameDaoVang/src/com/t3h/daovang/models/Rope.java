package com.t3h.daovang.models;

import java.awt.*;

/**
 * Created by dieulinh on 6/16/17.
 */
public class Rope {
    private int x0, y0;
    private int x1, y1;

    public Rope(int x0, int y0, int x1, int y1){
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    public void draw(Graphics2D g2d){
        g2d.drawLine(x0, y0, x1, y1);
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }
}
