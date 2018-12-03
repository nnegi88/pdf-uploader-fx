package com.cvt.pdfuploader.service;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface EventService {
    int countFiles(File[] files);
    File getDirectory();
    void persistData(String data, int count);
    Map<String, String> getPersistedData();
}
