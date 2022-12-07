package com.example.coursework4.model;

import java.io.Serializable;
import java.util.Objects;

public class ImgDirModel implements Serializable {

    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public ImgDirModel(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ImgDirModel that = (ImgDirModel) o;

        return Objects.equals(imgUrl, that.imgUrl);
    }

    @Override
    public int hashCode() {
        return imgUrl != null ? imgUrl.hashCode() : 0;
    }
}
