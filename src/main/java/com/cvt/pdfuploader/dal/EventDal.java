package com.cvt.pdfuploader.dal;

import java.io.File;
import java.util.Map;

public interface EventDal {
    int countFiles(File[] files);
    File getDirectory();
    void persistData(String path, int count);
    Map<String, String> getPersistedData();
}
