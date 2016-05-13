package com.tom.jdbc_hibernate;

import java.util.List;

/**
 * Created by tom on 2016/5/5.
 */
public interface PersonDao {

    Person findById(Long id);

    void savePerson(Person Person);

    void deletePersonById(Long id);

    List<Person> findAllPersons();

    Person findPersonByName(String name);

}