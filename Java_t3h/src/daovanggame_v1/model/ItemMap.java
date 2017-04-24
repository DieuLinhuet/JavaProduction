package daovanggame_v1.model;

import java.awt.*;

/**
 * Created by DieuLinh on 21-Apr-17.
 */
public class ItemMap extends Object2D {
    protected String imgId;

    public ItemMap(){}

    public ItemMap(int x, int y, Image image, int sizeImg, String imgId) {
        super(x, y, image, sizeImg);
        this.imgId = imgId;
    }

    public ItemMap(String imgId) {
        this.imgId = imgId;
    }

    public String getImgId() {
        return imgId;
    }
}
