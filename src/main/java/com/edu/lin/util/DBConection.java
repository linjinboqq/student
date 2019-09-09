package main.java.com.edu.lin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConection {
    public static final String URL = "jdbc:mysql://localhost:3306/blog";
    public static final String USER = "root";
    public static final String PASSWORD = "Aa123123";
    private Connection con = null;

    public DBConection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.con = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public Connection getCon() {
        return this.con;
    }

    public void close() throws Exception {
        if (this.con != null) {
            this.con.close();
        }
    }
//测试用的
    public static void main(String[] args) throws Exception {
//      端口被占用  20264  java.exe   20264 Console   17,264 K
        //1.加载驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM user ");
        //如果有数据，rs.next()返回true
        while (rs.next()) {
            System.out.println(rs.getString("uname") + " 年龄：" + rs.getInt("upassword"));
        }
    }
}
