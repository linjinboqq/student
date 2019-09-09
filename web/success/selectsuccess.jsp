<%@ page import="main.java.com.edu.lin.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: 24353
  Date: 2019/9/9
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询结果</title>
</head>
<body>

<table>
    <thead>
    <caption>查询结果</caption>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>性别</th>
        <th>学号</th>
        <th>专业</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <%
    List<Student> students ;
    students = (List) request.getAttribute("stus");
    Iterator iterator = students.iterator();
    while (iterator.hasNext()) {
    pageContext.setAttribute("stu", iterator.next());
    %>
    <tr>
        <td>${stu.name}</td>
        <td>${stu.age}</td>
        <td>${stu.sex}</td>
        <td>${stu.sid}</td>
        <td>${stu.major}</td>
        <td>
            <button style="background:red">删除</button>
        </td>
    </tr>
     <%
         }
     %>
    </tbody>
</table>

<a href="../index.jsp">
    点击返回
</a>



</body>
</html>
