import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class UserBookListController implements Initializable {

    @FXML
    private ListView<String> list;

    @FXML
    void list(ActionEvent event) {
        

    }
    
    @FXML
    void exit(ActionEvent event) {
    System.exit(0);
    }
    
    @FXML
    private Button exit;
    
    
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
    
    public void initialize(URL url, ResourceBundle rb) {
        try {
            LoadFiles();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ListFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
    


