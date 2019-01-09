package com.xelvias.dao;

import com.xelvias.models.Person;

import java.util.List;

public interface PersonDao {

    void save(Person object);

    public List<Person> findAll();

}
