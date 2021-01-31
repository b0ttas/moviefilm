package com.bottas.moviefilm;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class ControllerMain implements Controller {
	@FXML
    AnchorPane root;

	@FXML
	HBox HBox;
	
    @FXML
    public void initialize() {
        System.out.println("[DEBUG] Initialize Main");
        
        Button navToSecond = new Button("Pesquisar");
        navToSecond.setCenterShape(true);

        navToSecond.setOnMouseClicked(event -> {       
        	Parent second = null;
			try {
				second = FXMLLoader.load(getClass().getClassLoader().getResource("Results.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            navToSecond.getScene().setRoot(second);
        });

        ((HBox) HBox).getChildren().add(navToSecond);
    }

    @Override
    public Parent getContent() {
        return root;
    }
}
