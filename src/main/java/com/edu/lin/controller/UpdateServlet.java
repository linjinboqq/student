package main.java.com.edu.lin.controller;

import main.java.com.edu.lin.dao.Impl.StudentDaoImpl;
import main.java.com.edu.lin.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet")
public class UpdateServlet extends HttpServlet {

    private boolean update;

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
            update = studentDao.update(student);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(update){
            System.out.println("update≤Â»Î≥…π¶");
            request.getRequestDispatcher("success/updatesuccess.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
