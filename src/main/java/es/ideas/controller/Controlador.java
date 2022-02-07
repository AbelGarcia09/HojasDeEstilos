/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package es.ideas.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author Abel
 */
public class Controlador implements Initializable {

    @FXML
    private TextField num1;
    @FXML
    private TextField num2;
    @FXML
    private ChoiceBox<String> choiceBox;
    @FXML
    private TextField resultado;
    @FXML
    private ListView<String> listView;
    private ObservableList<String> ol = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String[] operaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        
        choiceBox.setItems(FXCollections.observableArrayList(operaciones));
        choiceBox.getSelectionModel().select(0);
        
        listView.setItems(ol);

    }

    @FXML
    private void accionBoton(ActionEvent event) {
        
        try {
            int numero1 = Integer.parseInt(num1.getText());
            int numero2 = Integer.parseInt(num2.getText());
            
            switch (choiceBox.getSelectionModel().getSelectedItem()) {
                    case "Sumar":
                        resultado.setText(""+(numero1+numero2));
                        break;
                    case "Restar":
                        resultado.setText(""+(numero1-numero2));
                        break;
                    case "Multiplicar":
                        resultado.setText(""+(numero1*numero2));
                        break;
                    case "Dividir":
                        resultado.setText(""+(numero1/numero2));
                        break;
            }
            ol.add(resultado.getText());
        } catch (NumberFormatException e) {
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText("Introduce números enteros");
            fallo.showAndWait();
        }     
        
    }
    
}
