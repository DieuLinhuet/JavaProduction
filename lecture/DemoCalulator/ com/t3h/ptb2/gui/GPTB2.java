package com.t3h.ptb2.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by ducnd on 22/03/2017.
 */
public class GPTB2 extends JPanel implements Constants, ActionListener {
    private JLabel lbTitle, lbHSA, lbHSB, lbHSC;
    private JTextField tfA, tfB, tfC;
    private JButton btnGiai;

    public GPTB2() {
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setLayout(null);
        setBackground(Color.GREEN);
        initComponents();
        addComponents();


    }

    private void initComponents() {
        lbTitle = new JLabel();
        lbTitle.setText(APP_NAME);

        //par1: ten font
        //par2: kieu font
        //par3: size font
        Font font = new Font("Tahoma", Font.BOLD, 50);
        lbTitle.setFont(font);
        lbTitle.setForeground(Color.RED);


        FontMetrics metricsTitle = getFontMetrics(font);
        int widthTitle = metricsTitle.stringWidth(Constants.APP_NAME);
        lbTitle.setLocation((WIDTH_FRAME - widthTitle) / 2, 20);
        lbTitle.setSize(widthTitle, 50);

        Font fonHeSo = new Font("Tahoma", Font.BOLD, 20);
        initHSA(fonHeSo, 100);
        initHSB(fonHeSo, 140);
        initHSC(fonHeSo, 180);
        initBtnGiai(font, 230);

        btnGiai.addActionListener(this);


    }

    private void initHSA(Font font, int y) {
        lbHSA = new JLabel();
        lbHSA.setText("He So a:");
        lbHSA.setFont(font);
        lbHSA.setForeground(Color.WHITE);
        FontMetrics metricsa = getFontMetrics(font);
        int widthA = metricsa.stringWidth("He So a:");
        lbHSA.setLocation(20, y);
        lbHSA.setSize(widthA, 20);

        tfA = new JTextField();
        tfA.setSize(200, 25);
        tfA.setLocation(widthA + 40, y);
    }

    private void initHSB(Font font, int y) {
        lbHSB = new JLabel();
        lbHSB.setText("He So b:");
        lbHSB.setFont(font);
        lbHSB.setForeground(Color.WHITE);
        FontMetrics metricsa = getFontMetrics(font);
        int widthB = metricsa.stringWidth("He So b:");
        lbHSB.setLocation(20, y);
        lbHSB.setSize(widthB, 20);

        tfB = new JTextField();
        tfB.setSize(200, 25);
        tfB.setLocation(widthB + 40, y);
    }

    private void initHSC(Font font, int y) {
        lbHSC = new JLabel();
        lbHSC.setText("He So c:");
        lbHSC.setFont(font);
        lbHSC.setForeground(Color.WHITE);
        FontMetrics metricsa = getFontMetrics(font);
        int widthC = metricsa.stringWidth("He So c:");
        lbHSC.setLocation(20, y);
        lbHSC.setSize(widthC, 20);

        tfC = new JTextField();
        tfC.setSize(200, 25);
        tfC.setLocation(widthC + 40, y);
    }

    private void initBtnGiai(Font font, int y) {
        btnGiai = new JButton();
        btnGiai.setActionCommand("GIAI");
        btnGiai.setText("Giai");
        FontMetrics metrics = getFontMetrics(font);
        int width = metrics.stringWidth("Giai");
        btnGiai.setSize(width + 30, 35);
        btnGiai.setLocation(20, y);
    }

    private void addComponents() {
        add(lbTitle);
        add(lbHSA);
        add(lbHSB);
        add(lbHSC);

        add(tfA);
        add(tfB);
        add(tfC);

        add(btnGiai);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = e.getActionCommand();
        switch (id) {
            case "GIAI":
                ///
                try {
                    String heSoA = tfA.getText();
                    int nA = Integer.valueOf(heSoA);
                }catch (NumberFormatException ed) {
                    JOptionPane
                            .showMessageDialog(this, "Lam on nhap so");
                }

                break;
            default:
                break;
        }
    }
}
