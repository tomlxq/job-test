package com.tom.jdbc_hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by tom on 2016/5/5.
 */
@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {
    @Autowired
    private PersonDao dao;
    @Override
    public Person findById(long id) {
        return dao.findById(id);
    }

    @Override
    public void savePerson(Person employee) {
        dao.savePerson(employee);
    }

    @Override
    public void updatePerson(Person employee) {
        dao.savePerson(employee);
    }

    @Override
    public void deletePersonById(long id) {

    }

    @Override
    public List<Person> findAllPersons() {
        return null;
    }

    @Override
    public Person findPersonByName(String name) {
        return null;
    }
}
