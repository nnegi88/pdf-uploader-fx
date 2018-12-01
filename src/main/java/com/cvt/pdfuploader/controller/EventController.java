package com.cvt.pdfuploader.controller;

import com.cvt.pdfuploader.service.EventService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

@Controller
public class EventController implements Initializable{
    @FXML private TextField textField;
    @FXML private Label label;
    @Autowired private EventService eventService;

    @FXML private void browseOperation() throws IOException {
        List<File> files = eventService.getFiles();
        if (!files.isEmpty()){
            String data = files.get(0).getParent();
            int count = eventService.countFiles(files);
            eventService.persistData(data, count);
            textField.setText(data);
            label.setText("Count: "+count);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Map<String, String> map = eventService.getPersistedData();
        textField.setText(map.get("data"));
        label.setText("Count: "+map.get("count"));
    }
}
