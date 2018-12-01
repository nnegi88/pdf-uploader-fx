package com.cvt.pdfuploader.service;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface EventService {
    int countFiles(List<File> files);
    List<File> getFiles();
    void persistData(String data, int count);
    Map<String, String> getPersistedData();
}
