<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
        <form method="post" action="update">
        id:<input type="text" name ="id" value="${goods.id}"><br>
        名字:<input type="text" name ="name" value="${goods.name}"><br>
        价格:<input type="text" name ="price" value="${goods.price}"><br>
        百分比:<input type="text" name ="bfb" value="${goods.bfb}"><br>
        <button>提交</button>
        </form>
</body>
</html>
