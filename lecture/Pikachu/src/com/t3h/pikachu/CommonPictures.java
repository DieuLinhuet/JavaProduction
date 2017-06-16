package com.t3h.pikachu;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 25/04/2017.
 */
public class CommonPictures {
    public static int SQUEAR_FIRST_ID = 0;
    public static int SQUEAR_SCOND_ID = 1;
    public static int SQUEAR_THIRD_ID = 2;
    public static final Image[] BG_PI = new Image[]{
            new ImageIcon(CommonPictures.class.getResource("/images/square_1.png")).getImage(),
            new ImageIcon(CommonPictures.class.getResource("/images/squarec_2.png")).getImage(),
            new ImageIcon(CommonPictures.class.getResource("/images/square_3.png")).getImage()
    };
}
