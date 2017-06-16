package com.t3h.tank90.gui.obj;

import com.t3h.tank90.gui.PicturesGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ducnd on 12/04/2017.
 */
public class Bullet extends Obj2DMovable {
    public static final Image IMG_BULLET =
            new ImageIcon(Bullet.class.
                    getResource("/pictures/bullet.png")).getImage();

    public Bullet(Image img, int x, int y, int size, int speed, int orientation) {
        super(img, x, y, size, speed, orientation);
    }


    public boolean move(ItemMap itemMaps[][], long time) {
        if (time % sleep != 0) {
            return false;
        }
        switch (orientation) {
            case LEFT:
                x--;
                break;
            case UP:
                y--;
                break;
            case RIGHT:
                x++;
                break;

            default:
                y++;
                break;

        }
        return interactBullet(itemMaps);
    }

    private boolean interactBullet(ItemMap[][] itemMaps) {
        Point point = interact(itemMaps);
        if (point != null) {
            if ( itemMaps[point.getFirst()][point.getSecond()].getID() !=
                    PicturesGame.ROCK_ID ) {
                itemMaps[point.getFirst()][point.getSecond()] = null;
            }
            return true;
        }
        return false;
    }


}
