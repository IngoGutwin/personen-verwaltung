package de.personen.verwaltung.database;

import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "person_generator" )
    @SequenceGenerator( name= "person_generator", sequenceName = "person_seq", allocationSize = 1 )

    private int id;
/*     private String salutation; */
    private String firstName;
    private String lastName;
    private int age;
/*     private Date birthDate;
    private String street;
    private int houseNO;
    private int zipCode;
    private String city;
    private int telNO;
    private String email; */
    
    public Person() {}

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    

/*     public String getSalutation() {
        return this.salutation; 
    }

    public void setSalutation(String salutation){
        this.salutation = salutation;
    } */

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
