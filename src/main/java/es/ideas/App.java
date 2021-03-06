package es.ideas;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Stage escena;

    @Override
    public void start(Stage stage) throws IOException {
        
        App.escena = stage;

        FXMLLoader loader = new FXMLLoader();
        //Localización de la interfaz
        loader.setLocation(getClass().getResource("primary.fxml"));

        Parent raiz = loader.load();
        
        Scene scene = new Scene(raiz);
        stage.setScene(scene);
        //Tamaño fijo
        stage.setResizable(false);
        stage.setTitle("Operaciones básicas");
        stage.show();
        
    }

    public static void main(String[] args) {
        launch();
    }

}