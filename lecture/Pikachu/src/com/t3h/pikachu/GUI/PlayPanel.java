package com.t3h.pikachu.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by Admin on 25/04/2017.
 */
public class PlayPanel extends JPanel implements MouseListener, MouseMotionListener {
    private Image imgBg;
    private ManagerPlay managerPlay;
    public PlayPanel(Image imgBg) {
        this.imgBg = imgBg;
        setLayout(null);
        setSize(Constants.WIDTH_FRAMET, Constants.HEIGHT_PLAY_PANEL);
        setLocation(0, Constants.HEIGHT_CONTROL_PANEL);

        managerPlay = new ManagerPlay();

        addMouseMotionListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(imgBg,
                0, 0, Constants.WIDTH_FRAMET, Constants.HEIGHT_PLAY_PANEL,
                0, Constants.HEIGHT_CONTROL_PANEL, Constants.WIDTH_FRAMET, Constants.HEIGHT_FRAMET,
                null);

        managerPlay.drawAll(g2d);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int xMouse = e.getX();
        int yMouse = e.getY();
        boolean isUpdate = managerPlay.moveMouse(xMouse, yMouse);
        if ( isUpdate ) {
            repaint();
        }
    }
}
