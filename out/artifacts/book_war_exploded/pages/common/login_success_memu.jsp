<%--
  Created by IntelliJ IDEA.
  User: DL
  Date: 2024/6/2
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <span>欢迎<span class="um_span">${sessionScope.user.username}</span>光临COCO书城</span>
    <a href="pages/order/order.jsp">我的订单</a>
    <a href="UserServlet?action=loginout">注销</a>&nbsp;&nbsp;
    <a href="index.jsp">返回</a>
</div>
