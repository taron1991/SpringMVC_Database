package spring.app.services;


import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import spring.app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.app.repositories.PersonRepository;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }


    public void deletePerson(int id){
         personRepository.deletePerson(id);
    }

    public void saveOrUpdate(Person person){
        personRepository.saveOrUpdate(person);
    }

    public Person getPerson(int id){
        Person person = personRepository.getPerson(id);
        return person;
    }


    public List<Person> showPersonLess(int param){
        List<Person> person = personRepository.showLess(param);
        return person;
    }


    public List<Person> showPersonMore(int param){
        List<Person> person = personRepository.showMore(param);
        return person;
    }


}
