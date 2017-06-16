package com.t3h.pikachu.GUI;

import com.t3h.pikachu.CommonPictures;

import java.awt.*;

/**
 * Created by Admin on 25/04/2017.
 */
public class Pikachu {
    private int bgID;
    private Image imgPi;
    private int x,  y;
    private int size;
    private int piID;

    public Pikachu(int piID, int bgID, Image imgPi, int x, int y, int size) {
        this.piID = piID;
        this.bgID = bgID;
        this.imgPi = imgPi;
        this.x = x;
        this.y = y;
        this.size = size;
    }

    public void draw(Graphics2D g2d) {
        g2d.drawImage(CommonPictures.BG_PI[bgID],
                x, y, size, size, null);
        g2d.drawImage(imgPi,
                x, y, size, size, null);
    }

    public void setBgID(int bgID) {
        this.bgID = bgID;
    }
}
