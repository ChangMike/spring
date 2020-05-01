<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>
    <head>
        <title>自定义页面</title>
    </head>
    <body>
        </form>
            <!-- placeholder 属性是 HTML5 中的新属性，描述该字段的提示信息 -->
            自定义表单验证:<form name="f" action="" method="post"><br/>
            用户名:<input type="text" name="username" placeholder="用户名"><br/>
            密码:<input type="password" name="password" placeholder="密码"><br/>
            记住我：<input id="remember_me" name="remember-me" type="checkbox"><br/>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input name="submit" type="submit" value="提交">
        </form>
    </body>
</html>