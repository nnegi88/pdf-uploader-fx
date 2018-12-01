package com.cvt.pdfuploader.service.impl;

import com.cvt.pdfuploader.dal.EventDal;
import com.cvt.pdfuploader.service.EventService;
import javafx.stage.FileChooser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Service
public class EventServiceImpl implements EventService{
    @Autowired private EventDal eventDal;

    @Override
    public int countFiles(List<File> files) {
        return files.size();
    }

    @Override
    public List<File> getFiles() {
        return eventDal.getFiles();
    }

    @Override
    public void persistData(String data, int count) {
        eventDal.persistData(data, count);
    }

    @Override
    public Map<String,String> getPersistedData() {
        return eventDal.getPersistedData();
    }
}
