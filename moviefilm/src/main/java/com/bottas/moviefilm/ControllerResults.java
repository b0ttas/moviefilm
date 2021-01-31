package com.bottas.moviefilm;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.ResourceBundle;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ControllerResults implements Controller {
	@FXML
    AnchorPane root;

	@FXML
	private Button BtnShare;

	@FXML
	private Button BtnExport;

	@FXML
	private HBox HBox4Btns;

	@FXML
	private Label LblAddText;

	@FXML
	private ListView<CustomItem> listBoxMain;

	@FXML
	private Label TitleLbl;

	@FXML
	private VBox VBoxMain;

	@FXML
	private TextField txtAddItem;
	private ObservableList<CustomItem> listItems = FXCollections.observableArrayList();
	
    private static class CustomItem {
        private String name;
        private int price;
        public String getName() {
            return name;
        }
        public int getPrice() {
            return price;
        }
        public CustomItem(String name, int price) {
            super();
            this.name = name;
            this.price = price;
        }
    }
	
	// Add event handlers
	@FXML
	private void share(ActionEvent action) {
		//listItems.addAll(new CustomItem("teste", 0));
		System.out.println("[DEBUG] Go Back Button");
	}

	@FXML
	private void exportPresentation(ActionEvent action) {
        System.out.println("[DEBUG] Generate .pptx"); 
        XMLSlideShow ppt = new XMLSlideShow();  

        try (OutputStream os = new FileOutputStream("powerpoint.pptx")) {  
            XSLFSlideMaster defaultMaster = ppt.getSlideMasters().get(0);  
            XSLFSlideLayout tc = defaultMaster.getLayout(SlideLayout.TITLE_AND_CONTENT);  
            XSLFSlide slide = ppt.createSlide(tc);  
            XSLFTextShape title = slide.getPlaceholder(0);  
            title.setText("Nome do filme:");  
            XSLFTextShape body = slide.getPlaceholder(1);  
            body.clearText();  
            body.addNewTextParagraph().addNewTextRun().setText("Realizador:");  
            body.addNewTextParagraph().addNewTextRun().setText("Ano de lançamento:."); 
            ppt.write(os);  
            ppt.close();
        }catch(Exception e) {  
            System.out.println(e);    
        }  
	}
	
    @FXML
    public void initialize() {
        System.out.println("[DEBUG] Initialize Results");
        Button navToFirst = new Button("Voltar");
//        listBoxMain = new ListView<CustomItem>(listItems);

        navToFirst.setOnMouseClicked(event -> {
            Parent first = null;
			try {
				first = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            navToFirst.getScene().setRoot(first);
        });

        ((AnchorPane) root).getChildren().add(navToFirst);
    }

    @Override
    public Parent getContent() {
        return root;
    }
}