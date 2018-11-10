package application;
//Matthew Lee
//Started October 5, 2018

//TODO: See the README

import com.sun.jna.platform.win32.Advapi32Util;
import static com.sun.jna.platform.win32.WinReg.HKEY_CURRENT_USER;
import static com.sun.jna.platform.win32.WinReg.HKEY_LOCAL_MACHINE;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

public class limitINIEditor extends Application{
	
	public static void main(String[] args) {
	    
	    printTest();
	    launch(args);
	}
	
	public static final String FILENAME = "C:\\Users\\Matthew Lee\\Documents\\Rainmeter\\Skins\\LIM!T\\@Resources\\Limvar.ini";
	public static final String FROSTFILE = "C:\\Users\\Matthew Lee\\Documents\\Rainmeter\\Skins\\Frost\\@Resources\\Variables.inc";

	
	//prints message to console and accepts input that will rewrite the ini file
	//no check to see if valid input.
	public static void colorPrompt(String input) {
		
		//try-catch block: editing file
		try {
		//
		//L!MIT
		//
		Wini limvar;
		limvar = new Wini(new File(FILENAME));
		limvar.put("Variables", "color1", input);
		limvar.put("Variables", "color2", input);
		limvar.put("Variables", "color3", input);
		limvar.put("Variables", "color4", input);
		limvar.store();
		
		//
		//FROST
		//
		
		Wini frostVars;
		frostVars = new Wini(new File(FROSTFILE));
		frostVars.put("Variables", "Color", input);
		frostVars.store();
		
		//system prints message if successful
		System.out.println("Successful overwrite");
		} catch (InvalidFileFormatException e) {
			  Alert fileFormat = new Alert(AlertType.ERROR);
			  fileFormat.setHeaderText("Invalid File Format");
			  fileFormat.setContentText("Invalid File Format. Please contact the developer for further details.");
			  fileFormat.showAndWait();
		 } catch (IOException e) {
			 Alert fileRead = new Alert(AlertType.ERROR);
			 fileRead.setHeaderText("File Read Error");
			 fileRead.setContentText("Could not read file. Please contact the developer for further details.");
			 fileRead.showAndWait();
		 }
	}
	
	//opens command line, changes directory and refreshes rainmeter.
	public static void refreshRainMeter() {
		try {
			Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd \\Program Files\\Rainmeter && Rainmeter.exe !RefreshApp && taskkill /f /im cmd.exe\"");
		} catch (Exception e){
			Alert cmdAccess = new Alert(AlertType.ERROR);
			cmdAccess.setHeaderText("CMD Access Error");
			cmdAccess.setContentText("Failed to initiate command line.");
			cmdAccess.showAndWait();
		}
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

        
        primaryStage.setTitle("Rainmeter Quick Color Editor 0.1");
        //border pane - houses child layouts
      	BorderPane borderPane = new BorderPane();
      	//scene
        Scene appWindow = new Scene(borderPane, 400, 200);
        
        //Elements in Center
        Label instruc = new Label("Input numbers from 0-255 in the form of #,#,#.");
        Button apply = new Button("Apply Color");
        TextField input = new TextField();
        input.setAlignment(Pos.CENTER);
        
        apply.addEventHandler(ActionEvent.ACTION, (e) -> {
        	colorPrompt(input.getText());
        	refreshRainMeter();
        });
        

        
        //Center and content
        VBox center = new VBox (3);
        center.setAlignment(Pos.CENTER);
        center.getChildren().addAll(instruc, input, apply);
        
        borderPane.setCenter(center);
        
        //loading CSS
        try {
        	appWindow.getStylesheets().add("application.css");
        } catch (Exception e) {
        	Alert noCSS = new Alert(AlertType.ERROR);
        	noCSS.setHeaderText("CSS Not Found");
        	noCSS.setContentText("CSS Stylesheet not found. Some content may display incorrectly or not at all. The application was packaged incorrectly.");
        	noCSS.showAndWait();
        }
        
        primaryStage.setScene(appWindow);
        primaryStage.show();
    
        //hex to RGB
        
		
	}
	
	public static Color removeOddFormatting(String colorStr) {
        return Color.decode(colorStr);
    }
    
	
	//returns the currently active RGB profile as configured in GamingCenter
	public static String getActiveProfile() {
		return Advapi32Util.registryGetStringValue
                (HKEY_LOCAL_MACHINE,
                        "SOFTWARE\\OEM\\GamingCenter\\RGBKeyboardView", "CurrentProfile");
	}
    
	//currently returns byte array - need the string data that you see in regedit or somehow convert to the proper hex value, is just hex number split into 3 sets of 2 characters
	public byte[] getBinaryValue() {
			try {
				return Advapi32Util.registryGetBinaryValue(HKEY_LOCAL_MACHINE, "SOFTWARE\\OEM\\GamingCenter\\RGBKeyboardView\\ME\\Profile0\\Mode0\\Effect0", "ColorBuffer");
			} catch (RuntimeException re) {
				throw new RuntimeException("Registry key is not of type Binary. ");
			}
	}
}
