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
     <form action="/springMVC10/user/updateUser" method="post">
     		<input type="hidden" name="id" value="${user.id }"/>
     	姓名：<input type="text" name="userName" value="${user.userName }"/>
     	年龄：<input type="text" name="age" value="${user.age }"/>
     	<button type="submit" >編輯</button>
     </form>
  </body>
</html>
