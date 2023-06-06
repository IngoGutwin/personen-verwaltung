package de.personen.verwaltung.database;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.function.Function;

public class PersonHandler {

    private SessionFactory factory;
    
    public PersonHandler() {
        try {

            Configuration config = new Configuration();
            config.configure().addAnnotatedClass(Person.class);
            System.out.println(config);

            this.factory = config.buildSessionFactory(); 
            Session session = factory.openSession();
            System.out.println(session);

        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    public void checkForTable() {
        var transAction = new TransActions<>(this.factory);
    }

    public int addPerson( Person person ) {
        var transAction = new TransActions<Integer>( this.factory );
        return transAction.commit( session -> {
            session.persist( person );
            return person.getId();
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