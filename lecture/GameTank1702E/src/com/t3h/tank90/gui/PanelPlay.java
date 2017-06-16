package com.t3h.tank90.gui;

import com.t3h.tank90.common.Constants;
import com.t3h.tank90.gui.obj.MyTank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ducnd on 05/04/2017.
 */
public class PanelPlay extends JPanel implements
        Constants, KeyListener, Runnable {
    private MrgPlayGame mrgPlayGame;
    private Thread thread;
    private boolean isLeft;
    private boolean isUp;
    private boolean isRight;
    private boolean isDown;
    private boolean isFire;

    public PanelPlay() {
        setSize(WIDTH_MAIN_FRAME, HEIGHT_MAIN_FRAME);
        setBackground(Color.BLACK);
        mrgPlayGame = new MrgPlayGame();
        addKeyListener(this);
        setFocusable(true);
        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        mrgPlayGame.drawAll(g2d);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                isLeft = true;
                break;
            case KeyEvent.VK_UP:
                isUp = true;
                break;
            case KeyEvent.VK_RIGHT:
                isRight = true;
                break;
            case KeyEvent.VK_DOWN:
                isDown = true;
                break;
            case KeyEvent.VK_SPACE:
                isFire = true;
                break;
            default:
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                isLeft = false;
                break;
            case KeyEvent.VK_UP:
                isUp = false;
                break;
            case KeyEvent.VK_RIGHT:
                isRight = false;
                break;
            case KeyEvent.VK_DOWN:
                isDown = false;
                break;
            case KeyEvent.VK_SPACE:
                isFire = false;
                break;
            default:
                break;
        }
    }

    private long time = 0;
    @Override
    public void run() {
        while (true) {
            time++;
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            moveMyTank();
            if ( isFire ) {
                mrgPlayGame.fireBulletMyTank(time);
            }
            mrgPlayGame.moveAllBulletMyTank(time);
            repaint();
        }
    }

    private void moveMyTank() {
        if (isLeft) {
            mrgPlayGame.moveMyTank(MyTank.LEFT, time);
        } else {
            if (isUp) {
                mrgPlayGame.moveMyTank(MyTank.UP, time);
            } else {
                if (isRight) {
                    mrgPlayGame.moveMyTank(MyTank.RIGHT, time);
                } else {
                    if (isDown) {
                        mrgPlayGame.moveMyTank(MyTank.DOWN, time);
                    }
                }
            }

        }
    }
}
