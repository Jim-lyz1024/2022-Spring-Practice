package com.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.entity.Article;
import com.entity.Category;
import com.entity.Tag;
import com.github.pagehelper.PageInfo;
import com.service.ArticleService;
import com.service.CategoryService;
import com.service.TagService;

@Controller
@RequestMapping("/article")
public class ArticleController {

	@Resource
	ArticleService articleService;

	@Resource
	CategoryService categoryService;

	@Resource
	TagService tagService;

	/**
	 * 分页实现展示所有文章
	 * 
	 * @param m
	 * @param pageIndex
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("")
	public String index(ModelMap m, @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
			@RequestParam(required = false, defaultValue = "5") Integer pageSize) {

		PageInfo<Article> pageInfo = articleService.getPageArticleList(pageIndex, pageSize);

//		System.out.println("getEndRow:" + pageInfo.getEndRow());
//		System.out.println("getNextPage:" + pageInfo.getNextPage());
//		System.out.println("getPageNum:" + pageInfo.getPageNum());
//		System.out.println("getPages:" + pageInfo.getPages());
//		System.out.println("getPageSize:" + pageInfo.getPageSize());
//		System.out.println(pageInfo.getList().size() + "==========================");
//		List<Article> articleList = articleService.findAll();
//
//		m.put("articleList", articleList);

		m.put("pageInfo", pageInfo); // 分页
		m.put("pageUrlPrefix", "article?pageIndex"); // 把前缀传给分页的导航页

		return "Article/article-list";
	}

	// 显示 “写文章” 页面
	@RequestMapping(value = "/add")
	public String gotoAddPage(ModelMap m) {
		// 调用分类列表
		List<Category> listCategory = categoryService.listCategory();
		// System.out.println(listCategory);

		List<Tag> listTags = tagService.listTag();

		m.put("listCategory", listCategory);
		m.put("listTags", listTags);
		return "Article/article-add";
	}

	// 添加文章 (写库)
	@RequestMapping(value = "/insert", method = RequestMethod.POST) // POST 请求走这个方法
	public String add(ModelMap m, HttpServletRequest request) {
		Article article = new Article();

		// 这里传入的参数是从article-add.jsp的form表达提交而来，参数名与name属性的值一致。
		// 文章标题
		article.setArticleTitle(request.getParameter("articleTitle"));

		// 文章内容
		article.setArticleTitle(request.getParameter("articleContent"));

		// 文章状态
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));

		// 文章摘要
//		String str = HtmlUtil.cleanHtmlTag(article.getArticleContent());
//		article.setArticleSummary(str.length() > 150 ? str.substring(0, 150) : str);

		// 文章的发布时间
		article.setArticleCreateTime(new Date());

		// 文章的最后更新时间
		article.setArticleUpdateTime(new Date());

		// 把几个参数置成初始值 0
		article.setArticleViewCount(0);
		article.setArticleLikeCount(0);
		article.setArticleCommentCount(0);

		// 文章排序
		article.setArticleOrder(1);

		// 一级分类的id
		int parentCateId = Integer.parseInt(request.getParameter("articleParentCategoryId"));

		// 二级分类的id
		int childCateId = Integer.parseInt(request.getParameter("articleChildCategoryId"));

		// 把上面的两个分类装到list中
		List<Category> categoryList = new ArrayList<>(2);
		categoryList.add(new Category(parentCateId));
		categoryList.add(new Category(childCateId));

		// 标签列表
		String[] tagIds = request.getParameterValues("articleTagIds");

		// 把上面的标签放到list中
		List<Tag> tagList = new ArrayList<>();
		for (String tagId : tagIds) {
			tagList.add(new Tag(Integer.parseInt(tagId)));
		}

		// 把分类和标签信息都添到article中
		article.setCategoryList(categoryList);
		article.setTagList(tagList);

		// 添加文章
		articleService.addArticle(article);

		// 将请求转发到查询所有文章
		return "forward:/article";
	}

	// 处理图片文件上传
	@RequestMapping("/uploadimg")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) throws Exception {

		// imgFile这个名称就是这么写的
		MultipartFile file = request.getFile("imgFile");

		// 生成一个随机的文件名
		String newName = UUID.randomUUID().toString();
		File destFile = new File(
				"E:/LYZ/2022_Spring/Practice/SpringWorkspace/ssm-blog/src/main/webapp/resources/uploads/" + newName
						+ ".jpg");

		file.transferTo(destFile);

		// "uploads/"为虚拟路径 对应 "D:/imguploads/"
		String path = "http://localhost:8080/uploads/" + newName + ".jpg";

		System.out.println(path);

		// 返回 json格式的数据
		return "{\"error\":0,\"url\":\"" + path + "\"}";
	}

}
