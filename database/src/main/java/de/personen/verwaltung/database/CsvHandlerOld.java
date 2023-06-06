package de.personen.verwaltung.database;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

public class CsvHandlerOld implements Iterable < Person >,  Iterator < Person > {

    private Scanner scanner;
    private String  delimiter;

    public CsvHandlerOld( Path csvFilePath ) throws IOException {
        this( csvFilePath, ";");
    }

    public CsvHandlerOld( Path csvFilePath, String delimiter ) throws IOException {
        this.delimiter = delimiter;
        this.scanner = new Scanner( Files.newInputStream( csvFilePath ) ) ;
        if( this.scanner.hasNextLine() )this.scanner.nextLine();
    }

    @Override
    public Iterator<Person> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return this.scanner.hasNextLine();
    }

    @Override
    public Person next() {
        return this.newDataModel( this.scanner.nextLine() ) ;
    }

    private Person  newDataModel( String line ) {

        Person p = new Person();

        String[] v = this.createValues( line );

//        p.setId         ( Integer.parseInt( v[0] ) );
      /*  p.setAnrede     ( v[1] );
        p.setVorname    ( v[2] );
        p.setNachname   ( v[3] );
//        DateTimeFormatter date = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate.from( date.parse("15.08.2014") );
        p.setGebDat     ( v[4] );
        p.setStrasse    ( v[5] );
        p.setHausNr     ( v[6] );
        p.setPlz        ( Integer.parseInt( v[7] ) );
        p.setOrt        ( v[8] );
        p.setTel        ( v[9] );
        p.setEmail      ( v[10] );*/

        return  p;
    }

    private String[] createValues( String line ) {
        String[] values = new String[11];
        Scanner ls = new Scanner( line );
        ls.useDelimiter( this.delimiter );
        int i = 0;
        while( ls.hasNext() ) {
            values[i] = this.createToken( ls.next() );
//            System.out.println( i + " " + values[i]);
            i++;
        }
        return  values;
    }

    private String createToken( String token ) {

        if( token.trim().isEmpty() )return "NULL";
        return token;
//        return "\""+token+"\"";
    }

}
