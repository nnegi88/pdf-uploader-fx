package com.cvt.pdfuploader;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class PdfUploaderApplication extends Application {
	private Parent rootNode;
	private ConfigurableApplicationContext springContext;
	@FXML private TextField textField;

	@Override
	public void init() throws Exception{
		springContext = SpringApplication.run(PdfUploaderApplication.class);
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/view.fxml"));
		fxmlLoader.setControllerFactory(springContext::getBean);
		rootNode = fxmlLoader.load();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("PDF Uploader");
		primaryStage.setScene(new Scene(rootNode));
		primaryStage.show();
	}

	@Override
	public void stop() throws Exception{
		springContext.stop();
	}

	public static void main(String args[]){
		launch(args);
	}
}