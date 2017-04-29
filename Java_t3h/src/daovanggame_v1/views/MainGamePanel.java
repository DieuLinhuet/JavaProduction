package daovanggame_v1.views;

import daovanggame_v1.Constant;
import daovanggame_v1.model.ManagerGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by DieuLinh on 20-Apr-17.
 */
public class MainGamePanel extends JPanel implements Runnable, KeyListener {
    Thread thread;
    private ManagerGame manager;

    MainGamePanel(){
        setBackground(Color.ORANGE);
        manager = new ManagerGame();

        addKeyListener(this);
        setFocusable(true);

        thread = new Thread(this);
        thread.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        //xu ly but ve
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        drawString(g2d);
        manager.drawAll(g2d);
    }

    private void drawString(Graphics2D g2d) {
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("TimeNewRoman", Font.BOLD, 20));
        g2d.drawString("Money: $" + manager.getScore(), 20, 50);
        g2d.drawString("Gold: $650", 20, 80);
        g2d.setFont(new Font("TimeNewRoman", Font.BOLD, 18));
        g2d.setColor(Color.BLACK);
        if (manager.getMinute() < 10 && manager.getSecond() < 10){
            g2d.drawString("Time: 0" + manager.getMinute() + " : 0" + manager.getSecond(),
                    Constant.WIDTH_FRAME - 180, 52);
        }else if (manager.getMinute() < 10) {
            g2d.drawString("Time: 0" + manager.getMinute() + " : " + manager.getSecond(), Constant.WIDTH_FRAME - 180, 52);
        }else if (manager.getSecond() < 10){
            g2d.drawString("Time: " + manager.getMinute() + " : 0" + manager.getSecond(), Constant.WIDTH_FRAME - 180, 52);
        }
        else {
            g2d.drawString("Time: " + manager.getMinute() + " : " + manager.getSecond(),
                    Constant.WIDTH_FRAME - 180, 52);
        }

        g2d.drawLine(0, Constant.SIZE_ITEM*9, Constant.WIDTH_FRAME, Constant.SIZE_ITEM*9);
    }

    private boolean isDown;

    private long time = 0;
    @Override
    public void run() {
        while (manager.isRunning()){
            time++;
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            manager.initGame(time);
            if (isDown){
                manager.releaseHook(time);
                if (manager.getHook().isFinish()){
                    isDown = false;
                }
            }
            repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_DOWN){
            isDown = true;
            manager.getHook().setRelease(true);
            manager.getHook().setFinish(false);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
