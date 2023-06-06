package de.personen.verwaltung.database;

import java.util.Date;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "person_generator" )
    @SequenceGenerator( name= "person_generator", sequenceName = "person_seq", allocationSize = 1 )

    private int id;
    private String salutation;
    private String firstName;
    private String lastName;
    private int age;
    private Date birthDate;
    private String street;
    private int houseNO;
    private int zipCode;
    private String city;
    private int telNO;
    private int mobilNO;
    private String email;
    private String generateEntry;
    
    public Person() {}
    
    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }
    
    public String getGenerateEntry() {
        return generateEntry;
    }

    public void setGenerateEntry(String generateEntry) {
        this.generateEntry = generateEntry;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSalutation() {
        return this.salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHouseNO() {
        return this.houseNO;
    }

    public void setHouseNO(int houseNO) {
        this.houseNO = houseNO;
    }

    public int getZipCode() {
        return this.zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getTelNO() {
        return this.telNO;
    }

    public void setTelNO(int telNO) {
        this.telNO = telNO;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    

    @Override
    public String toString() {
        return String.format("firstName: %s, lastName: %s, age: %s, id: %s", getFirstName(), getLastName(), getAge(), getId());
    }

    public int getMobilNO() {
        return mobilNO;
    }

    public void setMobilNO(int mobilNO) {
        this.mobilNO = mobilNO;
    }
}
