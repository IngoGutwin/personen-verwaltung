module de.personen.verwaltung.database {

    requires jakarta.persistence;
    requires transitive org.hibernate.orm.core;
    requires java.naming;

    opens de.personen.verwaltung.database to org.hibernate.orm.core;
    exports de.personen.verwaltung.database;
}