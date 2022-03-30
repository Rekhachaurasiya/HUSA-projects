package main.java.utility;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;

import org.openqa.selenium.Dimension;


import gui.ava.html.image.generator.HtmlImageGenerator;

public class Html {


	public static void main(String[] args) throws InterruptedException  {
    	    
    	     //String uri = new File("D:\\AutomationSelenium_Dekstop\\AEM_Projects\\Redesign_HUSA\\HUSA_Automation.html").toURI().toString();
    	    	String uri = new File("C:\\Users\\0014HO744\\Desktop\\eclipse-workspace\\HUSADesktopVersionPart1\\HUSA_Automation.html").toURI().toString();
    	     HtmlImageGenerator imageGenerator = new HtmlImageGenerator();
    	          imageGenerator.loadUrl(uri);
    	          Thread.sleep(5000);
    	          imageGenerator.saveAsImage("ResultNew.JPEG");
    	      
    	        
    	    }





    }

