package spring.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "persondata")
@Data
@Cacheable
@AllArgsConstructor
public class Person {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id")
private int id;

@Column(name = "name")
private String name;

@Column(name = "age")
private int age;

    public Person() {
    }
}
