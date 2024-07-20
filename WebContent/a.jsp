<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.io.Writer" %><%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/5/9
  Time: 19:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private static final Map<String, Integer> map;
%>

<%!
    static {
        map = new HashMap<>();
        map.put("key1", 1);
        map.put("key2", 2);
        map.put("key3", 3);
    }
%>
<html>
<head>
    <title>jsp页面</title>
</head>
<body>
<%=12%><br>
<%=map%><br>
<%=12.12%><br>
<%="我是字符串"%><br>
<%=request.getParameter("username")%><br>
<%
    int s = 12;
    int sum = s * 2;
    System.out.println(sum);
    System.out.println("request.getParameter(\"username\") = " + request.getParameter("username"));

    //Java注释
%>
<!--这是html注释-->
<%--这是jsp注释--%>

</body>
</html>
