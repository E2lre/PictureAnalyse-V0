package com.filedetail.analyse.service;

import com.filedetail.analyse.model.FileInfo;

import java.util.List;

public interface AnalyseService {
    public FileInfo getFileInfo(String fileName, String filePath);
    public List<String> getInfoAnalyse (String fileName, String filePath);
}
