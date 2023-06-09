package de.personen.verwaltung.database;

import jakarta.persistence.*;

@Entity
public class Person<T> {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "person_generator" )
    @SequenceGenerator( name= "person_generator", sequenceName = "person_seq", allocationSize = 1 )



    private int Id;
    private String salutation;
    private String firstName;
    private String lastName;
    private String age;
    private String street;
    private String houseNO;
    private String zipCode;
    private String city;
    private String telNO;
    private String mobilNO;
    private String email;
    private String generateEntry;

    public Person() {}

    public Person(String salutation, String firstName, String lastName, String age, String street, String houseNO, String zipCode, String city, String telNO, String mobilNO, String email, String generateEntry) {
        this.salutation = salutation;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.street = street;
        this.houseNO = houseNO;
        this.zipCode = zipCode;
        this.city = city;
        this.telNO = telNO;
        this.mobilNO = mobilNO;
        this.email = email;
        this.generateEntry = generateEntry;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNO() {
        return houseNO;
    }

    public void setHouseNO(String houseNO) {
        this.houseNO = houseNO;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelNO() {
        return telNO;
    }

    public void setTelNO(String telNO) {
        this.telNO = telNO;
    }

    public String getMobilNO() {
        return mobilNO;
    }

    public void setMobilNO(String mobilNO) {
        this.mobilNO = mobilNO;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenerateEntry() {
        return generateEntry;
    }

    public void setGenerateEntry(String generateEntry) {
        this.generateEntry = generateEntry;
    }

    @Override
    public String toString() {
        return String.format("firstName: %s, lastName: %s, age: %s, id: %s", getFirstName(), getLastName(), getAge(), getId());
    }
}
