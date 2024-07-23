<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>购物车</title>

    <%-- 静态包含 base标签、css样式、jQuery文件 --%>
    <%@ include file="/pages/common/head.jsp" %>
    <script type="text/javascript">
        $(function () {
            // 给删除的a标签绑定单击事件，用于删除的确认提示操作
            $("a.delete").click(function () {
                // 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个确认，一个是取消。
                 * 返回true表示点击了，确认，返回false表示点击取消。
                 */
                return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() + "】?");
                // return false// 阻止元素的默认行为===不提交请求
            });

            $("a.clear").click(function () {
                // 在事件的function函数中，有一个this对象。这个this对象，是当前正在响应事件的dom对象。
                /**
                 * confirm是确认提示框函数
                 * 参数是它的提示内容
                 * 它有两个按钮，一个确认，一个是取消。
                 * 返回true表示点击了，确认，返回false表示点击取消。
                 */
                return confirm("你确定要清空购物车吗?");
                // return false// 阻止元素的默认行为===不提交请求
            });

            $(".updateCount").change(function () {

                var id = $(this).attr("bookId");
                if(confirm("你确定要将【" + $(this).parent().parent().find("td:first").text() + "】的数量改为【" + this.value + "】吗？")){

                    //发起请求
                    location.href = "${basePath}CartServlet?action=updateItem&count=" + this.value + "&id=" + id;
                }else {
                    this.value = this.defaultValue;
                }
            });
        });
    </script>


</head>
<body>

<div id="header">
    <a href="index.jsp"> <img class="logo_img" alt="" src="static/img/apple.svg"></a>
    <span class="wel_word">购物车</span>

    <%--静态包含，登录 成功之后的菜单 --%>
    <%@ include file="/pages/common/login_success_menu.jsp" %>


</div>

<div id="main">

    <table>
        <tr>
            <td>商品名称</td>
            <td>数量</td>
            <td>单价</td>
            <td>金额</td>
            <td>操作</td>
        </tr>

        <c:if test="${empty sessionScope.cart.items}">
            <tr>
                <td colspan="5"><a href="index.jsp">亲！您的购物车空空的，快去商城逛逛吧！</a></td>
            </tr>
        </c:if>

        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="cart">
                <tr>
                    <td>${cart.value.name}</td>
                    <td>
                        <input type="text" class="updateCount" bookId="${cart.value.id}" style="text-align: center; width: 80px" value="${cart.value.count}"></td>
                    <td>${cart.value.price}</td>
                    <td>${cart.value.totalPrice}</td>
                    <td><a href="CartServlet?action=deleteItem&id=${cart.value.id}" class="delete">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>

    </table>
    <c:if test="${not empty sessionScope.cart.items}">
        <div class="cart_info">
            <span class="cart_span">购物车中共有<span class="b_count">${sessionScope.cart.totalCount}</span>件商品</span>
            <span class="cart_span">总金额<span class="b_price">${sessionScope.cart.totalPrice}</span>元</span>
            <span class="cart_span"><a href="CartServlet?action=clear" class="clear">清空购物车</a></span>
            <span class="cart_span"><a href="pages/cart/checkout.jsp">去结账</a></span>
        </div>
    </c:if>

</div>


<%--静态包含页脚内容--%>
<%@include file="/pages/common/footer.jsp" %>


</body>
</html>