package com.filedetail.analyse.model;

import java.util.List;

public class JpegMetadata {
    List<Detail> jpegMetaDataList;

    public JpegMetadata() {
    }

    public JpegMetadata(List<Detail> jpegMetaDataList) {
        this.jpegMetaDataList = jpegMetaDataList;
    }

    public List<Detail> getJpegMetaDataList() {
        return jpegMetaDataList;
    }

    public void setJpegMetaDataList(List<Detail> jpegMetaDataList) {
        this.jpegMetaDataList = jpegMetaDataList;
    }

    @Override
    public String toString() {
        return "JpegMetadata{" +
                "jpegMetaDataList=" + jpegMetaDataList +
                '}';
    }
}
