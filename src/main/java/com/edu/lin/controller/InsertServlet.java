package main.java.com.edu.lin.controller;

import main.java.com.edu.lin.dao.Impl.StudentDaoImpl;
import main.java.com.edu.lin.dao.Impl.UserDaoImpl;
import main.java.com.edu.lin.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "InsertServlet")
public class InsertServlet extends HttpServlet {

    private boolean insert;
    String  info;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("gbk");
        String name = request.getParameter("name");
        char[] genders = request.getParameter("gender").toCharArray();
        int age = Integer.parseInt(request.getParameter("age"));
        int stdNumber = Integer.parseInt(request.getParameter("stdNumber"));
        String major = request.getParameter("major");
        Student student=new Student(stdNumber,genders[0],name,age,major);
        StudentDaoImpl studentDao=new StudentDaoImpl();
        try {
            insert = studentDao.insert(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(insert){
            System.out.println("servlet 插入成功");
            info="servlet 插入成功";
            request.setAttribute("Iinfo",info);
           request.getRequestDispatcher("success/insertsuccess.jsp").forward(request,response);
        }else {
            info="插入失败 请重新输入";
            request.setAttribute("Iinfo",info);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
