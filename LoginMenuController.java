/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tnckr
 */
public class LoginMenuController implements Initializable {
    
    Alert alert = new Alert(AlertType.INFORMATION);
    
    @FXML
    private Label label;
    
    @FXML
    private Button buton;
    
    public Stage stage;
    public Scene scene;
    public Parent root;
  
    @FXML
    private Label byKaracaLabel;

    @FXML
    private Button exit;

    @FXML
    private Label librarySystemLabel;

    @FXML
    private Button loginButton;
    
    @FXML
    private PasswordField passwordField;
    
    public PasswordField getPass(){   
        return this.passwordField;
    }

    @FXML
    private TextField studentNumberText;
    
    public TextField getStudent(){
        return this.studentNumberText;
    }
    
    @FXML
    private Button signUpButton;
    
    @FXML
    public void switchToLogIn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    @FXML
    public void switchToSignUp(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("SignUpMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene  scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
        
     
    }
    

   @FXML
   public void exit(){
       System.exit(0);
   }
   
   public void login(ActionEvent event) throws FileNotFoundException, IOException{
       
        File Login = new File("Data.txt");
        String line;
        BufferedReader breader = new BufferedReader(new FileReader(Login));
        
        boolean a = false;
        
        while((line = breader.readLine())!=null){
            
            String[] userInfo = line.split(";");
            
            if(studentNumberText.getText().equals("admin") && passwordField.getText().equals("admin")){
                
                Parent root = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                a = false;
                break;
                
            }
            else if(userInfo[1].equals(studentNumberText.getText()) && userInfo[4].equals(passwordField.getText())){
                
                Parent root = FXMLLoader.load(getClass().getResource("Library.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                a = false;
                break;
            
            }else{
                
                a = true;
            }

        
        }
        
        if(a==true){
            
            alert.setTitle("Error");
            alert.setHeaderText("Invalid Username or Password!");
            alert.showAndWait();
            
        }
   }
   
   
   
   
@Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
