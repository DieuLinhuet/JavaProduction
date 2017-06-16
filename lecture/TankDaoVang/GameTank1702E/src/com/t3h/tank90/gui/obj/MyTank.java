package com.t3h.tank90.gui.obj;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ducnd on 10/04/2017.
 */
public class MyTank extends Tank {
    public static final Image IMG_MY_TANK[] = new Image[]{
            new ImageIcon(MyTank.class.
                    getResource("/pictures/player_green_left.png")).getImage(),
            new ImageIcon(MyTank.class.
                    getResource("/pictures/player_green_up.png")).getImage(),
            new ImageIcon(MyTank.class.
                    getResource("/pictures/player_green_right.png")).getImage(),
            new ImageIcon(MyTank.class.
                    getResource("/pictures/player_green_down.png")).getImage()
    };
    public MyTank(Image img, int x, int y, int size, int speed, int orientation) {
        super(img, x, y, size, speed, orientation);
    }

    public void changeOrientation(int orientation) {
        img = IMG_MY_TANK[orientation];
        this.orientation = orientation;
    }
}
