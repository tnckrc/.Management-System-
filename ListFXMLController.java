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
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author tnckr
 */
public class ListFXMLController implements Initializable {
    
    File file = new File("Data.txt");
    File file2 = new File("tempData.txt");
    
    public Stage stage;
    public Scene scene;
    public Parent root;
    
    @FXML
    private ListView<String> list;

    @FXML
    private Button exit;
    
    @FXML
    private TextField deleteNumber;
    
    @FXML
    private Button deleteButton;
    
    @FXML
    private Button switchToAdminScreenBut;
    
    @FXML
    void deletePerson(ActionEvent event) {
        
        Path source = Paths.get("tempData.txt");
        
        try{
        SignUpMenuController controller = new SignUpMenuController();
        
        BufferedReader breader = new BufferedReader(new FileReader(file));
        BufferedWriter bwriter = new BufferedWriter(new FileWriter(file2, true));
        
        String line;
        
        while((line = breader.readLine()) != null){
            
            String[] userArray = line.split(";");
            
            if(!line.startsWith(deleteNumber.getText())){
                
                bwriter.write(line + "\n");
            }
        }
        
        bwriter.close();
        breader.close();
        
        (file).delete();
	(file2).renameTo(file);
        
        String linez;
        String data[];
        
        File file = new File("Data.txt");
        Scanner scanner = new Scanner(file);
        
        while(scanner.hasNextLine()){
            linez = scanner.nextLine();
            list.getItems().add(linez);
        }
            
        } catch (Exception e){
            
            System.out.println(":" + e);
        }
    }
    
    @FXML
    void switchToAdminScreen(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene  scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

  
    
    public void LoadFiles() throws FileNotFoundException{
        
        String line;
        String data[];
        
        File file = new File("Data.txt");
        Scanner scanner = new Scanner(file);
        
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            list.getItems().add(line);
        }
    }  
    
   
    
    
   @FXML
   public void exit(){
       System.exit(0);
   }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            LoadFiles();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
    
}
