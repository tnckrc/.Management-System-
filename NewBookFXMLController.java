import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class NewBookFXMLController {
    
    public Stage stage;
    public Scene scene;
    public Parent root;

    @FXML
    private Button addNewBookButton;

    @FXML
    private Button backToAdminButton;

    @FXML
    private TextField bookNameField;

    @FXML
    private Label bookNameLabel;

    @FXML
    private Label errorLabel;

    @FXML
    private Button exit;

    @FXML
    private TextField publishedYear;

    @FXML
    private Label publishedYearLabel;

    @FXML
    private TextField publisherField;

    @FXML
    private Label publisherLabel;

    @FXML
    void addNewBook(ActionEvent event) {
        
       StringBuilder st = new StringBuilder();
       st.append(bookNameField.getText());
       st.append(";");
       st.append(publisherField.getText());
       st.append(";");
       st.append(publishedYear.getText());
       
       
       
       String data = new String(st);
       

       if(bookNameField.getText().isEmpty() || publisherField.getText().isEmpty()|| publishedYear.getText().isEmpty()){
          errorLabel.setText("Bilgiler Boş Bırakılmamalı");
       } 
       else{
            try {
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter("Books.txt", true));
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
    void backToAdmin(ActionEvent event) throws IOException {
        
        Parent root = FXMLLoader.load(getClass().getResource("AdminFXML.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene  scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void errorLabel(MouseEvent event) {

    }

    @FXML
    void exit(ActionEvent event) {
        
         System.exit(0);

    }

}
