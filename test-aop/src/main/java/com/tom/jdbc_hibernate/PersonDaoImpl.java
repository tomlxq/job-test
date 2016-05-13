package com.tom.jdbc_hibernate;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tom on 2016/5/5.
 */
@Repository("personDao")
public class PersonDaoImpl extends AbstractDao<Integer, Person> implements PersonDao {

    public Person findById(Long id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        return (Person) criteria.uniqueResult();
    }

    public void savePerson(Person employee) {
        persist(employee);
    }

    public void deletePersonById(Long id) {
        Query query = getSession().createSQLQuery("delete from Person where id = :id");
        query.setLong("id", id);
        query.executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Person> findAllPersons() {
        Criteria criteria = createEntityCriteria();
        return (List<Person>) criteria.list();
    }

    public Person findPersonByName(String name) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("name", name));
        return (Person) criteria.uniqueResult();
    }
}