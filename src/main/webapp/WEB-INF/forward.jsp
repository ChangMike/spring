<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>forward</title>
    </head>
    <body>
        <form action="/receive" method="post">
            <input type="text" name="username" value=""/><br>
            <input type="password" name="password"/><br>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="submit" value="登录">
        </form>
    </body>
</html>