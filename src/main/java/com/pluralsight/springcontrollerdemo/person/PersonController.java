package com.pluralsight.springcontrollerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/api/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public Person createPerson(@RequestBody Person newPerson) {

        Person createdPerson = this.personService.createPerson(newPerson);

        return createdPerson;
    }

    @GetMapping("/api/persons")
    public List<Person> getByMinAge(@RequestParam int minAge) {
        return this.personService.getByMinAge(minAge);
    }
}
