<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.rapid-framework.org.cn/rapid" prefix="rapid" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 


<rapid:override name="frame-content"  >
<div class="layui-container">
	<div class="layui-row">
		<div class="layui-col-md6">
			<div id="dashboard_activity" class="postbox ">
				<div class="inside">
					<div id="activity-widget">
						<div id="published-posts" class="activity-block">
							<h3>最近发布</h3>
							<br>
							<ul>
								<c:forEach var="a" items="${listRecentArticle}">
									<li>
										<span>
											<fmt:formatDate value="${a.articleCreateTime}" pattern="yyyy/MM/dd hh:mm"/>
										</span>
										<a href="/article/${a.articleId}" target="_blank">${a.articleTitle}</a>
									</li>
								</c:forEach>
															
<!-- 								<li><span>21:06 11月25日</span> <a href="/article/33" -->
<!-- 									target="_blank">MySQL常用命令语句</a></li> -->
								
							</ul>
						</div>
						<br>
						<div id="latest-comments" class="activity-block">
							<h3>近期评论</h3>
							<ul id="the-comment-list" data-wp-lists="list:comment">
								<c:forEach items="${listRecentComment }" var="c">
                            <li class="comment   thread-even comment-item approved">
                                    <img alt=""
                                    src="resources/uploads/2017/10/20171006225356181.jpg"
                                    class="avatar avatar-50 photo" height="50" width="50">
                                     
                                    <div class="dashboard-comment-wrap has-row-actions">
                                        <p class="comment-meta">
                                            由<cite class="comment-author"> <a target="_blank"
                                                href="" rel="external nofollow" class="url">${c.commentAuthorName }</a>
                                            </cite>发表在 《<a href="/article/${c.commentArticleId }">${c.article.articleTitle }这里的title要从文章表中提取先欠着</a>》
                                        </p>
 
                                        <blockquote>
                                            <p>1</p>
                                        </blockquote>
                                        <p class="row-actions">
                                            | <span class=""> <a data-comment-id="1268"
                                                href="/admin/comment/reply/${c.commentId }"> 回复 </a>
                                            </span> <span class=""> | <a
                                                href="/admin/comment/edit/${c.commentId }">编辑</a>
                                            </span> <span class=""> | <a href="javascript:void(0)"
                                                onclick="deleteComment(${c.commentId })">删除</a>
                                            </span>
                                        </p>
                                    </div>
                                </li>
                                 
                             
                            </c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="layui-col-md6">
			<div id="dashboard_quick_press" class="postbox ">
				<div class="inside">
					<form name="post" method="post" id="insertDraftForm"
						class="initial-form hide-if-no-js"
						action="/admin/article/insertDraftSubmit">

						<div class="layui-form-item">
							<div class="layui-input-block">
								<input type="text" name="articleTitle" id="articleTitle"
									required lay-verify="required" placeholder="请输入标题"
									autocomplete="off" class="layui-input">
							</div>
						</div>
						<div class="layui-form-item layui-form-text">
							<div class="layui-input-block">
								<textarea name="articleContent" placeholder="请输入内容"
									id="articleContent" class="layui-textarea" required></textarea>
							</div>
						</div>
						<input type="hidden" name="articleStatus" value="0">
						<div class="layui-form-item">
							<div class="layui-input-block">
								<button class="layui-btn layui-btn-small" lay-submit
									lay-filter="formDemo" onclick="insertDraft()">保存草稿</button>
								<button type="reset"
									class="layui-btn layui-btn-small layui-btn-primary">重置</button>
							</div>
						</div>

					</form>
					<div class="drafts">
						<p class="view-all">
							<a href="/admin/article" aria-label="查看所有草稿">查看所有</a>
						</p>
						<h2 class="hide-if-no-js">草稿</h2>
						<ul>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</rapid:override>

<%@ include file="framework.jsp" %>