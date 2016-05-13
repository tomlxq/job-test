package com.tom.jdbc_hibernate;

/**
 * Created by tom on 2016/5/5.
 */

import com.tom.entities.IdEntity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "TEST_PERSON")
// @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Person extends IdEntity {
    @Column(length=10)
    private String name;
    @Column
    private int age;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    public Person() {}

    public Person(String name, int age, Date birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public Date getBirthday() {
        return birthday;
    }
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}