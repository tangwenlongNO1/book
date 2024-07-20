<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/5/12
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>output</title>
</head>
<body>
    <%
        out.print(112);
        out.write(12);
    %>
<%=request.getParameter("username")%>

</body>
</html>
