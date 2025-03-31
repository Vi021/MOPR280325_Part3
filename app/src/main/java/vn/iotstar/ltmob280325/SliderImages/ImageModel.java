package vn.iotstar.ltmob280325.SliderImages;

import java.io.Serializable;

public class ImageModel implements Serializable {
    private int imgId;

    public ImageModel(int imgId) { this.imgId = imgId; }

    public int getImgId() { return imgId; }
    public void setImgId(int imgId) { this.imgId = imgId; }
}
