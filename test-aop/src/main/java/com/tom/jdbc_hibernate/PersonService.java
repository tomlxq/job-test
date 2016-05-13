package com.tom.jdbc_hibernate;

import java.util.List;

/**
 * Created by tom on 2016/5/5.
 */
public interface PersonService {

    Person findById(long id);

    void savePerson(Person employee);

    void updatePerson(Person employee);

    void deletePersonById(long id);

    List<Person> findAllPersons();

    Person findPersonByName(String name);

}