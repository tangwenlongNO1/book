<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/5/17
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL表达式</title>
</head>
<body>
<%
    List<String> list = new ArrayList<>();
    request.setAttribute("emptyList", list);
    Map<String, Object> map = new HashMap<>();
    request.setAttribute("emptyMap", map);
%>

${empty emptyList}<br>
${empty emptyMap}<br>
<c:if test="${12 == 12}"><h1>12==12</h1></c:if><br>
<c:forEach begin="0" end="10" var="i">
    <h1>${10 - i}</h1>
</c:forEach>

</body>
</html>
