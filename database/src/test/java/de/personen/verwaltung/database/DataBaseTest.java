package de.personen.verwaltung.database;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

class DataBaseTest {
    private final PersonHandler handler = new PersonHandler();

    @Test
    void addPersonTest(){
        for (int i = 1; i < 40; i++) {
            Person person = new Person("Ingo"+i, "Gutwin"+i, 38);
            handler.addPerson(person);
            System.out.println(person.getId());
        }
    }

    @Test
    void addOnePersonTest(){
        Person person = new Person("Medi", "Niwtug", 38);
        handler.addPerson(person);
        System.out.println(person.getId());
    }

    @Test
    void readDataFromFileTest() throws IOException{
        Path sqlFilePath = Paths.get("/home/lone/Documents/code/java/personen-verwaltung/export_adressen.sql");
    }
}
