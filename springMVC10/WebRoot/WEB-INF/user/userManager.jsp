<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript" src="../js/jquery-1.7.1.min.js"></script>
    <base href="<%=basePath%>">
    <title>hello</title>
    
    <script type="text/javascript">
    	function del(id){
    		$.get("/springMVC10/user/delUser?id=" + id,function(data){
			alert(data.result);
			if("success" == data.result){
				alert("删除成功!");
				window.location.reload(); 
			}else{
				alert("删除失败!")
			}
		});
		}
    </script>
  </head>
  
  <body>
    <h>用户管理</h><br />
     <table border="1">
     	<tr>
     		<th>姓名</th>
     		<th>年龄</th>
     		<th>编辑</th>
     	</tr>
     	
     	<c:if test="${!empty user }">
     		<c:forEach items="${user}" var="u">
     			<tr>
     			<td>${u.userName }</td>
     			<td>${u.age}</td>
     			<td>
     			<a href="/springMVC10/user/getUser?id=${u.id}">编辑</a>
     			<a href="javascript:del('${u.id}')">删除</a>
     			</td>
     			</tr>
     		</c:forEach>
     	</c:if>
     	
     </table>
  </body>
</html>
