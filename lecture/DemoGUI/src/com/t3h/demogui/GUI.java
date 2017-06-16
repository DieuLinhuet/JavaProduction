package com.t3h.demogui;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by ducnd on 20/03/2017.
 */
public class GUI extends JFrame {
    private MyPanel myPanel;
    private Panel2 panel2;
    public GUI (){
        initFrame();

        //
        //null: free giay ve nhu the nao ( kich thuoc) thi hien thi nhu the
        //CardLayout: gian vao thi hien thi full
        //cau len nay phai dat truoc cau lenh add
        setLayout(null);
        myPanel = new MyPanel();
        //gian giay vao khung(JFrame)
        add(myPanel);

        panel2 = new Panel2();
        add(panel2);
    }

    private void initFrame() {
        //thiet lap chieu rong va chieu cao
        //par1: width
        //par2: height
        setSize(500, 500);
        setTitle("Demo GUI");
        //true: co the thay doi kich thuoc
        //flase: khong the thay doi kich thuoc
        setResizable(false);
//        setLocation(100, 100);
        setLocationRelativeTo(null);
        int heightScreen = (int)getToolkit().getScreenSize().getHeight();
        int widthScreen = (int)getToolkit().getScreenSize().getWidth();

        int positionX = (widthScreen-500)/2;
        int positionY = (heightScreen-500)/2;
        setLocation(positionX, positionY);
//        System.exit(0);

        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);


        WindowListener listener = new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
               int result = JOptionPane.showConfirmDialog(GUI.this,
                       "Do you want exit?", "Confirm",
                       JOptionPane.YES_NO_OPTION);
               if ( result == JOptionPane.OK_OPTION ) {
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
        };

        addWindowListener(listener);
    }
}
