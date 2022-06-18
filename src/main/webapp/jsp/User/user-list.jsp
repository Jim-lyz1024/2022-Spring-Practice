<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-content"  >
<blockquote class="layui-elem-quote">
         <span class="layui-breadcrumb" lay-separator="/">
              <a href="/admin">首页</a>
              <cite>用户列表</cite>
        </span>
    </blockquote>

<table class="layui-table" lay-even lay-skin="nob" >
    <colgroup>
        <col width="100">
        <col width=100">
        <col width="100">
        <col width="50">
        <col width="50">
        <col width="100">
        <col width="50">
    </colgroup>
    <thead>
    <tr>
        <th>用户名</th>
        <th>昵称</th>
        <th>电子邮件</th>
        <th>文章</th>
        <th>状态</th>
        <th>操作</th>
        <th>ID</th>
    </tr>
    </thead>
    <tbody>
    
<c:forEach  items="${users }" var="u">
   
   <tr>
		<td><img src="admin/photo/${u.userId}" width="48" height="48">
			<strong><a href="user/edit/${u.userId}">${u.userName}</a></strong>
		</td>
		<td>${u.userNickname}</td>
		<td>${u.userEmail}</td>

		<td><c:choose>
				<c:when test="${u.userStatus==0}">
					<span style="color: #FF5722;">禁用</span>
				</c:when>
				<c:otherwise>
	                  正常
	            </c:otherwise>
			</c:choose></td>
		<td><a href="admin/edit.do?id=${u.userId}"
			class="layui-btn layui-btn-mini">编辑</a> <a
			href="admin/delete?id=${u.userId}"
			class="layui-btn layui-btn-danger layui-btn-mini"
			onclick="return confirmDelete()">删除</a></td> 

	</tr>
 </c:forEach>
  
    </tbody>
</table>
</rapid:override>

<%@ include file="../framework.jsp" %> 