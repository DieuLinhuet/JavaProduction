package com.t3h.tank90.gui;

import com.t3h.tank90.common.Constants;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ducnd on 12/04/2017.
 */
public class PanelMenu extends JPanel implements ActionListener {
    private JButton btnPlay;
    private JButton btnHightScore;
    private  GUI gui;

    public PanelMenu(GUI gui){
        setSize(Constants.WIDTH_MAIN_FRAME,
                Constants.HEIGHT_MAIN_FRAME);
        setLayout(null);
        setBackground(Color.BLUE);
        inits();
        this.gui = gui;
    }

    private void inits(){
        btnPlay = new JButton();
        btnPlay.setLocation(300, 100);
        btnPlay.setSize(100, 30);
        btnPlay.setText("Play");
        add(btnPlay);
        btnPlay.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //vao day
        gui.addPanelPlay();
    }


}
