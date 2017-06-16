package com.t3h.demogui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Created by ducnd on 20/03/2017.
 */
public class Panel2 extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    public Panel2() {
        setSize(500, 300);
        setBackground(Color.BLUE);
        setLocation(0, 300);
        initClick();
        setFocusable(true);
    }

    private void initClick() {
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mouseClicked.....");
        System.out.println("x panel: " + e.getX());
        System.out.println("y panel: " + e.getY());
        System.out.println("x screen: " + e.getXOnScreen());
        System.out.println("y screen: " + e.getYOnScreen());
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
        System.out.println("move x: " + e.getX());
        System.out.println("move y: " + e.getY());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed Panel2");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
