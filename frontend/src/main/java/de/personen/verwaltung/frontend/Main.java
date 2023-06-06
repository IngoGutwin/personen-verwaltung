package de.personen.verwaltung.frontend;

import de.personen.verwaltung.database.Person;
import de.personen.verwaltung.database.PersonHandler;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BorderPane borderPane = new BorderPane();
        Scene scene = new Scene(borderPane, 800, 800);
        stage.setScene(scene);
        stage.show();
        PersonTable table = new PersonTable();
        borderPane.setCenter(table);

        PersonHandler handler = new PersonHandler();

        for(Person person : handler.getAll()) {
            table.getItems().add(person);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }    
}
