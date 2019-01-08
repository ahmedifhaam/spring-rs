package com.xelvias.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class AbstractDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(T object){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(object);
        tx.commit();
        session.close();

    }

    public List<T> findAll(){
        Session session = sessionFactory.openSession();
        List<T> personList = session.createQuery("from Person").list();
        session.close();
        return personList;
    }

}
