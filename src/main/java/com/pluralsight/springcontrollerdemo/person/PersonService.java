package com.pluralsight.springcontrollerdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person createPerson(Person newPerson) {
        Person createdPerson = personRepository.save(newPerson);

        return  createdPerson;
    }

    public List<Person> getByMinAge(int minAge) {
        List<Person> oldPeople = this.personRepository.findByAgeGreaterThanEqual(minAge);
        return oldPeople;
    }
}
