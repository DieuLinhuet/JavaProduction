package com.t3h;

import javax.swing.*;
import java.awt.*;

/**
 * Created by ducnd on 19/04/2017.
 */
public class GameManager {
    private Line line;
    private Ball ball;

    public GameManager() {
        line = new Line(0, 200,
                Constants.WIDTH_FRAME / 2, Constants.HEIGHT_FRAME);
        Image image = new ImageIcon(getClass()
                .getResource("/image/magic_ball.png")).getImage();
        int size = 20;
        ball = new Ball(Constants.WIDTH_FRAME / 2 - size / 2,
                Constants.HEIGHT_FRAME - size, image, size);
    }

    public void drawAll(Graphics2D g2d) {
        line.draw(g2d);
        ball.draw(g2d);

    }

    public void moveLineX(int detal) {
        line.moveX(detal);
    }

    public void fire(long time) {
        if (time % 3 != 0) {
            return;
        }
        float tag = (float) (line.getY2() - line.getY1()) /
                (line.getX2() - line.getX1());

        int xBall;
        if (tag > 0) {
            xBall = ball.getX() - 1;
            float b = tag * (line.getX2() - xBall);
            int yBall = (int) (Constants.HEIGHT_FRAME - b);
            ball.setX(xBall);
            ball.setY(yBall);
        } else {
            xBall = ball.getX() + 1;
            float temXball = xBall + ball.getSize() / 2;
            temXball = (temXball - Constants.WIDTH_FRAME / 2) * tag*-1;
            ball.setX(xBall);
            ball.setY(Constants.HEIGHT_FRAME-(int)temXball);


        }


    }
}
