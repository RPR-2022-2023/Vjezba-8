package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.controllers.DrugiProzorController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class SampleController {
    public ListView<String> listView;
    public TextField imePrezime;
    public Label neispravnoImeId;
    public TextField prezimeId;
    public Label neispravnoPrezimeId;
    public Button okBttn;
    public TextField imeId;
    public TextField usernameId;
    @FXML
    public void initialize(){
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue)->{
            usernameId.setText(listView.getSelectionModel().getSelectedItem().toString());
        });

        imeId.textProperty().addListener((obs, oldValue, newValue)->{
            // System.out.println("Stara vrijednost: " + oldValue + " Nova vrijednost: "+ newValue);
            if(newValue.length()>=5)
                neispravnoImeId.setText("");
            else
                neispravnoImeId.setText("Neispravno ime!");
        });
    }

    public void okAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/dodatniProzor.fxml"));
      //  Parent root = FXMLLoader.load(getClass().getResource("/fxml/dodatniProzor.fxml"));
        DrugiProzorController controller = new DrugiProzorController(imeId.getText(), prezimeId.getText());
        loader.setController(controller);
        stage.setTitle("Hello, World!");
        stage.setScene(new Scene(loader.load(), 300, 275));
        stage.show();

        stage.setOnHiding(x->{
            List<String> lista = controller.vratiPodatke();
            listView.getItems().addAll(FXCollections.observableList(lista));
        });
    }

    public SampleController() {

    }

}
