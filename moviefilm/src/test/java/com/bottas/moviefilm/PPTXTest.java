package com.bottas.moviefilm;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xslf.usermodel.SlideLayout;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFSlideLayout;
import org.apache.poi.xslf.usermodel.XSLFSlideMaster;
import org.apache.poi.xslf.usermodel.XSLFTextShape;
import org.junit.Test;

public class PPTXTest { 
	@Test
	public void createpptx() throws IOException {

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
}
