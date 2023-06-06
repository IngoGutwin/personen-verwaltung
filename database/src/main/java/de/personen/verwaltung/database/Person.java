package de.personen.verwaltung.database;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "person_generator" )
    @SequenceGenerator( name= "person_generator", sequenceName = "person_seq", allocationSize = 1 )

    private int id;
    private String firstName;
    private String lastName;
    private int age;
    
    public Person() {}

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("firstName: %s, lastName: %s, age: %s, id: %s", getFirstName(), getLastName(), getAge(), getId());
    }
}
