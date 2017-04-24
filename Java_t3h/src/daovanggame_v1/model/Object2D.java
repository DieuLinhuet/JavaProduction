package daovanggame_v1.model;

import java.awt.*;

/**
 * Created by DieuLinh on 20-Apr-17.
 */
public class Object2D {
    protected int sizeImg;
    protected int x;
    protected int y;
    protected Image image;

    public Object2D(){}

    public Object2D(int x, int y, Image image, int sizeImg) {
        this.x = x;
        this.y = y;
        this.image = image;
        this.sizeImg = sizeImg;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void draw(Graphics2D g2d){
        g2d.drawImage(image, x, y, sizeImg, sizeImg, null);
    }

    Rectangle getRectangle() {
        Rectangle rectangle = new Rectangle(x, y, sizeImg, sizeImg);
        return rectangle;
    }

}
