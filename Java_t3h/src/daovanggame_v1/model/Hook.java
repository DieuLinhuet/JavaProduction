package daovanggame_v1.model;


import daovanggame_v1.Constant;

import javax.swing.*;
import java.awt.*;

import static daovanggame_v1.Constant.SIZE_ITEM;

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
        rope = new Rope(x, y, x, y);
        image = IMG_HOOK;
        sizeImg = SIZE_HOOK;
        this.x = x;
        this.y = y;
        theta = 0;
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
            theta -= 1;
            if (theta == -80) {
                isCheckTheta = false;
            }
        } else {
            theta += 1;
            if (theta == 70) {
                isCheckTheta = true;
            }
        }
        this.x = x - sizeImg / 2;
        this.y = y + sizeImg;
        rope.setY1(this.y);

    }

    public void releaseHook(long time, ItemMap[][] itemMaps) {
        if (isRetrun) {
            pullRope(time);
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
        speed = 2;
        y += speed;
        rope.setY1(this.y);

        ItemMap itemMap = interaction(itemMaps);
        if (itemMap != null) {
            image = changeImage(itemMaps);
            sizeImg = itemMap.sizeImg;
            x = rope.getX0() - sizeImg / 2;
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
        y -= 5;
        rope.setY1(this.y);
    }

    //    Kiem tra va cham, neu va cham tra ve doi tuong bi va cham voi hook
    private ItemMap interaction(ItemMap[][] itemMaps) {

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
