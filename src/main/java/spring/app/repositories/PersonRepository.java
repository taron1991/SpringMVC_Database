package spring.app.repositories;

import org.hibernate.query.Query;
import spring.app.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository {


    private SessionFactory sessionFactory;

    @Autowired
    public PersonRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public PersonRepository() {
    }

    public List<Person> findAll() {
        List<Person> list;
        try (Session session = sessionFactory.openSession()) {
            session.getTransaction().begin();
            list = session.createQuery("from Person", Person.class).getResultList();
            session.getTransaction().commit();
            session.close();
        }
        return list;
    }

    public void deletePerson(int id) {
        Session session;
            session = sessionFactory.openSession();
            session.getTransaction().begin();
            Query query = session.createQuery("delete from Person where id =:id");
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
            session.close();

    }

    public void saveOrUpdate(Person person){
        Session session;
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        session.saveOrUpdate(person);
        session.getTransaction().commit();
        session.close();
    }

    public Person getPerson(int id){
        Session session;
        session = sessionFactory.openSession();
        session.getTransaction().begin();
        Person person = session.get(Person.class,id);
        session.getTransaction().commit();
        session.close();
        return person;
    }
}
