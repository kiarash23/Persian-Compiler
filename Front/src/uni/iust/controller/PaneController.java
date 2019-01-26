package uni.iust.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import uni.iust.Service.ApiService;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by Kiarash23 on 12/26/2018.
 */
public class PaneController implements Initializable {

    @FXML
    TextArea englishTextArea;
    @FXML
    TextArea persianTextArea;
    @FXML
    Button runButt;
    @FXML
    Button clearButt;
    @FXML
    ComboBox combo;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        persianTextArea.setText("");
        englishTextArea.setText("");
        combo.getItems().setAll("English to Persian", "Persian to English");
        runOnClick();
        clearOnClick();
    }

    public void runOnClick(){
        runButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (combo.getSelectionModel().getSelectedItem().toString() == "English to Persian"){
                    FileController.writeEnglish(englishTextArea.getText() + " ");
                    ApiService.send(2); //english
                    persianTextArea.setText(ApiService.receive());
                }
                if (combo.getSelectionModel().getSelectedItem().toString() == "Persian to English"){
                    FileController.writePersian(persianTextArea.getText() + " ");
                    ApiService.send(1); //persian
                    englishTextArea.setText(ApiService.receive());
                }
            }
        });
    }
    public void clearOnClick(){
        clearButt.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                persianTextArea.setText("");
                englishTextArea.setText("");
            }
        });
    }
}
