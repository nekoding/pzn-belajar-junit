package com.nekoding.belajar.junit.services;

import com.nekoding.belajar.junit.data.Person;
import com.nekoding.belajar.junit.repositories.PersonRepository;

public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(Integer id) {
        var person = personRepository.find(id);
        if (person == null) {
            throw new IllegalArgumentException("Person not found");
        }

        return person;
    }
}
