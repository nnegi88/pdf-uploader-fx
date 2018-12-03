package com.cvt.pdfuploader.dal.impl;

import com.cvt.pdfuploader.dal.EventDal;
import javafx.stage.DirectoryChooser;
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
    public int countFiles(File[] files) {
        int count = 0;
        for(File file : files){
            if(file.isFile()){
                if(file.getAbsolutePath().endsWith(".pdf"))
                    count++;
            }
        }
        return count;
    }

    @Override
    public File getDirectory() {
        DirectoryChooser chooser = new DirectoryChooser();
        chooser.setTitle("Select a directory");
        return chooser.showDialog(null);
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
