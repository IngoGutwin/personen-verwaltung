package de.personen.verwaltung.database;

import java.io.IOException;

import org.junit.jupiter.api.Test;

public class DataBaseTest {
    private final DataHandler pHandler = new DataHandler();

    @Test
    void addDataFromFileTest() throws IOException {
        CsvParser csvParser = new CsvParser(
                "/home/lone/Documents/code/java/personen-verwaltung/export.csv",
                ";"
            );

        for (Person person : csvParser) {
        
            Person newPerson = new Person(); 

            newPerson.setAge(person.getAge());
            newPerson.setCity(person.getCity());
            newPerson.setEmail(person.getEmail());
            newPerson.setFirstName(person.getFirstName());;
            newPerson.setLastName(person.getLastName());
            newPerson.setGenerateEntry(person.getGenerateEntry());
            newPerson.setHouseNO(person.getHouseNO());
            newPerson.setMobilNO(person.getMobilNO());
            newPerson.setSalutation(person.getSalutation());
            newPerson.setStreet(person.getStreet());
            newPerson.setTelNO(person.getTelNO());
            newPerson.setZipCode(person.getZipCode());


            pHandler.addPerson(newPerson);
        }
    }

}
