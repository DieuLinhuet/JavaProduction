package gui;

import javax.swing.*;

/**
 * Created by ducnd on 29/03/2017.
 */
public class GUI extends JFrame {
    private MyContainer myContainer;
    private PanelMoveBird panelMoveBird;
    public GUI() {
        inits();
//        myContainer = new MyContainer();
//        add(myContainer);

        panelMoveBird = new PanelMoveBird();
        add(panelMoveBird);
    }

    private void inits() {
        setTitle("Thread");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
    }
}
