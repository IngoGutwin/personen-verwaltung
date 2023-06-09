package de.personen.verwaltung.database;

import java.io.IOException;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class DataBaseTest {
    private final DataHandler pHandler = new DataHandler();

    @Test
    public void addOnePersonTest() {
        Person person = new Person("Herr", "Ingo", "Gutwin", "38", "Im Gesetz 3", "4", "54234", "Bonn", "234234234234", "23423424", "email@com", "11.12.1222");
        pHandler.addPerson(person);
    }
    @Test
    void addDataFromFileTest() throws IOException {
        CsvParserNew<Person> csvParser = new CsvParserNew<>(
                "/home/lone/Documents/code/java/personen-verwaltung/export.csv",
                ";"
            );

        while (csvParser.iterator().hasNext()) {
            Person person = csvParser.iterator().next();
            Person newPerson = new Person<>(
                    person.getSalutation(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAge(),
                    person.getStreet(),
                    person.getHouseNO(),
                    person.getZipCode(),
                    person.getCity(),
                    person.getTelNO(),
                    person.getMobilNO(),
                    person.getEmail(),
                    person.getGenerateEntry()
            );
            pHandler.addPerson(newPerson);

        }

/*         for (Person person : csvParser) {
            Person newPerson = new Person(
                    person.getSalutation(),
                    person.getFirstName(),
                    person.getLastName(),
                    person.getAge(),
                    person.getStreet(),
                    person.getHouseNO(),
                    person.getZipCode(),
                    person.getCity(),
                    person.getTelNO(),
                    person.getMobilNO(),
                    person.getEmail(),
                    person.getGenerateEntry()
            );
            pHandler.addPerson(newPerson);
        }  */
    }

}
