package com.t3h;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ducnd on 19/04/2017.
 */
public class PanelGame extends JPanel implements KeyListener, Runnable {
    private GameManager gameManager;
    private boolean isLeft;
    private boolean isRight;
    private boolean isSpace;
    private Thread thread;

    public PanelGame() {
        setSize(Constants.WIDTH_FRAME, Constants.HEIGHT_FRAME);
        setBackground(Color.BLACK);
        gameManager = new GameManager();
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
        g2d.setColor(Color.WHITE);
        gameManager.drawAll(g2d);
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
            case KeyEvent.VK_RIGHT:
                isRight = true;
                break;
            case KeyEvent.VK_SPACE:
                isSpace = true;
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
            case KeyEvent.VK_RIGHT:
                isRight = false;
                break;
            case KeyEvent.VK_SPACE:
                isSpace = false;
                break;
            default:
                break;
        }
    }
    private long time = 0;
    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ( isLeft ) {
                gameManager.moveLineX(-1);
            }else {
                if ( isRight ) {
                    gameManager.moveLineX(1);
                }
            }
            time++;
            if ( isSpace ) {
                gameManager.fire(time);
            }
            repaint();
        }
    }
}
