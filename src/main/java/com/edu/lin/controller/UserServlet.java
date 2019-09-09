package main.java.com.edu.lin.controller;

import main.java.com.edu.lin.dao.IUserDao;
import main.java.com.edu.lin.dao.Impl.UserDaoImpl;
import main.java.com.edu.lin.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uid= request.getParameter("uuid");
        String password=request.getParameter("passwd");
        User user = new User(1, uid, password);
        boolean result = false;
        try {
            result = new UserDaoImpl().findLogin(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(result){
            //��½�ɹ�
            //�������ת
            request.getSession().setAttribute("userid",uid);
//            response.sendRedirect("index.jsp");
            request.getRequestDispatcher("index.jsp").forward(request,response);
            System.out.println("��½�ɹ�");
        }else {
            //�ͻ�����ת
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
