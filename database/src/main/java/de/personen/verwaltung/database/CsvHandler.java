package de.personen.verwaltung.database;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.Scanner;

import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;


public class CsvHandler implements Iterable < Person > {

    private Scanner scanner;
    private Path path;

    public CsvHandler(){}
    
    public CsvHandler(String csvFilePath) throws IOException {
        this.path = Paths.get(csvFilePath);
    }
    
    public void readFile() throws IOException {
        this.scanner = new Scanner(Files.newInputStream(this.path));
        while (this.iterator().hasNext()) {
            System.out.println(this.scanner.nextLine());
        }
    }

   

    private Person createNewPerson(String personData) {
        return null;
    }

    @Override
    public Iterator<Person> iterator() {
        try {
            this.scanner = new Scanner(Files.newInputStream(this.path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        return new Iterator<>() {

            @Override
            public boolean hasNext() {
                return scanner.hasNextLine();
            }

            @Override
            public Person next() {
                return createNewPerson(scanner.nextLine());
            }

        };
    }
}