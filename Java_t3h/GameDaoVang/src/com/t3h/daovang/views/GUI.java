package com.t3h.daovang.views;

import com.t3h.daovang.Constant;

import javax.swing.*;
import java.awt.*;

import static com.t3h.daovang.Constant.WIDTH_FRAME;

/**
 * Created by dieulinh on 6/16/17.
 */
public class GUI extends JFrame implements Constant{

    public GUI(){
        initFrame();
        MainGamePanel gamePanel = new MainGamePanel();
        add(gamePanel);

    }

    private void initFrame() {
        setTitle("Dao Vang");
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setLayout(new CardLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
