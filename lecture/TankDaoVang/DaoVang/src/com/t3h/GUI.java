package com.t3h;

import javax.swing.*;

/**
 * Created by ducnd on 19/04/2017.
 */
public class GUI extends JFrame {
    private PanelGame panelGame;

    public GUI() {
        init();
        panelGame = new PanelGame();
        panelGame.setLocation(0, 0);
        add(panelGame);
    }

    private void init() {
        setTitle("Dao vang");
        setSize(Constants.WIDTH_FRAME, Constants.HEIGHT_FRAME);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
    }
}
