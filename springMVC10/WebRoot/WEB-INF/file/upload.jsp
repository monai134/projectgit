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
    <form action="/springMVC7/file/upload2" method="post" enctype="multipart/form-data">
    	选择文件：<input type="file" name="file">
    	<input type="submit" value="上传">
    </form>
  </body>
</html>
