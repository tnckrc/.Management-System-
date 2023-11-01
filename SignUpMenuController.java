/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class SignUpMenuController implements Initializable {
    
    public Stage stage;
    public Scene scene;
    public Parent root;
    
   
            
    @FXML
    private Label errorLabel;
    
    @FXML
    private TextField email;
    
    public TextField getEmail(){   
        return this.email;
    }

    @FXML
    private Label emailLabel;

    @FXML
    private TextField fullName;
    
    public TextField getFullName(){   
        return this.fullName;
    }

    @FXML
    private PasswordField passwordSign;
    
    public PasswordField getPass(){   
        return this.passwordSign;
    }

    @FXML
    private Button signUp;

    @FXML
    private Label tcLabel;

    @FXML
    private TextField tcNumber;
    
    public TextField getTc(){   
        return this.tcNumber;
    }

    @FXML
    private Label userNameLabel;

    @FXML
    private TextField userNameSign;
    
     public TextField getUserName(){   
        return this.userNameSign;
    }

    @FXML
        
     public void signUp(ActionEvent event){
       
       StringBuilder st = new StringBuilder();
       st.append(fullName.getText());
       st.append(";");
       st.append(userNameSign.getText());
       st.append(";");
       st.append(tcNumber.getText());
       st.append(";");
       st.append(email.getText());
       st.append(";");
       st.append(passwordSign.getText());
       
       
       
       String data = new String(st);
       

       if(fullName.getText().isEmpty() || userNameSign.getText().isEmpty()|| tcNumber.getText().isEmpty() || email.getText().isEmpty() || passwordSign.getText().isEmpty()){
          errorLabel.setText("Bilgiler Boş Bırakılmamalı");
       } 
       else{
            try {
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter("Data.txt", true));
            writer.append(data);
            writer.newLine();
            
            errorLabel.setText("Kayıt Basarili");
            
            writer.close();
            } 
            catch (IOException e) {
            throw new RuntimeException(e);
            }
       }
       
       
   }
     
        @FXML
    public void switchtologin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("LoginMenu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
       
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    }
    
    
    

  
    

