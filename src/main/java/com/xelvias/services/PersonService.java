package com.xelvias.services;

import com.xelvias.models.Person;

import java.util.List;

public interface PersonService {
    void save(Person person);
    List<Person> getAllPersons();
}
