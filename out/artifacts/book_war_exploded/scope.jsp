<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/5/12
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>scope</title>
</head>
<body>
  <h1>这是scope.jsp页面</h1>
<%
    request.setAttribute("key", "request");
    pageContext.setAttribute("key", "pagecontext");
    session.setAttribute("key", "session");
    application.setAttribute("key", "application");
%>
    request是否有值:<%=request.getAttribute("key")%><br>
  pageContext是否有值:<%=pageContext.getAttribute("key")%><br>
  session是否有值:<%=session.getAttribute("key")%><br>
  application是否有值:<%=application.getAttribute("key")%><br>
<%
//    request.getRequestDispatcher("/scope2.jsp").forward(request, response);

%>
<jsp:forward page="scope2.jsp"></jsp:forward>
</body>
</html>
