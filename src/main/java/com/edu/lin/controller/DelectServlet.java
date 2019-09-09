package main.java.com.edu.lin.controller;

import main.java.com.edu.lin.dao.Impl.StudentDaoImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class DelectServlet  extends HttpServlet {

    private boolean delect;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stdNumber = req.getParameter("stdNumber");
        int i = Integer.parseInt(stdNumber);
        StudentDaoImpl studentDao=new StudentDaoImpl();
        try {
            delect = studentDao.delect(i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(delect){
            System.out.println("Ñ§ºÅ:"+stdNumber+"É¾³ý³É¹¦");
            req.getRequestDispatcher("success/delectsuccess.jsp").forward(req,resp);

        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req,resp);
    }
}
