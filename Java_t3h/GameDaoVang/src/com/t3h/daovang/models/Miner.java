package com.t3h.daovang.models;

import com.t3h.daovang.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dieulinh on 6/16/17.
 */
public class Miner extends Object2D {
    static final Image[] images0 = new Image[]{
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner00.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner01.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner02.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner03.png")).getImage()
    };

    static final Image[] images1 = new Image[]{
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner10.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner11.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner12.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner13.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner14.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner15.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner16.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner17.png")).getImage()
    };

    public static final Image[] images2 = new Image[]{
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner20.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner21.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner22.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner23.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner24.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner25.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner26.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner27.png")).getImage()
    };

    public static final Image[] images3 = new Image[]{
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner30.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner31.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner32.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner33.png")).getImage()
    };

    public static final Image[] images4 = new Image[]{
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner40.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner41.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner42.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/com/t3h/daovang/res/images/miner43.png")).getImage()
    };


    Miner() {
        image = images0[0];
        sizeImg = Constant.SIZE_ITEM*6;
        x = Constant.SIZE_ITEM * 29;
        y = Constant.SIZE_ITEM * 2;
    }
}
