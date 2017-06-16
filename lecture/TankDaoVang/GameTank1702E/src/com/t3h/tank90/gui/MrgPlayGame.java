package com.t3h.tank90.gui;

import com.t3h.tank90.common.Constants;
import com.t3h.tank90.gui.obj.ItemMap;
import com.t3h.tank90.gui.obj.MyTank;
import com.t3h.tank90.gui.obj.Obj2DMovable;
import jdk.internal.util.xml.impl.ReaderUTF8;

import java.awt.*;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.jar.JarFile;

/**
 * Created by ducnd on 05/04/2017.
 */
public class MrgPlayGame implements Constants {
    private ItemMap[][] itemMaps;
    private MyTank myTank;

    public MrgPlayGame() {
        itemMaps = new ItemMap[NUMBER_ROW][NUMBER_COLUMN];
        initMap();
        initMyTank();

    }

    private void initMyTank() {
        int ori = Obj2DMovable.UP;
        int x = 10 * Constants.SIZE_ITEM_GAME;
        int y = 25 * Constants.SIZE_ITEM_GAME;
        Image image = MyTank.IMG_MY_TANK[ori];
        int speed = 5;
        myTank = new MyTank(image, x, y, Constants.SIZE_ITEM_GAME * 2-10,
                speed, ori);
    }

    private void initMap() {

        try {
            URL url = this.getClass().getClassLoader().getResource("maps/map.txt");
            InputStream in = url.openStream();
            BufferedReader reader = new BufferedReader(new ReaderUTF8(in));
            String line = reader.readLine();
            int numberLine = 0;
            while (null != line) {
                int le = line.length();
                for (int i = 0; i < le; i++) {
                    int imgID = line.charAt(i) - '0';
                    if (imgID != 0) {
                        int x = i * SIZE_ITEM_GAME;
                        int y = numberLine * SIZE_ITEM_GAME;
                        int size = imgID == 9 ? SIZE_ITEM_GAME * 2 : SIZE_ITEM_GAME;
                        Image image = PicturesGame.getImage(imgID);
                        ItemMap itemMap =
                                new ItemMap(image, x, y, size, imgID);
                        itemMaps[numberLine][i] = itemMap;
                    }

                }
                line = reader.readLine();
                numberLine++;
            }
//            file.delete();
            reader.close();
//            in.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void drawAll2D(Graphics2D g2d) {
        for (int i = 0; i < NUMBER_ROW; i++) {
            for (int j = 0; j < NUMBER_COLUMN; j++) {
                if (itemMaps[i][j] != null) {
                    itemMaps[i][j].draw(g2d);
                }
            }
        }
    }

    private File getFile() {
        try {
            InputStream stream =
                    getClass().getResource("/maps/map6.txt")
                            .openConnection()
                            .getInputStream();

            File file = new File("map.txt");
            file.createNewFile();
            FileOutputStream output = new FileOutputStream("map.txt");
            byte b[] = new byte[1024];
            int le = stream.read(b);
            while (le > 0) {
                output.write(b, 0, le);
                le = stream.read(b);
            }
            output.close();
            stream.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void moveMyTank(int orientation, long time) {
        if ( time % myTank.getSleep() == 0) {
            myTank.changeOrientation(orientation);
            myTank.move(itemMaps);
        }

    }

    public void fireBulletMyTank(long time) {
        myTank.fire(time);
    }

    public void drawAll(Graphics2D g2d) {
        drawAll2D(g2d);
        myTank.draw(g2d);
        myTank.drawAllBullet(g2d);
    }

    public void moveAllBulletMyTank(long time) {
        myTank.moveAllBullet(itemMaps, time);
    }
}
