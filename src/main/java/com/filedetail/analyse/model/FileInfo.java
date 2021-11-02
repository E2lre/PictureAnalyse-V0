package com.filedetail.analyse.model;

import java.time.LocalDate;
import java.util.List;

public class FileInfo {
    String fileName;
    String filePath;
    String fileType;
    String fileExt;
    LocalDate creationDate;
    LocalDate updateDate;
    long fileSize;
    ImageMetadata imageMetadataList;
    JpegMetadata jpegMetadataList;
    ExifIptcMetaData exifIptcMetaDataList;

    public FileInfo() {
    }

    public FileInfo(String fileName, String filePath, String fileType, String fileExt, LocalDate creationDate, LocalDate updateDate, long fileSize, ImageMetadata imageMetadataList, JpegMetadata jpegMetadataList, ExifIptcMetaData exifIptcMetaDataList) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.fileType = fileType;
        this.fileExt = fileExt;
        this.creationDate = creationDate;
        this.updateDate = updateDate;
        this.fileSize = fileSize;
        this.imageMetadataList = imageMetadataList;
        this.jpegMetadataList = jpegMetadataList;
        this.exifIptcMetaDataList = exifIptcMetaDataList;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileExt() {
        return fileExt;
    }

    public void setFileExt(String fileExt) {
        this.fileExt = fileExt;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public ImageMetadata getImageMetadataList() {
        return imageMetadataList;
    }

    public void setImageMetadataList(ImageMetadata imageMetadataList) {
        this.imageMetadataList = imageMetadataList;
    }

    public JpegMetadata getJpegMetadataList() {
        return jpegMetadataList;
    }

    public void setJpegMetadataList(JpegMetadata jpegMetadataList) {
        this.jpegMetadataList = jpegMetadataList;
    }

    public ExifIptcMetaData getExifIptcMetaDataList() {
        return exifIptcMetaDataList;
    }

    public void setExifIptcMetaDataList(ExifIptcMetaData exifIptcMetaDataList) {
        this.exifIptcMetaDataList = exifIptcMetaDataList;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "fileName='" + fileName + '\'' +
                ", filePath='" + filePath + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileExt='" + fileExt + '\'' +
                ", creationDate=" + creationDate +
                ", updateDate=" + updateDate +
                ", fileSize=" + fileSize +
                ", imageMetadataList=" + imageMetadataList +
                ", jpegMetadataList=" + jpegMetadataList +
                ", exifIptcMetaDataList=" + exifIptcMetaDataList +
                '}';
    }
}
