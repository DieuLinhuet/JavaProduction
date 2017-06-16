package com.t3h.tank90.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ducnd on 05/04/2017.
 */
public class PicturesGame {
    public static final Image TREE = new ImageIcon(
            PicturesGame.class
                    .getResource("/pictures/tree.png"))
            .getImage();
    public static final Image ROCK = new ImageIcon(
            PicturesGame.class
                    .getResource("/pictures/rock.png"))
            .getImage();
    public static final Image BRICK = new ImageIcon(
            PicturesGame.class
                    .getResource("/pictures/brick.png"))
            .getImage();
    public static final Image WATER = new ImageIcon(
            PicturesGame.class
                    .getResource("/pictures/water.png"))
            .getImage();
    public static final Image HOME = new ImageIcon(
            PicturesGame.class
                    .getResource("/pictures/bird.png"))
            .getImage();
    public static final int TREE_ID = 4;
    public static final int ROCK_ID = 5;
    public static final int BRICK_ID = 1;
    public static final int WATER_ID = 2;
    public static final int HOME_ID = 9;

    public static Image getImage(int id) {
        switch (id) {
            case TREE_ID:
                return TREE;
            case ROCK_ID:
                return ROCK;
            case BRICK_ID:
                return BRICK;
            case WATER_ID:
                return WATER;
            case HOME_ID:
                return HOME;
            default:
                return null;
        }
    }
}
