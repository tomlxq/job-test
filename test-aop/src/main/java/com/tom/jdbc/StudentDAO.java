package com.tom.jdbc;

/**
 * Created by tom on 2016/5/5.
 */
import java.util.List;
import javax.sql.DataSource;

public interface StudentDAO {
    /**
     * 设置数据源
     */
    public void setDataSource(DataSource ds);
    public void createTable();
    /**
     * 创建一个学生
     */
    public void create(String name, Integer age);
    /**
     * 查询一个学生
     */
    public Student getStudent(Integer id);
    /**
     * 查询学生列表
     */
    public List<Student> listStudents();
    /**
     * 删除一个学生
     */
    public void delete(Integer id);
    /**
     * 更新一个学生
     */
    public void update(Integer id, Integer age);
}