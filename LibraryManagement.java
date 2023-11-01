/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */

import java.awt.event.MouseEvent;
import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author tnckr
 */
public class LibraryManagement extends Application {
    
    private double x = 0;
    private double y = 0;
    
    
    public static void main(String[] args) {
        
        launch(args);
    }
    public void start(Stage stage) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("LoginMenu.fxml"));
        Scene scene = new Scene(root);
        
       
        
        stage.initStyle(StageStyle.TRANSPARENT);
        
        
        stage.setScene(scene);
        stage.setTitle("Library Management");
        stage.show();
    }
    
}
