package com.t3h.tank90.gui.obj;

import com.t3h.tank90.common.Constants;
import com.t3h.tank90.gui.PicturesGame;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;


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
        if (time % sleep != 0) {
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


    public List<ItemMap> interactList(ItemMap itemMaps[][]) {
        switch (orientation) {
            case LEFT:
                return interactLeft(itemMaps);
            case UP:
                return interactUp(itemMaps);
            case RIGHT:
                return interactRight(itemMaps);
            default:
                return interactDown(itemMaps);
        }
    }

    private List<ItemMap> interactLeft(ItemMap itemMaps[][]) {
        int min = y / Constants.SIZE_ITEM_GAME;
        int max = (y + size) / Constants.SIZE_ITEM_GAME;
        int column = x / Constants.SIZE_ITEM_GAME;
        List<ItemMap> maps = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (itemMaps[i][column] != null) {
                maps.add(itemMaps[i][column]);
            }
        }
        return maps;
    }

    private List<ItemMap> interactUp(ItemMap itemMaps[][]) {
        int min = x / Constants.SIZE_ITEM_GAME;
        int max = (x + size) / Constants.SIZE_ITEM_GAME;
        int row = y / Constants.SIZE_ITEM_GAME;
        List<ItemMap> maps = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (itemMaps[row][i] != null) {
                maps.add(itemMaps[row][i]);
            }
        }
        return maps;
    }

    private List<ItemMap> interactRight(ItemMap itemMaps[][]) {
        int min = y / Constants.SIZE_ITEM_GAME;
        int max = (y + size) / Constants.SIZE_ITEM_GAME;
        int column = (x + size) / Constants.SIZE_ITEM_GAME;
        List<ItemMap> maps = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (itemMaps[i][column] != null) {
                maps.add(itemMaps[i][column]);
            }
        }
        return maps;
    }

    private List<ItemMap> interactDown(ItemMap itemMaps[][]) {
        int min = x / Constants.SIZE_ITEM_GAME;
        int max = (x + size) / Constants.SIZE_ITEM_GAME;
        int row = (y + size) / Constants.SIZE_ITEM_GAME;
        List<ItemMap> maps = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (itemMaps[row][i] != null) {
                maps.add(itemMaps[row][i]);
            }
        }
        return maps;
    }

}
