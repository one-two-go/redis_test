<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <table >
        <tr>
            <th>编号</th>
            <th>姓名</th>
            <th>价格</th>
            <th>百分比</th>
        </tr>
        <c:forEach items="${list}" var="goods">
            <tr>
                <td>${goods.id}</td>
                <td>${goods.name}</td>
                <td>${goods.price}</td>
                <td>${goods.bfb}</td>
            <td> <a href="toupdate?id=${goods.id}">修改</a></td>
            </tr>

        </c:forEach>


    </table>

<%--    <a href="list?page=${page!=1?page-1:page}">上一页</a>--%>
<%--    <a href="list?page=${page!=totalpage?page+1:page}">下一页</a>--%>
<a href="/zset?page=${page!=1?page-1:page}">上一页</a>
<%--<a href="/zset?page=${page!=1?page-1:page}">上一页</a>--%>
<a href="/zset?page=${page!=totalpage?page+1:totalpage}">下一页</a>
</body>
</html>
