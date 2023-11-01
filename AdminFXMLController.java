/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


public class AdminFXMLController implements Initializable {
    
    public Stage stage;
    public Scene scene;
    public Parent root;
    
    @FXML
    private Button exit;
    
    @FXML
    private Button newBook;
    
    @FXML
    public void adminToList(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("ListFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene  scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
     
    }
    
    @FXML
    void adminToNewBook(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("NewBookFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene  scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    @FXML
    void adminToBookList(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("BookList.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene  scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
    
    
   @FXML
   public void exit(){
       System.exit(0);
   }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
