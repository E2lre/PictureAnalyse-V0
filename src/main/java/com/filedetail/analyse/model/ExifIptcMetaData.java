package com.filedetail.analyse.model;

import java.util.List;

public class ExifIptcMetaData {
    List<Detail> exifIptcMetaData;

    public ExifIptcMetaData() {
    }

    public ExifIptcMetaData(List<Detail> exifIptcMetaData) {
        this.exifIptcMetaData = exifIptcMetaData;
    }

    public List<Detail> getExifIptcMetaData() {
        return exifIptcMetaData;
    }

    public void setExifIptcMetaData(List<Detail> exifIptcMetaData) {
        this.exifIptcMetaData = exifIptcMetaData;
    }

    @Override
    public String toString() {
        return "ExifIptcMetaData{" +
                "exifIptcMetaData=" + exifIptcMetaData +
                '}';
    }
}
