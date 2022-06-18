<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    

	<!--
		<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>

  <body>
	<h2>登录页面</h2>
  <form method="post" action="admin/login">
  	 昵称  <input type="text" name="uName" /><br>	 
  	 密码  <input type="password" name="pwd" /><br>
  	<input type="submit" value="登录"  />
  
  </form>
  
  <script>
  	var m="${msg}"; //以字符串的方式出现在JS中
  	
  	if(m != ""){
  		alert(m);
  	}
  	
  </script>   
  </body>
  
  
</html>