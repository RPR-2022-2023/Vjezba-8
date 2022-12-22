package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class DrugiProzorController {
    public Label imeId;
    public Label prezimeId;
    public Button okBttn;
    private String ime, prezime;

    public DrugiProzorController(String ime, String prezime) {
      this.ime=ime;
      this.prezime=prezime;
    }

    @FXML
    public void initialize(){
        imeId.setText(ime);
        prezimeId.setText(prezime);
    }

    public void okAction(ActionEvent actionEvent) {
        Stage stage = (Stage) imeId.getScene().getWindow();
        stage.close();
    }

    public List<String> vratiPodatke(){
        List<String> lista = new ArrayList<>();
        lista.add(imeId.getText());
        lista.add(prezimeId.getText());
        return lista;
    }
}
