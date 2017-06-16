package com.t3h.tank90.gui;

import com.t3h.tank90.common.Constants;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ducnd on 05/04/2017.
 */
public class GUI extends JFrame implements Constants {
    private PanelPlay panelPlay;
    private PanelMenu panelMenu;

    public GUI() {
        initGUI();
        initComponents();

    }

    private void initGUI() {
        setTitle("Tank90");
//        Dimension scrnSize = Toolkit.getDefaultToolkit()
//                .getScreenSize();
//        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment()
//                .getMaximumWindowBounds();
//
//        int taskBarHeight = scrnSize.height - winSize.height;
        setSize(WIDTH_MAIN_FRAME,
                HEIGHT_MAIN_FRAME);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void initComponents() {
        panelPlay = new PanelPlay();
        add(panelPlay);
//        panelMenu = new PanelMenu(this);
//        add(panelMenu);
    }

    public void addPanelPlay(){
        remove(panelMenu);
        panelPlay = new PanelPlay();
        add(panelPlay);
        panelPlay.requestFocus();
        repaint();
    }
}
