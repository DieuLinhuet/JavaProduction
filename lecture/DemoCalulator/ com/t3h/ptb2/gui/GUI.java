package com.t3h.ptb2.gui;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by ducnd on 22/03/2017.
 */
public class GUI extends JFrame implements Constants, WindowListener {
    private GPTB2 gptb2;

    public GUI() {
        initFrames();
        initComponents();
        addComponents();
    }

    private void initFrames() {
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setTitle(APP_NAME);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
    }

    private void initComponents(){
        gptb2 = new GPTB2();
    }

    private void addComponents(){
        add(gptb2);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        int result = JOptionPane
                .showConfirmDialog(this,
                        "Ban co muon thoat khong?",
                        "Confirm", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
