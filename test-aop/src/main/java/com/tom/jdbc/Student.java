package com.tom.jdbc;

import com.tom.entities.IdEntity;

/**
 * Created by tom on 2016/5/5.
 */
public class Student extends IdEntity{
    private Integer age;
    private String name;
   // private Integer id;

    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    //public void setId(Integer id) {
    //    this.id = id;
   // }
   // public Integer getId() {
   //     return id;
  //  }
}
