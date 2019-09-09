package main.java.com.edu.lin.dao;

import main.java.com.edu.lin.model.User;

import java.sql.SQLException;

public interface IUserDao {
    public boolean findLogin(User user) throws SQLException;
}
