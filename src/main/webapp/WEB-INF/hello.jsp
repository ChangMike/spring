<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ss" uri="http://www.springframework.org/security/tags" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>hello</title>
    </head>
    <body>
        <!-- Spring Security 标签库的使用
         1、添加pom依赖
         2、在jsp头引入标签库
         authentication 标签用来渲染当前用户认证对象的信息
         authorize 标签可用来条件性地渲染页面内容
        -->
        欢迎<ss:authentication property="principal.username" /><br/>
        <!-- 也可以将用户的认证信息声明为一个变量，默认这个变量在pageContext域 -->
        <ss:authentication property="principal.username" var="name"/>
        你好${name}
        <h2>${msg}</h2>
        <ss:authorize access="hasRole('ROLE_MEMBER')">
            member角色才显示
        </ss:authorize><br/>
        <a href="/logout">退出</a>
    </body>
</html>