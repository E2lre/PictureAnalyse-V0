package com.filedetail.analyse.model;

import java.util.List;

public class ImageMetadata {
    List<Detail> imageMetaDataList;

    public ImageMetadata() {
    }

    public ImageMetadata(List<Detail> imageMetaDataList) {
        this.imageMetaDataList = imageMetaDataList;
    }

    public List<Detail> getImageMetaDataList() {
        return imageMetaDataList;
    }

    public void setImageMetaDataList(List<Detail> imageMetaDataList) {
        this.imageMetaDataList = imageMetaDataList;
    }

    @Override
    public String toString() {
        return "ImageMetadata{" +
                "imageMetaDataList=" + imageMetaDataList +
                '}';
    }
}
