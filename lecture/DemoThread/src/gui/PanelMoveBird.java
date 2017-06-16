package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by ducnd on 29/03/2017.
 */
public class PanelMoveBird extends JPanel implements
        KeyListener, Runnable {
    private Image bird;
    private Image bg;
    private int xBird;
    private int yBird;
    private Thread thread;
    private int yBomb1;
    private int yBomb2;
    private Image bomb;
    private int sleep1 = 1;
    private int sleep2 = 2;

    volatile private boolean isLeft;
    volatile private boolean isRight;

    public PanelMoveBird() {
        setSize(700, 500);
        bird = new ImageIcon(getClass()
                .getResource("/images/bird.png")).getImage();
        bg = new ImageIcon(getClass()
                .getResource("/images/bg.jpg")).getImage();
        bomb = new ImageIcon(getClass()
                .getResource("/images/bomb.png")).getImage();
        xBird = 10;
        yBird = 10;
        addKeyListener(this);
        setFocusable(true);

        thread = new Thread(this);
        thread.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(bg, 0, 0, 700, 500, null);
        g2d.drawImage(bird, xBird, yBird, null);
        g2d.drawImage(bomb, 100, yBomb1, null);
        g2d.drawImage(bomb, 150, yBomb2, null);
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
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if ( isLeft ) {
                xBird--;
            }else {
                if ( isRight ) {
                    xBird++;
                }
            }
            yBomb1++;
            if ( yBomb1 == 500) {
                yBomb1 = -bomb.getHeight(null);
            }
            if ( time % sleep2 == 0 ) {
                yBomb2++;
                if ( yBomb2 == 500) {
                    yBomb2 = -bomb.getHeight(null);
                }
            }

            repaint();
        }
    }
}
