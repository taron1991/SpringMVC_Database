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


    public List<Person> findAll(){
        List<Person> list;
        try (Session session =  sessionFactory.openSession()){
            session.getTransaction().begin();
            list = session.createQuery("from Person", Person.class).getResultList();
        }
        return list;
    }
}
