<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="/springMVC6/js/jquery-1.7.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(function(){
		$("#add").click(function(){
			var userName = $("#userName").attr("value");
			var age =$("#age").attr("value");
			
			var user = {userName:userName,age:age};
			
			$.ajax({
				url:"/springMVC6/user/data/addUserJson",
				type:"post",
				data:user,
				success:function(a){
					alert("userName--->" + a.userName + "age--->" + a.age );
					
				}
			});
			
			
			
		});
	});
</script>
  </head>
  
  <body>
     	姓名：<input type="text" id="userName" name="userName" />
     	年龄：<input type="text" id="age" name="age" />
     	<button type="submit" id="add">添加用户</button>
  </body>
</html>
