package com.xelvias.services;

import com.xelvias.dao.PersonDao;
import com.xelvias.models.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PersonService implements IPersonService {
    @Autowired
    PersonDao personDao;

    public List<Person> getAllPersons(){
        return personDao.findAll();
    }

    public void save(Person person){
        personDao.save(person);
    }
}
