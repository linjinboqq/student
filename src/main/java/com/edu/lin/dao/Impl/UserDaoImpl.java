package main.java.com.edu.lin.dao.Impl;

import main.java.com.edu.lin.dao.IUserDao;
import main.java.com.edu.lin.model.User;
import main.java.com.edu.lin.util.DBConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements IUserDao {
    DBConection dbConection = null;
    private Connection con = null;
    private PreparedStatement prep = null;

    public UserDaoImpl() {
        try {
            dbConection = new DBConection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.con = dbConection.getCon();
    }

    @Override
    public boolean findLogin(User user) throws SQLException {
        boolean flag = false;
        String sql = "select uname from user where uname=? and upassword=?";
        this.prep = this.con.prepareStatement(sql);
        System.out.println(user);
        this.prep.setString(1, user.getName());
        this.prep.setString(2, user.getPassword());
        ResultSet rs = this.prep.executeQuery();
        if (rs.next()) {
            user.setName(rs.getString(1));
            flag = true;
            System.out.println("·µ»Øtrue");
        }
        if (this.con != null) {
            this.prep.close();
        }
        return flag;
    }
}
