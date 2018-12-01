package com.cvt.pdfuploader.dal.impl;

import com.cvt.pdfuploader.dal.EventDal;
import javafx.stage.FileChooser;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EventDalImpl implements EventDal {
    @Override
    public List<File> getFiles() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select .pdf files");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF","*.pdf"));
        List<File> files = new ArrayList<>();
        try{
            files = fileChooser.showOpenMultipleDialog(null);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return files;
    }

    @Override
    public void persistData(String path, int count){
        try {
            String data = path+"\n"+count;
            Files.write(Paths.get("data.txt"), data.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, String> getPersistedData() {
        String data = "";
        String count = "";
        Map<String, String> map = new HashMap<>();
        try {
            List<String> lines  = Files.readAllLines(Paths.get("data.txt"), StandardCharsets.UTF_8);
            data = lines.get(0);
            count = lines.get(1);
            map.put("data", data);
            map.put("count", count);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
