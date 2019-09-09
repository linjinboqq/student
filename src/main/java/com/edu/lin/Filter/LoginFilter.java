package main.java.com.edu.lin.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebFilter(filterName = "LoginFilter")
public class LoginFilter implements Filter {

    private String sessionKey;
    private String redirectUrl;
    private String uncheckedUrls;


    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String uri = request.getRequestURI();

        //这里还要排除一些静态资源
        if(uri.contains("login.jsp")||uri.contains("user")){
            //想登陆
            chain.doFilter(req, resp);
        }else {
            Object userid = request.getSession().getAttribute("userid");
            if(userid!=null){
                chain.doFilter(req, resp);
            }else {
                req.setAttribute("loginsta","您尚未登陆 请先登陆");
                req.getRequestDispatcher("/login.jsp").forward(req,resp);
            }

        }

        HttpServletResponse response=(HttpServletResponse)resp ;
        HttpSession session = request.getSession();
        if(session.getAttribute("userid")!=null){
            chain.doFilter(req, resp);
        }else {
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }
    public void init(FilterConfig config) throws ServletException {
        ServletContext servletContext = config.getServletContext();


    }

}
