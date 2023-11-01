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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tnckr
 */
public class LibraryController implements Initializable {
    
    public Stage stage;
    public Scene scene;
    public Parent root;


    
    @FXML
    private Button booklist;
    
    @FXML
    private Button exit;
    
    @FXML
   public void exit(){
       System.exit(0);
   }
   
    @FXML
    void userbooklist(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("UserBookList.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene  scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
