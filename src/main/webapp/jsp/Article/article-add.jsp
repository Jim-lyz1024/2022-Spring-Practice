<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<rapid:override name="frame-content"  >
		
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<blockquote class="layui-elem-quote">
					<span class="layui-breadcrumb" lay-separator="/"> <a
						href="/admin">首页</a> <a href="/admin/article">文章列表</a> <cite>添加文章</cite>
					</span>
				</blockquote>



				<form class="layui-form" method="post" id="myForm"
			action="article/insert" enctype="multipart/form-data"> 
				

					<div class="layui-form-item">
						<label class="layui-form-label">标题 <span
							style="color: #FF5722;">*</span></label>
						<div class="layui-input-block">
							<input type="text" name="articleTitle" lay-verify="title"
								id="title" autocomplete="off" placeholder="请输入标题"
								class="layui-input">
						</div>
					</div>

					<div class="layui-form-item layui-form-text">
						<label class="layui-form-label">内容 <span
							style="color: #FF5722;">*</span></label>
						<div class="layui-input-block">
							
							<textarea  name="articleContent" lay-verify="content" id="content"></textarea>
						</div>

					</div>

					<div class="layui-form-item">
						<label class="layui-form-label">分类 <span
							style="color: #FF5722;">*</span>
						</label>
						<div class="layui-input-inline">
							<select name="articleParentCategoryId"
								id="articleParentCategoryId"
								lay-filter="articleParentCategoryId" required>
								<option value="" selected="">一级分类</option>
							
						
							<c:forEach items="${listCategory}" var="c" >
								<c:if test="${c.categoryPid==0 }">
									<option value="${c.categoryId }">${c.categoryName}</option>
								</c:if>
							</c:forEach>
							
							</select>
						</div>
						<div class="layui-input-inline">
							<select name="articleChildCategoryId" id="articleChildCategoryId">
								<option value="" selected>二级分类</option>
							</select>
						</div>
					</div>

					<div class="layui-form-item" pane="">
						<label class="layui-form-label">标签</label>
						<div class="layui-input-block">
						
							
				
					<c:forEach items="${listTags }" var="t">			
							<input type="checkbox" name="articleTagIds" lay-skin="primary" 
							     title="${t.tagName }" value="${t.tagId }">
					</c:forEach>
								
								
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">状态</label>
						<div class="layui-input-block">
							<input type="radio" name="articleStatus" value="1" title="发布"
								checked> <input type="radio" name="articleStatus"
								value="0" title="草稿">
						</div>
					</div>
					
					<div class="layui-form-item">
						<div class="layui-input-block">
							<button class="layui-btn" lay-submit="" lay-filter="demo1">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary"
								onclick="getCateIds()">重置</button>
						</div>
					</div>
					<blockquote class="layui-elem-quote layui-quote-nm">
						温馨提示：<br> 1、文章内容的数据表字段类型为MEDIUMTEXT,每篇文章内容请不要超过500万字 <br>
						2、写文章之前，请确保标签和分类存在，否则可以先新建；请勿刷新页面，博客不会自动保存 <br> 3、插入代码前，可以点击
						<a href="http://liuyanzhao.com/code-highlight.html"
							target="_blank">代码高亮</a>,将代码转成HTML格式

					</blockquote>

				</form>


			</div>
		
</rapid:override>

<rapid:override name="frame-footer-script">
	<script>
		layui
				.use(
						[ 'form', 'layedit', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, layedit = layui.layedit, laydate = layui.laydate;
							
							//自定义验证规则
							form.verify({
								title : function(value) {
									if (value.length < 5) {
										return '标题至少得5个字符啊';
									}
								},
								pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
								content : function(value) {
									layedit.sync(editIndex);
								}
							});


							//二级联动
							form.on(
											"select(articleParentCategoryId)",
											function() {
												var optionstring = "";
												var articleParentCategoryId = $(
														"#articleParentCategoryId")
														.val();

									<c:forEach items="${listCategory}" var="c" >			
							
												if (articleParentCategoryId == "${c.categoryPid}") {
													optionstring += "<option name='childCategory' value='${c.categoryId}'>${c.categoryName}</option>";
												}
									</c:forEach>

												

												$("#articleChildCategoryId")
														.html(
																"<option value=''selected>二级分类</option>"
																		+ optionstring);
												form.render('select'); //这个很重要
											})

						});
	</script>
	
	<link rel="stylesheet" href="resources/kindeditor/themes/default/default.css" />
	<link rel="stylesheet" href="resources/kindeditor/plugins/code/prettify.css" />
	<script charset="utf-8" src="resources/kindeditor/kindeditor-all-min.js"></script>
	<script charset="utf-8" src="resources/kindeditor/lang/zh-CN.js"></script>
	<script charset="utf-8" src="resources/kindeditor/plugins/code/prettify.js"></script>
					
	<script>
	KindEditor.ready(function(K) {
		var editor1 = K.create('textarea[id="content"]', {
			cssPath : 'resources/kindeditor/plugins/code/prettify.css',
			uploadJson : 'article/uploadimg',  //指明上传图片用的服务端程序
			allowFileManager : true,
			width:'1000px',
			height:'400px'
		});
		prettyPrint();
	});
	</script>
	
	
</rapid:override>

<%@ include file="../framework.jsp" %> 
