package com.t3h.tank90.gui.obj;

import com.t3h.tank90.common.Constants;
import com.t3h.tank90.gui.PicturesGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


/**
 * Created by ducnd on 05/04/2017.
 */
public class Tank extends Obj2DMovable {
    private List<Bullet> bullets;

    public Tank(Image img, int x, int y, int size, int speed, int orientation) {
        super(img, x, y, size, speed, orientation);
        bullets = new Vector<>();
    }

    public void move(ItemMap itemMaps[][]) {
        switch (orientation) {
            case LEFT:
                x--;
                if (interactList(itemMaps).size() > 0  ) {
                    x++;
                }
                break;
            case UP:
                y--;
                if (interactList(itemMaps).size() > 0  ) {
                    y++;
                }
                break;
            case RIGHT:
                x++;
                if (interactList(itemMaps).size() > 0  ) {
                    x--;
                }
                break;
            default:
                y++;
                if (interactList(itemMaps).size() > 0  ) {
                    y--;
                }
                break;

        }
    }



    private long t1;

    public void fire(long t2) {
        if ( t2 - t1 >= 100) {
            t1 = t2;
            Image image = Bullet.IMG_BULLET;
            int sizeD = 10;
            int sleepD = sleep/2;
            int orientationD = orientation;
            int xD;
            int yD;

            switch (orientationD) {
                case LEFT:
                    xD = x - sizeD;
                    yD = y + (size - sizeD) / 2;
                    break;
                case UP:
                    xD = x + (size - sizeD) / 2;
                    yD = y - sizeD;
                    break;
                case RIGHT:
                    xD = x + size;
                    yD = y + (size - sizeD) / 2;
                    break;
                default:
                    xD = x + (size - sizeD) / 2;
                    yD = y + size;
                    break;
            }
            Bullet bullet = new Bullet(image, xD, yD, sizeD, sleepD, orientationD);
            bullets.add(bullet);
        }

    }

    public void drawAllBullet(Graphics2D g2d) {
        for (Bullet bullet : bullets) {
            bullet.draw(g2d);
        }
    }

    public void moveAllBullet(ItemMap itemMaps[][], long time) {
       for ( int i = 0; i < bullets.size(); i++ ) {
           Bullet bullet = bullets.get(i);
           boolean isInract = bullet.move(itemMaps, time);
           if ( isInract ) {
               bullets.remove(i);
               i--;
           }
       }
    }
}
