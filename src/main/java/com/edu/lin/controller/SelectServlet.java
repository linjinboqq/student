package main.java.com.edu.lin.controller;

import main.java.com.edu.lin.dao.Impl.StudentDaoImpl;
import main.java.com.edu.lin.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(name = "SelectServlet")
public class SelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        int stdNumber=0;
        if(request.getParameter("stdNumber")!=""){
             stdNumber = Integer.valueOf(request.getParameter("stdNumber"));
        }
        String name = request.getParameter("name");
        Student student = new Student();
        student.setSid(stdNumber);
        student.setName(name);
        System.out.println(student);
        try {
            ArrayList<Student> stus = new StudentDaoImpl().select(student);
            request.setAttribute("stus",stus);
            //这里开始写成了客户端跳转
            //前后两个request不是同一个request
           request.getRequestDispatcher("success/selectsuccess.jsp").forward(request,response);
            System.out.println( "servlet查询");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
