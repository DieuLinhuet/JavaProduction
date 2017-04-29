package daovanggame_v1.model;


import daovanggame_v1.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Created by DieuLinh on 21-Apr-17.
 */
public class Hook extends Object2D implements Constant {
    private Rope rope;
    private int theta;
    private int speed;
    private final Image IMG_HOOK = new ImageIcon(getClass().getResource("/daovanggame_v1/res/images/hook.png")).getImage();
    private final int SIZE_HOOK = SIZE_ITEM;

    private boolean isCheckTheta; // true: hook quay tu trai sang phai va nguoc lai
    private boolean isRelease; // true: hook dung quay
    private boolean isRetrun; // true: hook duoc keo ve
    private boolean finish; // true: ket thuc mot qua trinh tha-keo hook

    public Hook(int x, int y) {
        image = IMG_HOOK;
        sizeImg = SIZE_HOOK;
        rope = new Rope(x, y, x, y + 2 * sizeImg);
        this.x = x - sizeImg / 2;
        this.y = y + 2 * sizeImg;
        theta = 30;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setRelease(boolean release) {
        isRelease = release;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isRelease() {
        return isRelease;
    }

    public boolean isRetrun() {
        return isRetrun;
    }

    public void draw(Graphics2D g2d) {
        g2d.rotate(Math.toRadians(theta), rope.getX0(), rope.getY0());
        rope.draw(g2d);
        g2d.drawImage(image, x, y, sizeImg, sizeImg, null);
    }


    public void rotate(long time) {
        /*if (time % 3 != 0){
            return;
        }*/
        int x = rope.getX0(); // toa do tam
        int y = rope.getY0(); //toa do tam
        if (isRelease || isRetrun) {
            return;
        }
        if (isCheckTheta) {
            theta += 1;
            if (theta == 80) {
                isCheckTheta = false;
            }
        } else {
            theta -= 1;
            if (theta == -80) {
                isCheckTheta = true;
            }
        }
        this.x = x - sizeImg / 2;
        this.y = y + 2 * sizeImg;
        rope.setY1(this.y);
    }

    public void releaseHook(long time, ItemMap[][] itemMaps) {
        if (isRetrun) {
            pullRope(time);
        }
        int x, y;
        if (theta > 0) {
            x = (int) (rope.getX0() - (this.y - rope.getY0()) * Math.sin(Math.toRadians(theta)));
            y = (int) (rope.getY0() + (this.y - rope.getY0()) * Math.cos(Math.toRadians(theta)));
        } else if (theta < 0) {
            x = (int) (rope.getX0() + (this.y - rope.getY0()) * Math.sin(Math.toRadians(-theta)));
            y = (int) (rope.getY0() + (this.y - rope.getY0()) * Math.cos(Math.toRadians(-theta)));
        } else {
            x = rope.getX0();
            y = this.y;
        }
        if (x < 0 || x > WIDTH_FRAME || y > HEIGHT_FRAME) {
            isRelease = false;
            isRetrun = true;
            pullRope(time);
        }
        if (!isRelease) {
            return;
        }
        if (time % 5 != 0) {
            return;
        }
        speed = 5;
        this.y += speed;
        rope.setY1(this.y);

        ItemMap itemMap = interaction(itemMaps);
        if (itemMap != null) {
            image = changeImage(itemMaps);
            sizeImg = itemMap.sizeImg;
            this.x = rope.getX0() - sizeImg / 2;
            isRelease = false;
            isRetrun = true;
            pullRope(time);
        }

    }

    private void pullRope(long time) {
        if (y <= rope.getY0()) {
            image = IMG_HOOK;
            sizeImg = SIZE_HOOK;
            isRetrun = false;
            finish = true;
            return;
        }
        if (!isRetrun) {
            return;
        }
//        if (time % 3 != 0){
//            return;
//        }
        y -= 10;
        rope.setY1(this.y);
    }

    //    Kiem tra va cham, neu va cham tra ve doi tuong bi va cham voi hook
    private ItemMap interaction(ItemMap[][] itemMaps) {
        return interactionTop(itemMaps);
    }

    private ItemMap interactionLeftAndRight(ItemMap[][] itemMaps) {
        int x1, x2, y1, y2;
        int row1, row2, col;
        ItemMap itemMap;
        if (theta > 0) {
            x2 = (int) (rope.getX0() - (y - rope.getY0()) * Math.sin(Math.toRadians(theta)));
            y2 = (int) (rope.getY0() + (y - rope.getY0()) * Math.cos(Math.toRadians(theta)));

            x1 = (int) (x2 + sizeImg * Math.cos(Math.toRadians(theta)));
            y1 = (int) (y2 + sizeImg * Math.sin(Math.toRadians(theta)));
        } else if (theta < 0) {
            x1 = (int) (rope.getX0() + (y + sizeImg - rope.getY0()) * Math.sin(Math.toRadians(-theta)));
            y1 = (int) (rope.getY0() + (y + sizeImg - rope.getY0()) * Math.cos(Math.toRadians(-theta)));

            x2 = (int) (x1 + sizeImg * Math.cos(Math.toRadians(-theta)));
            y2 = (int) (y1 - sizeImg * Math.sin(Math.toRadians(-theta)));
        } else {
            x1 = rope.getX0();
            x2 = x1 + sizeImg;
            y2 = this.y + sizeImg;
        }

        row1 = x2 / SIZE_ITEM;
        row2 = (x2 + 6 * SIZE_ITEM) / SIZE_ITEM;
        col = x2 / SIZE_ITEM;

        if (col < 0 || col > NUM_COL) {
            return null;
        }
        if (row2 >= NUM_ROW - 6) {
            for (int i = NUM_ROW - 6; i <= NUM_ROW - 1; i++) {
                itemMap = itemMaps[i][col];
                if (itemMap != null) {
                    if (y2 >= itemMap.getY() && y2 <= itemMap.getY() + itemMap.sizeImg) {
                        return itemMap;
                    }
                }
            }
        } else {
            return null;
        }
        for (int i = row1; i <= row2; i++) {
            itemMap = itemMaps[i][col];
            if (itemMap != null) {
                if (y2 >= itemMap.getY() && y2 <= itemMap.getY() + sizeImg) {
                    return itemMap;
                }
            }
        }
        return null;
    }


    private ItemMap interactionTop(ItemMap[][] itemMaps) {
        int x1, y1, x2, y2;
        int col1, col2, row;
        ItemMap itemMap;
        if (theta > 0) {
            x2 = (int) (rope.getX0() - (y - rope.getY0()) * Math.sin(Math.toRadians(theta)));
            y2 = (int) (rope.getY0() + (y - rope.getY0()) * Math.cos(Math.toRadians(theta)));

            x1 = (int) (x2 + sizeImg * Math.cos(Math.toRadians(theta)));
            y1 = (int) (y2 + sizeImg * Math.sin(Math.toRadians(theta)));
        } else if (theta < 0) {
            x1 = (int) (rope.getX0() + (y + sizeImg - rope.getY0()) * Math.sin(Math.toRadians(-theta)));
            y1 = (int) (rope.getY0() + (y + sizeImg - rope.getY0()) * Math.cos(Math.toRadians(-theta)));

            x2 = (int) (x1 + sizeImg * Math.cos(Math.toRadians(-theta)));
            y2 = (int) (y1 - sizeImg * Math.sin(Math.toRadians(-theta)));
        } else {
            x1 = rope.getX0();
            x2 = x1 + sizeImg;
            y1 = this.y + sizeImg;
        }

        col1 = (x1 - 6 * SIZE_ITEM) / SIZE_ITEM;
        col2 = x2 / SIZE_ITEM;
        row = y1 / SIZE_ITEM;

        if (col2 > NUM_COL || row > NUM_ROW) {
            return null;
        }
        if (col1 <= 6 || col2 <= 6) {
            for (int j = 0; j <= 6; j++) {
                itemMap = itemMaps[row][j];
                if (itemMap != null) {
                    if (x1 >= itemMap.getX() && x1 <= itemMap.getX() + itemMap.sizeImg) {
                        return itemMap;
                    }
                    if (x2 >= itemMap.getX() && x2 <= itemMap.getX() + itemMap.sizeImg) {
                        return itemMap;
                    }
                }
            }
        } else {
            return null;
        }
        for (int i = col1; i <= col2; i++) {
            itemMap = itemMaps[row][i];
            if (itemMap != null) {
                if (x1 >= itemMap.getX() && x1 <= itemMap.getX() + itemMap.sizeImg) {
                    return itemMap;
                }
                if (x2 >= itemMap.getX() && x2 <= itemMap.getX() + itemMap.sizeImg) {
                    return itemMap;
                }
            }
        }
        return null;
    }

    //    Thay doi image hook bang image cua item khi xay ra va cham
    private Image changeImage(ItemMap[][] itemMaps) {
        ItemMap itemMap = interaction(itemMaps);
        if (itemMap != null) {
            String idImg = itemMap.getImgId();
            switch (idImg) {
                case ItemImages.GOLD_ID0:
                    return ItemImages.getImage(ItemImages.GOLD_IDOX);
                case ItemImages.GOLD_ID1:
                    return ItemImages.getImage(ItemImages.GOLD_ID1X);
                case ItemImages.GOLD_ID2:
                    return ItemImages.getImage(ItemImages.GOLD_ID2X);
                case ItemImages.GOLD_ID3:
                    return ItemImages.getImage(ItemImages.GOLD_ID3X);
                case ItemImages.STONE_ID0:
                    return ItemImages.getImage(ItemImages.STONE_ID0X);
                case ItemImages.STONE_ID1:
                    return ItemImages.getImage(ItemImages.STONE_ID1X);
                default:
                    return ItemImages.getImage(ItemImages.BAG_IDX);
            }
        }
        return null;
    }

}