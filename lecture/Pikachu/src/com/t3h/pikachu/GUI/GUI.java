package com.t3h.pikachu.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * Created by Admin on 25/04/2017.
 */
public class GUI extends JFrame {
    private Image bgGame;
    public GUI(){
        initFrame();
        initComponents();
    }

    private void initFrame() {
        setTitle("Pikachu");
        setSize(Constants.WIDTH_FRAMET, Constants.HEIGHT_FRAMET);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void initComponents(){
        try {
            Random rd = new Random();
            int indexBg = rd.nextInt(12)+1;
            InputStream inImage = getClass().getResource("/images/bg"+indexBg+".png").openStream();
            BufferedImage buff = ImageIO.read(inImage);
            bgGame = buff.getScaledInstance(Constants.WIDTH_FRAMET, Constants.HEIGHT_FRAMET,
                    Image.SCALE_SMOOTH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        ControlPanel controlPanel = new ControlPanel(bgGame);
        add(controlPanel);

        PlayPanel playPanel = new PlayPanel(bgGame);
        add(playPanel);
    }
}
