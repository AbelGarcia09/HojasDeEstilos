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
        //Se crea un array con el nombre de las operaciones
        String[] operaciones = {"Sumar", "Restar", "Multiplicar", "Dividir"};
        
        //Se añaden al choicebox
        choiceBox.setItems(FXCollections.observableArrayList(operaciones));
        choiceBox.getSelectionModel().select(0);
        
        //Se añaden los elementos del observableList al ListView
        listView.setItems(ol);

    }

    @FXML
    private void accionBoton(ActionEvent event) {
        
        //Se intenta convertir a "int" el texto de los textField.
        //Si se produce una excepción, salta un error pidiendo que se añadan solo números.
        try {
            double numero1 = Double.parseDouble(num1.getText());
            double numero2 = Double.parseDouble(num2.getText());
            //Se comprueba el texto del item seleccionado en el choicebox
            //Se actúa dependiendo de cual esté seleccionado
            switch (choiceBox.getSelectionModel().getSelectedItem()) {
                    case "Sumar":
                        //Se añade el resultado al Textfield y a la lista.
                        resultado.setText(""+(numero1+numero2));
                        ol.add(resultado.getText() + " (Suma)");
                        break;
                    case "Restar":
                        resultado.setText(""+(numero1-numero2));
                        ol.add(resultado.getText() + " (Resta)");
                        break;
                    case "Multiplicar":
                        resultado.setText(""+(numero1*numero2));
                        ol.add(resultado.getText() + " (Multiplicación)");
                        break;
                    case "Dividir":
                        resultado.setText(""+(numero1/numero2));
                        ol.add(resultado.getText() + " (División)");
                        break;
            }

        } catch (NumberFormatException e) {
            Alert fallo = new Alert(Alert.AlertType.ERROR);
            fallo.setHeaderText("Introduce números enteros");
            fallo.showAndWait();
        }     
        
    }
    
}
