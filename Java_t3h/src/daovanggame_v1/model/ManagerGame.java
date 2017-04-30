package daovanggame_v1.model;

import daovanggame_v1.Constant;
import jdk.internal.util.xml.impl.ReaderUTF8;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by DieuLinh on 21-Apr-17.
 */
public class ManagerGame implements Constant {
    private Miner miner;
    private Hook hook;
    private ItemMap[][] itemMaps;

    private int score;
    private int minute;
    private int second;
    private boolean isRunning = true;
    private boolean isStart = true;
    private int goal;


    public ManagerGame() {
        miner = new Miner();
        itemMaps = new ItemMap[NUM_ROW][NUM_COL];
        initMap();
        initHook();
        score = 0;
        minute = 1;
        second = 30;
    }

    public int getScore() {
        return score;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void initGame(long time){
        if (isStart){
            score = 0;
            minute = 1;
            second = 30;
            goal = 650;
            initMap();
            initHook();
        }
        gameRunning(time);
    }

    public void gameRunning(long time) {
        isStart = false;
        rotateHook();

        if (time % 60 != 0){
            return;
        }
        second--;
        if (minute == 0 && second == -1){
            finishGame(time);
        }
        if (second == -1){
            second = 59;
            minute--;
        }
    }


    private void finishGame(long time) {
        int result;
        isRunning = false;
        if (score >= goal) {
            result = JOptionPane.showConfirmDialog(null, "You have reached the goal! Do you want play again?",
                    "Congratulation", JOptionPane.YES_NO_OPTION);

        } else {
            result = JOptionPane.showConfirmDialog(null, "Game over! Do you want continue?",
                    "Game over", JOptionPane.YES_NO_OPTION);
        }
        if (result == JOptionPane.OK_OPTION){
            isRunning = true;
            isStart = true;
            initGame(time);
        }else {
            System.exit(0);
        }
    }

    private void initMap() {
        itemMaps = readMap("map0");
    }

    private ItemMap[][] readMap(String fileName) {
        try {
            URL url = this.getClass().getClassLoader().getResource("daovanggame_v1/res/maps/" + fileName + ".txt");
            InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(new ReaderUTF8(in));
            String line = reader.readLine();
            int numberLine = 0;
            while (null != line) {
                int len = line.length();
                String imgId = "";
                for (int i = 0; i < len; i++) {
                    if (line.charAt(i) == ' ') {
                        if (!imgId.equals("00")) {
                            int col = i / 3;
                            int x = col * SIZE_ITEM;
                            int y = numberLine * SIZE_ITEM;
                            int sizeImg;
                            switch (imgId) {
                                case ItemImages.GOLD_ID0:
                                    sizeImg = SIZE_ITEM;
                                    break;
                                case ItemImages.GOLD_ID1:
                                    sizeImg = 2 * SIZE_ITEM;
                                    break;
                                case ItemImages.GOLD_ID2:
                                    sizeImg = 4 * SIZE_ITEM;
                                    break;
                                case ItemImages.GOLD_ID3:
                                    sizeImg = 6 * SIZE_ITEM;
                                    break;
                                case ItemImages.STONE_ID0:
                                    sizeImg = 3 * SIZE_ITEM;
                                    break;
                                case ItemImages.STONE_ID1:
                                    sizeImg = 3 * SIZE_ITEM;
                                    break;
                                default:
                                    sizeImg = 2 * SIZE_ITEM;
                                    break;
                            }
                            Image image = ItemImages.getImage(imgId);
                            itemMaps[numberLine][col] = new ItemMap(x, y, image, sizeImg, imgId);
                        }
                        imgId = "";
                    } else {
                        imgId += line.charAt(i);
                    }
                }
                line = reader.readLine();
                numberLine++;
            }
            reader.close();
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemMaps;
    }

    private void initHook() {
        int x = 30 * Constant.SIZE_ITEM + 8;
        int y = 7 * Constant.SIZE_ITEM - 6;
        hook = new Hook(x, y);
    }


    public void drawAll(Graphics2D g2d) {
        miner.draw(g2d);
        drawMap(g2d);
        hook.draw(g2d);
    }

    private void drawMap(Graphics2D g2d) {
        for (int i = 0; i < NUM_ROW; i++) {
            for (int j = 0; j < NUM_COL; j++) {
                if (itemMaps[i][j] != null) {
                    itemMaps[i][j].draw(g2d);
                }
            }
        }
    }

    public Hook getHook() {
        return hook;
    }


    private void rotateHook() {
        hook.rotate();
    }

    public void releaseHook(long time) {
        score += hook.releaseHook(time, itemMaps);
        changeImageMiner(time);
    }

    private void changeImageMiner(long time) {
        if (time % 5 != 0){
            return;
        }
        if (hook.isRelease()){
            miner.image = Miner.images0[(int) (time % 4)];
        }
        if (hook.isRetrun()){
            miner.image = Miner.images1[(int) (time % 8)];
        }
    }


    public int getGoal() {
        return goal;
    }
}
