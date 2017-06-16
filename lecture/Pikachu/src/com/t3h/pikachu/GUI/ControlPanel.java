package com.t3h.pikachu.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Admin on 25/04/2017.
 */
public class ControlPanel extends JPanel {
    private Image imgBg;
    public ControlPanel(Image imgBg) {
        this.imgBg = imgBg;
        setLocation(0, 0);
        setLayout(null);
        setSize(Constants.WIDTH_FRAMET
        , Constants.HEIGHT_CONTROL_PANEL);
    }

    @Override
    protected void paintComponent(Graphics g) {

        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(imgBg,
                0, 0, Constants.WIDTH_FRAMET, Constants.HEIGHT_CONTROL_PANEL,
                0, 0, Constants.WIDTH_FRAMET, Constants.HEIGHT_CONTROL_PANEL,
                null);

    }
}
