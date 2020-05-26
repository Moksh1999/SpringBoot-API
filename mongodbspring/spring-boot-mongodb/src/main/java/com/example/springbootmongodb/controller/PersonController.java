package com.example.springbootmongodb.controller;

import com.example.springbootmongodb.model.Person;
import com.example.springbootmongodb.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*")
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(path="/create", method = RequestMethod.POST)
    public String create(@RequestBody Person person)
    {
        personService.create(person);
        return ("Hi, " + person.getFirstName() + " " + person.getLastName() + " you have been registered successfully!");

    }

    @RequestMapping("/create")
    public String create(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        Person p = personService.create(firstName, lastName, age);
        return p.toString();
    }

    @RequestMapping("/get")
    public Person getPerson(@RequestParam String firstName) {
        return personService.findByFirstName(firstName);
    }

    @RequestMapping("/getAll")
    public List<Person> getAllPerson() {
        return personService.getAll();
    }

    @RequestMapping("/update")
    public String update(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int age) {
        Person p = personService.update(firstName, lastName, age);
        return p.toString();
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam String firstName) {
        personService.delete(firstName);
        return "Deleted " + firstName;
    }

    @RequestMapping("/deleteAll")
    public String deleteAll() {
        personService.deleteAll();
        return "Deleted All Records!";
    }
}