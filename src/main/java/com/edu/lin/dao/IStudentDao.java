package main.java.com.edu.lin.dao;

import main.java.com.edu.lin.model.Student;

import java.sql.SQLException;
import java.util.ArrayList;

public interface IStudentDao {
    boolean insert (Student student) throws SQLException;
    boolean delect (int sid) throws SQLException;
    boolean update (Student student) throws SQLException;
    ArrayList<Student> select (Student student) throws SQLException;
}
