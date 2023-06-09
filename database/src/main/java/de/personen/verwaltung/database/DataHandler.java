package de.personen.verwaltung.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.function.Function;

public class DataHandler {

    private SessionFactory factory;

    public DataHandler() {
        try {
            this.factory = new Configuration().configure().addAnnotatedClass(Person.class).buildSessionFactory();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public Person addPerson(Person person ) {
        var transAction = new TransActions<Person>( this.factory );
        return transAction.commit(session -> {
            session.persist(person);
            return person;
        });
    }

    public Person getPerson(int personID ) {
        var transAction = new TransActions<Person>( this.factory );

        Function < Session, Person> function = session -> {
            return session.get( Person.class, personID );
        };

        return transAction.commit( function );
    }

    public List<Person> getAll() {
        var transAction = new TransActions< List<Person>>(this.factory);
        return transAction.commit( session -> session.createQuery("FROM Person", Person.class).list());
    }

}