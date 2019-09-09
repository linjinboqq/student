<%--
  Created by IntelliJ IDEA.
  User: 24353
  Date: 2019/9/9
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<html>
<head>
    <title>插入结果</title>
</head>
<body>
<%
    String iinfo = (String) request.getAttribute("Iinfo");
    if (iinfo != null) {
%>
<h4><%=iinfo%>
        <%
}
        %>
    <a href="../index.jsp">
        点击返回
    </a>

</body>
</html>
