<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="main.java.com.edu.lin.model.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: 24353
  Date: 2019/9/7
  Time: 9:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gbk" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>������ƽ̨��̨����--ѧ����Ϣ����</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        h1 {
            height: 59px;
            line-height: 59px;
            border-bottom: 1px solid #ccc;
            box-shadow: 0 0 5px 3px #eee;
            background-color: #eee;
            color: #999;
            text-indent: 1.5em;
        }
        nav {
            background-color: rgb(19,20,21);
            color: #999;
            position: fixed;
            top: 60px;
            left: 0;
            bottom: 0;
            padding-top: 25px;
        }
        nav li {
            list-style: none;
            padding: 15px 50px 15px 25px;
        }
        nav li:hover {
            cursor: pointer;
            background-color: rgba(50,51,52,0.5);
        }
        nav .active {
            background-color: rgba(90,91,92,0.5) !important;
        }
        .content {
            margin-left: 180px;
            padding-left: 2em;
        }
        .content h2 {
            padding: 20px 0;
        }
        input, select {
            display: block;
            border-radius: 5px;
            background-color: white;
            border: 1px solid #ccc;
            margin-bottom: 30px;
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
        }
        .content section {
            display: none;
        }
        .content .active {
            display: block;
        }
        table {
            background-color: #eee;
            margin: 50px;
            border: 1px solid #999;
            border-collapse: collapse;
        }
        th,td {
            border: 1px solid #ccc;
            padding: 10px 25px;
            min-width: 100px;
            text-align: center;
        }
    </style>
</head>
<!-- ���ϱ�ǩ�а�������Ϣ����Ķ� -->

<body>

<!-- ����������������Ķ� -->
<h1>������ƽ̨��̨����-ѧ����Ϣ����</h1>

<!-- ��ർ��������Ҫ�ں��ʵ�li��ǩ������� class="active" �ֶΣ��ĸ���ֻ��ѡһ����� -->
<nav>
    <ul>
        <li class="active" data-id="add">���ѧ��</li>
        <li data-id="delete">ɾ��ѧ��</li>
        <li data-id="modify">�޸�ѧ����Ϣ</li>
        <li data-id="search">����ѧ����Ϣ</li>
    </ul>
</nav>

<div class="content">

    <!-- �Ҳ���ʾ�����ݣ���Ҫ�ں�ʵ��section��ǩ������� class="active" �ֶΣ���Ҫ����ർ�������������Ǻϣ�����ֻ�в�ѯ��Ϣ������Ҫ������޸� -->

    <!-- ���ѧ�� -->
    <section id="add" class="active">
        <h2>���ѧ��</h2>
        <form action="add" method="post">
            <input type="text" placeholder="����" name="name" />
            <select name="gender">
                <option value="" disabled="disabled" selected="selected">��ѡ���Ա�</option>
                <option value="��">��</option>
                <option value="Ů">Ů</option>
            </select>
            <input type="text" placeholder="����" name="age" />
            <input type="text" placeholder="ѧ��" name="stdNumber" />
            <select name="major">
                <option value="" disabled="disabled" selected="selected">��ѡ������רҵ</option>
                <option value="ͨ�Ź���">ͨ�Ź���</option>
                <option value="������Ϣ����">������Ϣ����</option>
                <option value="��Ϣ����">��Ϣ����</option>
                <option value="�㲥���ӹ���">�㲥���ӹ���</option>
            </select>
            <button type="submit">ȷ�����</button>
        </form>
    </section>


    <!-- ɾ��ѧ�� -->
    <section id="delete">
        <h2>ɾ��ѧ��</h2>
        <form action="delete" method="delete">
            <input type="text" placeholder="ѧ��" name="stdNumber" />
            <button type="submit">ȷ��ɾ��</button>
        </form>
    </section>


    <!-- �޸�ѧ����Ϣ -->
    <section id="modify">
        <h2>�޸�ѧ����Ϣ����ѧ���޸ģ�</h2>
        <form action="modify" method="post">
            <input type="text" placeholder="����" name="name" value="" />
            <select name="gender">
                <option value="" disabled="disabled" selected="selected">��ѡ���Ա�</option>
                <option value="��">��</option>
                <option value="Ů">Ů</option>
            </select>
            <input type="text" placeholder="����" name="age" value="" />
            <input type="text" placeholder="ѧ��" name="stdNumber" value="" />
            <select name="major">
                <option value="" disabled="disabled" selected="selected">��ѡ������רҵ</option>
                <option value="ͨ�Ź���">ͨ�Ź���</option>
                <option value="������Ϣ����">������Ϣ����</option>
                <option value="��Ϣ����">��Ϣ����</option>
                <option value="�㲥���ӹ���">�㲥���ӹ���</option>
            </select>
            <button type="submit">ȷ���޸�</button>
        </form>
    </section>


    <!-- ��ѯѧ����Ϣ -->
    <section id="search">
        <h2>����ѧ����Ϣ(����/ѧ�ſɶ�ѡһ)</h2>
        <form action="search" method="post">
            <input type="text" placeholder="����" name="name" value="" />
            <input type="text" placeholder="ѧ��" name="stdNumber" value="" />
            <button type="submit">ȷ�ϲ���</button>
        </form>
        <table>
            <thead>
            <caption>��ѯ���</caption>
            <tr>
                <th>����</th>
                <th>����</th>
                <th>�Ա�</th>
                <th>ѧ��</th>
                <th>רҵ</th>
                <th>����</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>a</td>
                <td>a</td>
                <td>a</td>
                <td>a</td>
                <td>a</td>
                <td>
                    <button style="background:red">ɾ��</button>
                </td>
            </tr>
            </tbody>
        </table>
        <!--
            ������Ϣֻ�ڵ����ѯʱ��Ч������ʱ����Ժ���
            ����в�ѯ�����������´����ڴ˴���
            ����ж�����¼����Ϊtbody��ǩ��Ӷ���tr��ǩ
            ���û�м�¼����������´����ڴ˴���
        -->
    </section>
</div>


<!-- ����Ϊ�����js�ű�������Ķ� -->
<script>
    var lis = document.getElementsByTagName("li");
    var content =  document.getElementsByClassName("content")[0];
    for(var i=lis.length; i>0; i--){
        lis[i-1].onclick = function(){
            document.getElementsByTagName("nav")[0].getElementsByClassName("active")[0].className = "";
            this.className = "active";
            content.getElementsByClassName("active")[0].className = "";
            document.getElementById(this.getAttribute("data-id")).className = "active";
        }
    }
</script>


</body>
</html>
