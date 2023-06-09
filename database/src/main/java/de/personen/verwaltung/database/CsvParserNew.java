
package de.personen.verwaltung.database;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import java.io.IOException;
import java.nio.file.Paths;


public class CsvParserNew<T> implements Iterable <T>  {

    private Scanner scanner;
    private Path path;
    private String delimiter;

    public CsvParserNew(){}
    
    public CsvParserNew(String csvFilePath, String delimiter) throws IOException {
        this.delimiter = delimiter;
        this.path = Paths.get(csvFilePath);
        this.scanner = new Scanner(Files.newInputStream(this.path));
        if (this.scanner.hasNextLine()) this.scanner.nextLine();
    }

    @Override
    public Iterator<T> iterator() {
        return new CsvIterator();
    }

    public class CsvIterator implements Iterator<T> {

        @Override
        public boolean hasNext() {
            return scanner.hasNext();
        }
    
        @Override
        public T next() {
            return createDataModel(scanner.nextLine());
        }
        
        private T createDataModel(String csvData) {
            Person<T> person = new Person<>();
    
            List<String> data = extractValuesFromCsv(csvData);
    
            person.setId(Integer.parseInt(data.get(0)));
            person.setSalutation(data.get(1));
            person.setFirstName(data.get(2));
            person.setLastName(data.get(3));
            person.setAge(data.get(4));
            person.setStreet(data.get(5));
            person.setHouseNO(data.get(6));
            person.setZipCode(data.get(7));
            person.setCity(data.get(8));
            person.setTelNO(data.get(9));
            person.setMobilNO(data.get(10));
            person.setEmail(data.get(11));
            person.setGenerateEntry(data.get(12));
            
            return (T) person;
        
        }

        private List<String> extractValuesFromCsv(String csvValues) {
            List<String> values = new ArrayList<>();
            Scanner valueScanner = new Scanner(csvValues);
            valueScanner.useDelimiter(";");
    
            while(valueScanner.hasNext()){
                values.add(checkEmptyField(valueScanner.next()));
            }
            
            valueScanner.close();
            return values;
        }
    
        private String checkEmptyField(String entry) {
            if(entry.trim().isEmpty()) {
                return "NULL";
            }
            return entry;
        }
    }

}