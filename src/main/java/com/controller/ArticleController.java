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
	 * ��ҳʵ��չʾ��������
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

		m.put("pageInfo", pageInfo); // ��ҳ
		m.put("pageUrlPrefix", "article?pageIndex"); // ��ǰ׺������ҳ�ĵ���ҳ

		return "Article/article-list";
	}

	// ��ʾ ��д���¡� ҳ��
	@RequestMapping(value = "/add")
	public String gotoAddPage(ModelMap m) {
		// ���÷����б�
		List<Category> listCategory = categoryService.listCategory();
		// System.out.println(listCategory);

		List<Tag> listTags = tagService.listTag();

		m.put("listCategory", listCategory);
		m.put("listTags", listTags);
		return "Article/article-add";
	}

	// ������� (д��)
	@RequestMapping(value = "/insert", method = RequestMethod.POST) // POST �������������
	public String add(ModelMap m, HttpServletRequest request) {
		Article article = new Article();

		// ���ﴫ��Ĳ����Ǵ�article-add.jsp��form����ύ��������������name���Ե�ֵһ�¡�
		// ���±���
		article.setArticleTitle(request.getParameter("articleTitle"));

		// ��������
		article.setArticleTitle(request.getParameter("articleContent"));

		// ����״̬
		article.setArticleStatus(Integer.parseInt(request.getParameter("articleStatus")));

		// ����ժҪ
//		String str = HtmlUtil.cleanHtmlTag(article.getArticleContent());
//		article.setArticleSummary(str.length() > 150 ? str.substring(0, 150) : str);

		// ���µķ���ʱ��
		article.setArticleCreateTime(new Date());

		// ���µ�������ʱ��
		article.setArticleUpdateTime(new Date());

		// �Ѽ��������óɳ�ʼֵ 0
		article.setArticleViewCount(0);
		article.setArticleLikeCount(0);
		article.setArticleCommentCount(0);

		// ��������
		article.setArticleOrder(1);

		// һ�������id
		int parentCateId = Integer.parseInt(request.getParameter("articleParentCategoryId"));

		// ���������id
		int childCateId = Integer.parseInt(request.getParameter("articleChildCategoryId"));

		// ���������������װ��list��
		List<Category> categoryList = new ArrayList<>(2);
		categoryList.add(new Category(parentCateId));
		categoryList.add(new Category(childCateId));

		// ��ǩ�б�
		String[] tagIds = request.getParameterValues("articleTagIds");

		// ������ı�ǩ�ŵ�list��
		List<Tag> tagList = new ArrayList<>();
		for (String tagId : tagIds) {
			tagList.add(new Tag(Integer.parseInt(tagId)));
		}

		// �ѷ���ͱ�ǩ��Ϣ����article��
		article.setCategoryList(categoryList);
		article.setTagList(tagList);

		// �������
		articleService.addArticle(article);

		// ������ת������ѯ��������
		return "forward:/article";
	}

	// ����ͼƬ�ļ��ϴ�
	@RequestMapping("/uploadimg")
	@ResponseBody
	public String uploadFile(MultipartHttpServletRequest request) throws Exception {

		// imgFile������ƾ�����ôд��
		MultipartFile file = request.getFile("imgFile");

		// ����һ��������ļ���
		String newName = UUID.randomUUID().toString();
		File destFile = new File(
				"E:/LYZ/2022_Spring/Practice/SpringWorkspace/ssm-blog/src/main/webapp/resources/uploads/" + newName
						+ ".jpg");

		file.transferTo(destFile);

		// "uploads/"Ϊ����·�� ��Ӧ "D:/imguploads/"
		String path = "http://localhost:8080/uploads/" + newName + ".jpg";

		System.out.println(path);

		// ���� json��ʽ������
		return "{\"error\":0,\"url\":\"" + path + "\"}";
	}

}
