<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>hello</title>
  </head>
  
  <body>
     <form action="/springMVC10/user/addUser" method="post">
     	姓名：<input type="text" name="userName" />
     	年龄：<input type="text" name="age" />
     	<button type="submit" >添加用户</button>
     </form>
  </body>
</html>
