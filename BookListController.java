import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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

public class BookListController implements Initializable {
    
    
    
    public Stage stage;
    public Scene scene;
    public Parent root;

    @FXML
    private Button exit;

    
    
    @FXML
    private ListView<String> list;

    @FXML
    private Button switchToAdminScreenBut;

    @FXML
    void exit(ActionEvent event) {
        System.exit(0);
        
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
        
        File file = new File("Books.txt");
        Scanner scanner = new Scanner(file);
        
        while(scanner.hasNextLine()){
            line = scanner.nextLine();
            list.getItems().add(line);
            
            
        }
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

