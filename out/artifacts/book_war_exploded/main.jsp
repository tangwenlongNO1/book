<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/5/13
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
头部信息<br>
主题信息<br>
底部信息<br>
<%--<%@include file="output.jsp"%>--%>
<jsp:include page="output.jsp">
    <jsp:param name="username" value="root"/>
    <jsp:param name="password" value="1223456"/>
</jsp:include>
</body>
</html>
