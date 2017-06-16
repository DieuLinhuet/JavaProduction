package com.t3h.pikachu.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * Created by Admin on 25/04/2017.
 */
public class ManagerPlay {
    private Pikachu pikachus[][];
    private int sizePi;
    private int oldColumn = -1, oldRow = -1;
    public ManagerPlay() {
        initPis();
    }

    private void initPis(){
        pikachus = new Pikachu[Constants.NUMBER_PI_ROW][Constants.NUMBER_PI_COLUMN];
        sizePi = (Constants.WIDTH_FRAMET-Constants.PADDING_LEFT * 2)/Constants.NUMBER_PI_COLUMN;
        Random rd = new Random();
        java.util.List<Integer> piIDs = new ArrayList<>();
        for ( int i = 0; i< Constants.NUMBER_PI_ROW/2; i++ ) {
            for (int j = 0; j < Constants.NUMBER_PI_COLUMN; j++ ) {
                int indexPi = rd.nextInt(48) + 1;
                piIDs.add(indexPi);
                Image imgPiImage =
                        new ImageIcon(getClass().getResource("/images/p_" + indexPi + "_cap1.png")).getImage();
                Pikachu pikachu = new Pikachu(indexPi, 0, imgPiImage,
                        Constants.PADDING_LEFT + j* sizePi, Constants.PADDING_TOP + i * sizePi, sizePi);
                pikachus[i][j] = pikachu;
            }
        }

        Collections.shuffle(piIDs);
        int index = 0;
        for ( int i = Constants.NUMBER_PI_ROW/2; i < Constants.NUMBER_PI_ROW; i++ ) {
            for (int j = 0; j < Constants.NUMBER_PI_COLUMN; j++ ) {
//                int indexRD = rd.nextInt(piIDs.size());
                int piID = piIDs.get(index);
                Image imgPiImage =
                        new ImageIcon(getClass().getResource("/images/p_" + piID + "_cap1.png")).getImage();
                Pikachu pikachu = new Pikachu(piID, 0, imgPiImage,
                        Constants.PADDING_LEFT + j* sizePi, Constants.PADDING_TOP + i * sizePi, sizePi);
                pikachus[i][j] = pikachu;

                index++;
            }
        }
    }


    public void drawAll(Graphics2D g2d) {
        for ( int i = 0; i < Constants.NUMBER_PI_ROW; i++ ) {
            for ( int j = 0; j < Constants.NUMBER_PI_COLUMN; j++ ) {
                pikachus[i][j].draw(g2d);
            }
        }
    }

    public boolean moveMouse(int xMouse, int yMouse) {
        int i = (yMouse - Constants.PADDING_TOP)/sizePi;
        int j = (xMouse-Constants.PADDING_LEFT)/sizePi;
        if ( i < 0 || i >= Constants.NUMBER_PI_ROW ||
                j < 0 || j >= Constants.NUMBER_PI_COLUMN ) {
            return false;
        }
        if ( oldColumn != -1 && oldRow != -1 ) {
            pikachus[oldRow][oldColumn].setBgID(0);
        }
        pikachus[i][j].setBgID(1);
        oldRow = i;
        oldColumn= j;
        return true;
    }
}
