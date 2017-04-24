package daovanggame_v1.model;

import daovanggame_v1.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DieuLinh on 21-Apr-17.
 */
public class Miner extends Object2D {
    public static final Image[] images0 = new Image[]{
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner00.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner01.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner02.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner03.png")).getImage()
    };

    public static final Image[] images1 = new Image[]{
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner10.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner11.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner12.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner13.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner14.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner15.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner16.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner17.png")).getImage()
    };

    public static final Image[] images2 = new Image[]{
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner20.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner21.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner22.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner23.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner24.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner25.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner26.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner27.png")).getImage()
    };

    public static final Image[] images3 = new Image[]{
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner30.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner31.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner32.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner33.png")).getImage()
    };

    public static final Image[] images4 = new Image[]{
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner40.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner41.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner42.png")).getImage(),
            new ImageIcon(Miner.class.getResource("/daovanggame_v1/res/images/miner43.png")).getImage()
    };


    public Miner() {
        image = images0[0];
        sizeImg = Constant.SIZE_ITEM*6;
        x = Constant.SIZE_ITEM * 29;
        y = Constant.SIZE_ITEM * 2;
    }

}
