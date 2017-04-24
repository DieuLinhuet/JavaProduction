package daovanggame_v1.views;

import daovanggame_v1.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DieuLinh on 20-Apr-17.
 */
public class GUI extends JFrame implements Constant {
    private MainGamePanel gamePanel;

    public GUI(){
        initFrame();
        gamePanel = new MainGamePanel();
        add(gamePanel);

    }

    private void initFrame() {
        setTitle("Dao Vang");
        setSize(WIDTH_FRAME, HEIGHT_FRAME);
        setLayout(new CardLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
