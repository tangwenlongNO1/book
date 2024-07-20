<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/5/13
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>九九乘法表</title>
</head>
<style type="text/css">
    table {
        width: 650px;
    }
</style>
<body>
<h1 align="center">九九乘法表</h1>
<table align="center">
    <%
        for (int i = 1; i < 10; i++) {%>
    <tr>
        <% for (int j = 1; j <= i; j++) {
        %>
        <td><%=j + "x" + i + "=" + (i * j)%>
        </td>
        <%
            }
        %>

    </tr>
    <%
        }
    %>
</table>
</body>
</html>
