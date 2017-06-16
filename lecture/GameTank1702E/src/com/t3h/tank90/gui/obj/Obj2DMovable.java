package com.t3h.tank90.gui.obj;

import com.t3h.tank90.common.Constants;
import com.t3h.tank90.gui.PicturesGame;

import java.awt.*;

/**
 * Created by ducnd on 05/04/2017.
 */
public class Obj2DMovable extends Obj2D {
    public static final int LEFT = 0;
    public static final int UP = 1;
    public static final int RIGHT = 2;
    public static final int DOWN = 3;

    protected int sleep;
    protected int orientation;

    public Obj2DMovable(Image img, int x, int y, int size,
                        int speed, int orientation) {
        super(img, x, y, size);
        this.sleep = speed;
        this.orientation = orientation;
    }

    public void move(long time) {
        if ( time % sleep != 0 ) {
            return;
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
    }

    public int getSleep() {
        return sleep;
    }

    protected Point interact(ItemMap itemMaps[][]) {
        switch (orientation) {
            case LEFT:
                int i = x / Constants.SIZE_ITEM_GAME;
                int j = y / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                j = (y + size) / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                return null;
            case UP:
                i = x / Constants.SIZE_ITEM_GAME;
                j = y / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                i = (x + size) / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                return null;
            case RIGHT:
                i = (x + size) / Constants.SIZE_ITEM_GAME;
                j = y / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                j = (y + size) / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                return null;
            default:
                i = x / Constants.SIZE_ITEM_GAME;
                j = (y + size) / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                i = (x + size) / Constants.SIZE_ITEM_GAME;
                if (itemMaps[j][i] != null && itemMaps[j][i].getID()
                        != PicturesGame.TREE_ID) {
                    return new Point(j, i);
                }
                return null;
        }
    }
}
