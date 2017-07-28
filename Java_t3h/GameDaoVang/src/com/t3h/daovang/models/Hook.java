package com.t3h.daovang.models;

import com.t3h.daovang.Constant;

import javax.swing.*;
import java.awt.*;

/**
 * Created by dieulinh on 6/16/17.
 */
public class Hook extends Object2D implements Constant {
    private Rope rope;
    private int theta;
    private int speed;
    private final Image IMG_HOOK = new ImageIcon(getClass().
            getResource("/com/t3h/daovang/res/images/hook.png")).getImage();
    private final int SIZE_HOOK = SIZE_ITEM;

    private boolean isCheckTheta; // true: hook quay tu trai sang phai va nguoc lai
    private boolean isRelease; // true: hook dung quay
    private boolean isRetrun; // true: hook duoc keo ve
    private boolean isInteraction;//true: xay ra va cham
    private boolean finish; //true: ket thuc 1 lan tha hook
    private int idItem; //id item map de tinh score

    Hook(int x, int y) {
        image = IMG_HOOK;
        sizeImg = SIZE_HOOK;
        rope = new Rope(x, y, x, y + 2 * sizeImg);
        this.x = x - sizeImg / 2;
        this.y = y + 2 * sizeImg;
        theta = 30;
    }

    public void setRelease(boolean release) {
        isRelease = release;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public boolean isFinish() {
        return finish;
    }

    boolean isRelease() {
        return isRelease;
    }

    boolean isRetrun() {
        return isRetrun;
    }

    public void draw(Graphics2D g2d) {
        g2d.rotate(Math.toRadians(theta), rope.getX0(), rope.getY0());
        rope.draw(g2d);
        g2d.drawImage(image, x, y, sizeImg, sizeImg, null);
    }


    void rotate() {
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

    int releaseHook(long time, ItemMap[][] itemMaps) {
        if (isRetrun) {
            if (!isInteraction) {
                speed = 30;
            }
            return pullRope(time);
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
            if (!isInteraction) {
                speed = 30;
            }
            return pullRope(time);
        }
        if (!isRelease) {
            return 0;
        }
        if (time % 5 != 0) {
            return 0;
        }
        speed = 10;
        this.y += speed;
        rope.setY1(this.y);

        ItemMap itemMap = interaction(itemMaps);
        if (itemMap != null) {
            image = changeImage(itemMaps);
            sizeImg = itemMap.sizeImg;
            this.x = rope.getX0() - sizeImg / 2;
            isRelease = false;
            isRetrun = true;
            isInteraction = true;
            switch (itemMap.getImgId()) {
                case ItemImages.GOLD_ID0:
                    speed = 20;
                    idItem = 1;
                    break;
                case ItemImages.GOLD_ID1:
                    speed = 5;
                    idItem = 2;
                    break;
                case ItemImages.GOLD_ID2:
                    speed = 4;
                    idItem = 3;
                    break;
                case ItemImages.STONE_ID0:
                case ItemImages.STONE_ID1:
                    speed = 3;
                    idItem = 4;
                    break;
                case ItemImages.GOLD_ID3:
                    speed = 1;
                    idItem = 5;
                    break;
                default:
                    speed = 4;
                    idItem = 6;
                    break;
            }
            pullRope(time);
            int i = itemMap.getY() / SIZE_ITEM;
            int j = itemMap.getX() / SIZE_ITEM;
            itemMaps[i][j] = null;
        }
        return 0;
    }

    private int pullRope(long time) {
        if (y <= rope.getY0() + sizeImg) {
            image = IMG_HOOK;
            sizeImg = SIZE_HOOK;
            this.x = rope.getX0() - sizeImg / 2;
            isRetrun = false;
            isInteraction = false;
            finish = true;
            switch (idItem) {
                case 1:
                    idItem = 0;
                    return 50;
                case 2:
                    idItem = 0;
                    return 100;
                case 3:
                    idItem = 0;
                    return 250;
                case 4:
                    idItem = 0;
                    return 20;
                case 6:
                    idItem = 0;
                    return 238;
                case 5:
                    idItem = 0;
                    return 500;
                default:
                    return 0;

            }
        }
        if (!isRetrun) {
            return 0;
        }
        if (time % 5 != 0) {
            return 0;
        }
        y -= speed;
        rope.setY1(this.y);
        return 0;
    }

    //    Kiem tra va cham, neu va cham tra ve doi tuong bi va cham voi hook
    private ItemMap interaction(ItemMap[][] itemMaps) {
        ItemMap itemMap = interactionTop(itemMaps);
        ItemMap itemMap1 = interactionRight(itemMaps);
        ItemMap itemMap2 = interactionLeft(itemMaps);
        if (itemMap != null) {
            return itemMap;
        }
        if (itemMap1 != null) {
            return itemMap1;
        }
        if (itemMap2 != null) {
            return itemMap2;
        }
        return null;
    }

    private ItemMap interactionLeft(ItemMap[][] itemMaps) {
        int x1, x2, y1, y2;
        int row1, row2;
        int col1, col2;

        if (theta > 0) {
            y1 = (int) (rope.getY0() + (y - rope.getY0() + sizeImg) * Math.cos(Math.toRadians(theta)));
            x1 = (int) (rope.getX0() - (y - rope.getY0() + sizeImg) * Math.sin(Math.toRadians(theta)));

            x2 = (int) (x1 + sizeImg * Math.cos(Math.toRadians(theta)));
            y2 = (int) (y1 + sizeImg * Math.sin(Math.toRadians(theta)));

            row2 = (y2 + 6 * SIZE_ITEM) / SIZE_ITEM;
            row1 = (y2 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col1 = (x2 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col2 = x2 / SIZE_ITEM;
        } else if (theta < 0) {
            x2 = (int) (rope.getX0() + (y - rope.getY0() + sizeImg) * Math.sin(Math.toRadians(-theta)));
            y2 = (int) (rope.getY0() + (y - rope.getY0() + sizeImg) * Math.cos(Math.toRadians(-theta)));

            x1 = (int) (x2 + sizeImg * Math.cos(Math.toRadians(-theta)));
            y1 = (int) (y2 - sizeImg * Math.sin(Math.toRadians(-theta)));

            row2 = (y2 + 6 * SIZE_ITEM) / SIZE_ITEM;
            row1 = (y2 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col1 = (x2 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col2 = x2 / SIZE_ITEM;
        } else {
            x2 = rope.getX0() - sizeImg / 2;
            y2 = y + sizeImg;
            x1 = rope.getX0() + sizeImg / 2;

            row2 = (y2 + 6 * SIZE_ITEM) / SIZE_ITEM;
            row1 = (y2 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col1 = (x2 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col2 = x2 / SIZE_ITEM;
        }
        if (col2 >= NUM_COL || row2 >= NUM_ROW) {
            return null;
        }
        if (col1 < 0) {
            for (int i = row1; i <= row2; i++) {
                for (int j = 0; j <= 6; j++) {
                    ItemMap itemMap = itemMaps[i][j];
                    if (itemMap != null) {
                        if (y2 >= itemMap.getY() && y2 <= itemMap.getY() + itemMap.sizeImg
                                && x2 >= itemMap.getX() && x2 <= itemMap.getX() + itemMap.sizeImg) {
                            return itemMap;
                        }
                    }
                }
            }
        } else {
            for (int i = row1; i <= row2; i++) {
                for (int j = col1; j <= col2; j++) {
                    ItemMap itemMap = itemMaps[i][j];
                    if (itemMap != null) {
                        if (y2 >= itemMap.getY() && y2 <= itemMap.getY() + itemMap.sizeImg
                                && x2 >= itemMap.getX() && x2 <= itemMap.getX() + itemMap.sizeImg) {
                            return itemMap;
                        }
                    }
                }
            }
        }
        return null;
    }

    private ItemMap interactionRight(ItemMap[][] itemMaps) {
        int x1, x2, y1, y2;
        int row1, row2;
        int col;

        if (theta > 0) {
            y2 = (int) (rope.getY0() + (y - rope.getY0() + sizeImg) * Math.cos(Math.toRadians(theta)));
            x2 = (int) (rope.getX0() - (y - rope.getY0() + sizeImg) * Math.sin(Math.toRadians(theta)));

            x1 = (int) (x2 + sizeImg * Math.cos(Math.toRadians(theta)));
            y1 = (int) (y2 + sizeImg * Math.sin(Math.toRadians(theta)));

            row2 = (y1 + 6 * SIZE_ITEM) / SIZE_ITEM;
            row1 = (y1 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col = x1 / SIZE_ITEM;
        } else if (theta < 0) {
            x2 = (int) (rope.getX0() + (y - rope.getY0() + sizeImg) * Math.sin(Math.toRadians(-theta)));
            y2 = (int) (rope.getY0() + (y - rope.getY0() + sizeImg) * Math.cos(Math.toRadians(-theta)));

            x1 = (int) (x2 + sizeImg * Math.cos(Math.toRadians(-theta)));
            y1 = (int) (y2 - sizeImg * Math.sin(Math.toRadians(-theta)));

            row2 = (y1 + 6 * SIZE_ITEM) / SIZE_ITEM;
            row1 = (y1 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col = x1 / SIZE_ITEM;
        } else {
            x2 = rope.getX0() - sizeImg / 2;
            y1 = y + sizeImg;
            x1 = rope.getX0() + sizeImg / 2;

            row2 = (y1 + 6 * SIZE_ITEM) / SIZE_ITEM;
            row1 = (y1 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col = x1 / SIZE_ITEM;
        }
        if (col >= NUM_COL || row2 >= NUM_ROW || col < 0) {
            return null;
        }
        for (int i = row1; i <= row2; i++) {
            ItemMap itemMap = itemMaps[i][col];
            if (itemMap != null) {
                if (y1 >= itemMap.getY() && y1 <= itemMap.getY() + itemMap.sizeImg) {
                    return itemMap;
                }
            }
        }
        return null;
    }

    private ItemMap interactionTop(ItemMap[][] itemMaps) {
        int x1, x2, y1, y2;
        int col1, col2;
        int row;

        if (theta > 0) {
            y2 = (int) (rope.getY0() + (y - rope.getY0() + sizeImg) * Math.cos(Math.toRadians(theta)));
            x2 = (int) (rope.getX0() - (y - rope.getY0() + sizeImg) * Math.sin(Math.toRadians(theta)));

            x1 = (int) (x2 + sizeImg * Math.cos(Math.toRadians(theta)));
            y1 = (int) (y2 + sizeImg * Math.sin(Math.toRadians(theta)));
//            xac dinh lai cac toa do
            int ch1 = (int) ((y - rope.getY0() + sizeImg) * Math.toRadians(-theta));


            col1 = (x2 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col2 = x1 / SIZE_ITEM;
            row = y1 / SIZE_ITEM;
        } else if (theta < 0) {
            x1 = (int) (rope.getX0() + (y - rope.getY0() + sizeImg) * Math.sin(Math.toRadians(-theta)));
            y1 = (int) (rope.getY0() + (y - rope.getY0() + sizeImg) * Math.cos(Math.toRadians(-theta)));

            x2 = (int) (x1 + sizeImg * Math.cos(Math.toRadians(-theta)));
            y2 = (int) (y1 - sizeImg * Math.sin(Math.toRadians(-theta)));

            col1 = (x1 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col2 = x2 / SIZE_ITEM;
            row = y1 / SIZE_ITEM;
        } else {
            x1 = rope.getX0() - sizeImg / 2;
            y1 = y + sizeImg;
            x2 = rope.getX0() + sizeImg / 2;

            col1 = (x1 - 6 * SIZE_ITEM) / SIZE_ITEM;
            col2 = x2 / SIZE_ITEM;
            row = y1 / SIZE_ITEM;
        }
        if (col2 >= NUM_COL || row >= NUM_ROW) {
            return null;
        }
        if (col1 < 0) {
            for (int i = 0; i <= 6; i++) {
                ItemMap itemMap = itemMaps[row][i];
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
            for (int i = col1; i <= col2; i++) {
                ItemMap itemMap = itemMaps[row][i];
                if (itemMap != null) {
                    if (x1 >= itemMap.getX() && x1 <= itemMap.getX() + itemMap.sizeImg) {
                        return itemMap;
                    }
                    if (x2 >= itemMap.getX() && x2 <= itemMap.getX() + itemMap.sizeImg) {
                        return itemMap;
                    }
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
