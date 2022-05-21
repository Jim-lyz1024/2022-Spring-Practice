<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<h2>Hello World!</h2>

	<%
	request.setAttribute("msg", "Long long ago..6666....");
%>

	${msg}

	<p>${request_msg}</p>
	
	<marquee behavior="alternate">
  		${model_msg}<br>
  		${modelMap_msg}<br>
  		${map_msg}<br>	
  		
  		${modelMap_msg}<br>
  		${modelMap_msg2 }
	</marquee> 
	
	<p>http://localhost:8080/ssm-blog/index.jsp</p>

</body>
</html>
