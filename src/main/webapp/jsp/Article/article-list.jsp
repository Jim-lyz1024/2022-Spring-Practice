<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 

<!-- 主体内容,要留给别的页面覆盖 -->
<rapid:override name="frame-content"  >
				<!-- 下面这里的内容是要重写的 -->
				<blockquote class="layui-elem-quote">
					<span class="layui-breadcrumb" lay-separator="/"> <a
						href="/admin">首页</a> <cite>文章列表</cite>
					</span>
				</blockquote>

				<div class="layui-tab layui-tab-card">
					<form id="articleForm" method="post">
						<input type="hidden" name="currentUrl" id="currentUrl" value="">
						<table class="layui-table">
							<colgroup>
								<col width="300">
								<col width="150">
								<col width="100">
								<col width="150">
								<col width="100">
								<col width="50">
							</colgroup>
							<thead>
								<tr>
									<th>标题</th>
									<th>所属分类</th>
									<th>状态</th>
									<th>发布时间</th>
									<th>操作</th>
									<th>id</th>
								</tr>
							</thead>
							<tbody>
<c:forEach var="a" items="${pageInfo.list}">
	<tr>
		<td><a href="/article/${a.articleId }" target="_blank"> ${a.articleTitle }</a></td>
		<td>
		<!-- 一个文章可以属于多个类别 -->
			<c:forEach var="c" items="${a.categoryList }">
				<a href="/category/${c.categoryId }" target="_blank">${c.categoryName }</a> &nbsp;	&nbsp;
			</c:forEach>
		 </td>
		<td>
			<a href="#"> 
				<c:if test="${a.articleStatus==1 }">
					<span style="color: #5FB878;">已发布</span>
				</c:if>
				<c:if test="${a.articleStatus==0 }">
					<span style="color: RED;">草稿</span>
				</c:if>
		    </a>
		 </td>
		<td> <fmt:formatDate value="${a.articleCreateTime }" pattern="yyyy/MM/dd hh:mm:ss"/>  </td>
		<td><a href="/admin/article/edit/${a.articleId }"
			class="layui-btn layui-btn-mini">编辑</a> <a
			href="javascript:void(0)" onclick="deleteArticle(${a.articleId })"
			class="layui-btn layui-btn-danger layui-btn-mini">删除</a></td>
		<td>${a.articleId}</td>
	</tr>

</c:forEach>				
							</tbody>
						</table>
					</form>
					<!-- 引用分页 -->
		<%@ include file="../page.jsp" %>
				</div>
				<!-- 重写结束 -->

	
</rapid:override> 

<%@ include file="../framework.jsp" %>