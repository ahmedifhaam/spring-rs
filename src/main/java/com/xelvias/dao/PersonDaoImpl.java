package com.xelvias.dao;

import com.xelvias.models.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class PersonDaoImpl implements PersonDao{

    @Autowired
    private SessionFactory sessionFactory;

    public void save(Person object){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(object);
        tx.commit();
        session.close();

    }

    public List<Person> findAll(){
        Session session = sessionFactory.openSession();
        List<Person> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }
}
