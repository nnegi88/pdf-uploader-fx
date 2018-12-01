package com.cvt.pdfuploader.dal;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface EventDal {
    List<File> getFiles();
    void persistData(String path, int count);
    Map<String, String> getPersistedData();
}
