<%@ page import="java.util.List" %>
<%@ page import="com.example.pojo.Student" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/5/13
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>插值</title>
</head>
<body>
<%
    List<Student> students = new ArrayList<>();
    for(int i = 0; i < 10; i++)
        students.add(new Student(i, "student" + i, "phone" + i));
%>
<%
    for(int i = 0; i < 10; i++){
%>
<%=request.getParameter("username")%>
<%}%>
</body>
</html>
