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
//�����õ�
    public static void main(String[] args) throws Exception {
//      �˿ڱ�ռ��  20264  java.exe   20264 Console   17,264 K
        //1.������������
        Class.forName("com.mysql.jdbc.Driver");
        //2. ������ݿ�����
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.�������ݿ⣬ʵ����ɾ�Ĳ�
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM user ");
        //��������ݣ�rs.next()����true
        while (rs.next()) {
            System.out.println(rs.getString("uname") + " ���䣺" + rs.getInt("upassword"));
        }
    }
}
