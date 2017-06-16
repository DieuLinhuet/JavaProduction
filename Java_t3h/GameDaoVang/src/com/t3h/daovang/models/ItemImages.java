package com.t3h.daovang.models;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dieulinh on 6/16/17.
 */
public class ItemImages {
    public static final Image GOLD0 = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold0.png")).getImage();
    public static final Image GOLD1 = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold1.png")).getImage();
    public static final Image GOLD2 = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold2.png")).getImage();
    public static final Image GOLD3 = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold3.png")).getImage();

    public static final Image GOLD0X = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold0x.png")).getImage();
    public static final Image GOLD1X = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold1x.png")).getImage();
    public static final Image GOLD2X = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold2x.png")).getImage();
    public static final Image GOLD3X = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/gold3x.png")).getImage();

    public static final Image STONE0 = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/stone0.png")).getImage();
    public static final Image STONE1 = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/stone1.png")).getImage();

    public static final Image STONE0X = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/stone0x.png")).getImage();
    public static final Image STONE1X = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/stone1x.png")).getImage();

    public static final Image BAG = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/bag.png")).getImage();
    public static final Image BAGX = new ImageIcon(ItemImages.class.
            getResource("/com/t3h/daovang/res/images/bagx.png")).getImage();

    public static final String GOLD_ID0 = "10";
    public static final String GOLD_ID1 = "11";
    public static final String GOLD_ID2 = "12";
    public static final String GOLD_ID3 = "13";

    public static final String STONE_ID0 = "20";
    public static final String STONE_ID1 = "21";

    public static final String BAG_ID = "30";

    public static final String GOLD_IDOX = "10x";
    public static final String GOLD_ID1X = "11x";
    public static final String GOLD_ID2X = "12x";
    public static final String GOLD_ID3X = "13x";

    public static final String STONE_ID0X = "20x";
    public static final String STONE_ID1X = "21x";

    public static final String BAG_IDX = "30x";


    public static Image getImage(String id) {
        switch (id) {
            case GOLD_ID0:
                return GOLD0;
            case GOLD_ID1:
                return GOLD1;
            case GOLD_ID2:
                return GOLD2;
            case GOLD_ID3:
                return GOLD3;
            case STONE_ID0:
                return STONE0;
            case STONE_ID1:
                return STONE1;
            case BAG_ID:
                return BAG;
            case GOLD_IDOX:
                return GOLD0X;
            case GOLD_ID1X:
                return GOLD1X;
            case GOLD_ID2X:
                return GOLD2X;
            case GOLD_ID3X:
                return GOLD3X;
            case STONE_ID0X:
                return STONE0X;
            case STONE_ID1X:
                return STONE1X;
            case BAG_IDX:
                return BAGX;
            default:
                return null;
        }
    }
}
