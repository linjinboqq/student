package main.java.com.edu.lin.dao.Impl;

import main.java.com.edu.lin.dao.IStudentDao;
import main.java.com.edu.lin.model.Student;
import main.java.com.edu.lin.model.User;
import main.java.com.edu.lin.util.DBConection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentDaoImpl implements IStudentDao {
    private DBConection dbConection = null;
    private Connection con = null;
    private PreparedStatement prep = null;

    public StudentDaoImpl() {
        try {
            dbConection = new DBConection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.con = dbConection.getCon();
    }

    @Override
    public boolean insert(Student student) {
        boolean flag = false;
        String sql = "insert into student(sid,sname,sage,major) values(?,?,?,?)";
        System.out.println(student);
        int i = 0;
        try {
            this.prep = this.con.prepareStatement(sql);
            this.prep.setInt(1, student.getSid());
// this.prep.(2, student.getSex());
            this.prep.setString(2, student.getName());
            this.prep.setInt(3, student.getAge());
            this.prep.setString(4, student.getMajor());
            i = this.prep.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (i > 0) {
            flag = true;
            System.out.println("插入成功");
        }
        if (this.con != null) {
            try {
                this.prep.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return flag;
    }

    @Override
    public boolean delect(int sid) throws SQLException {
        boolean flag = false;
        String sql = "delete from student where sid=?";
        this.prep = this.con.prepareStatement(sql);
        this.prep.setInt(1, sid);
        int i = this.prep.executeUpdate();
        if (i > 0) {
            flag = true;
            System.out.println("删除成功");
        }
        if (this.con != null) {
            this.prep.close();
        }
        return flag;
    }

    //    update users set name='张无忌' where id='4'
    @Override
    public boolean update(Student student) throws SQLException {
        boolean flag = false;
        String sql = " update student set sname=?,sage=?,major=? where sid=?";
        this.prep = this.con.prepareStatement(sql);
        this.prep.setString(1, student.getName());
        this.prep.setInt(2, student.getAge());
        this.prep.setString(3, student.getMajor());
        this.prep.setInt(4, student.getSid());
        int i = this.prep.executeUpdate();
        if (i > 0) {
            flag = true;
            System.out.println("更新成功    " +
                    student);
        }
        if (this.con != null) {
            this.prep.close();
        }
        return flag;
    }

    @Override
//    SELECT * FROM student WHERE sname ='lin' and sid =1 ;
    public ArrayList<Student> select(Student student) throws SQLException {
        boolean flag = false;
        ArrayList<Student> students = new ArrayList<>();
        String sql;
        //前端会传一个空字符串
        if ("".equals(student.getName()) && student.getSid() != 0) {
            sql = " SELECT * FROM student WHERE sid =?";
            this.prep = this.con.prepareStatement(sql);
            this.prep.setInt(1, student.getSid());
        } else if (student.getName() != null && student.getSid() == 0) {
            sql = " SELECT * FROM student WHERE  sname =?";
            this.prep = this.con.prepareStatement(sql);
            this.prep.setString(1, student.getName());
        } else if (student.getName() != null && student.getSid() != 0) {
            sql = " SELECT * FROM student WHERE sname =? and sid =?";
            this.prep = this.con.prepareStatement(sql);
            this.prep.setString(1, student.getName());
            this.prep.setInt(2, student.getSid());
        } else {
            sql = " SELECT * FROM student";
        }

        ResultSet resultSet = this.prep.executeQuery();
        ResultSet rs = this.prep.executeQuery();
//手贱写成了if
        while (rs.next()) {
            Student stu = new Student();
            stu.setSid(Integer.parseInt(rs.getString(1)));
//            stu.setSex(Character.rs.getString(2));
            stu.setName(rs.getString(3));
            stu.setAge(Integer.parseInt(rs.getString(4)));
            stu.setMajor(rs.getString(5));
            System.out.println("dao查找成功" + stu);
            students.add(stu);
        }
        if (this.con != null) {
            this.prep.close();
        }
        return students;
    }
}
