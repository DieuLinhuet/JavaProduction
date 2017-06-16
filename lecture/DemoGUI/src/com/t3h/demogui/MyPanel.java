package com.t3h.demogui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ducnd on 20/03/2017.
 */
public class MyPanel extends JPanel implements KeyListener {
    public MyPanel(){
        setSize(300, 300);
        setBackground(Color.PINK);
        setLocation(0, 0);
        addKeyListener(this);
        setFocusable(true);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed : MyPanel");
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
