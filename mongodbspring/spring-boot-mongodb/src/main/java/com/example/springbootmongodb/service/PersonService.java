package com.example.springbootmongodb.service;

import com.example.springbootmongodb.model.Person;
import com.example.springbootmongodb.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    //CreateOperation
    public Person create(String firstName, String lastName, int age) {
        return personRepository.save(new Person(firstName, lastName, age));
    }

    public String create(Person person) {
        personRepository.save(person);
        return ("Hi, " + person.getFirstName() + " " + person.getLastName() + " you have been registered successfully!");
    }

    //RetrieveOperation
    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person findByFirstName(String firstName) {
        return personRepository.findByFirstName(firstName);
    }

    //UpdateOperation
    public Person update(String firstName, String lastName, int age) {
        Person p = personRepository.findByFirstName(firstName);
        p.setLastName(lastName);
        p.setAge(age);
        return personRepository.save(p);
    }

    //DeleteOperation
    public void deleteAll() {
        personRepository.deleteAll();
    }

    public void delete(String firstName) {
        Person p = personRepository.findByFirstName(firstName);
        personRepository.delete(p);
    }
}