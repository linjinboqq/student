<%--
  Created by IntelliJ IDEA.
  User: 24353
  Date: 2019/9/7
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<html lang="zh-cn">
<head>
    <meta charset="UTF-8">
    <title>ϵͳ��¼</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        form {
            width: 400px;
            height: 240px;
            border: 1px solid #ccc;
            position: absolute;
            top: 50%;
            left: 50%;
            margin-top: -120px;
            margin-left: -200px;
            text-align: center;
        }
        h2 {
            position: absolute;
            width: 120px;
            height: 40px;
            line-height: 40px;
            top: -20px;
            left: 30px;
            background-color: white;
        }
        input, select {
            display: block;
            border-radius: 5px;
            background-color: white;
            border: 1px solid #ccc;
            margin: 30px 25px;
            height: 35px;
            font-size: 18px;
            text-indent: 1em;
            width: 350px;
        }
        button {
            display: block;
            width: 150px;
            text-align: center;
            height: 40px;
            line-height: 40px;
            color: white;
            background-color: rgb(54,133,250);
            font-size: 18px;
            border: 0;
            border-radius: 5px;
            margin: 0 auto;
        }
    </style>
</head>
<body>
<form action="user" method="post">
    <h2>��ӭ��¼</h2>
    <input type="text" name="uuid" placeholder="�û���" />
    <input type="password" name="passwd" placeholder="�û�����" />
    <button type="submit">ȷ�ϵ�¼</button>
</form>

</body>
</html>