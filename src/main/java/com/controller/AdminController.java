package com.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Article;
import com.entity.Comment;
import com.entity.User;
import com.service.ArticleService;
import com.service.CommentService;
import com.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Resource
	private UserService userService;

	@Resource
	private ArticleService articleService;

	@Resource
	private CommentService commentService;

	@RequestMapping("/login")
	public String login(String username, String password, ModelMap modelMap, HttpSession session) {
		System.out.println("�û���: " + username + " ����: " + password);

		User user = userService.login(username, password);
		// ����һ���Ƿ���յ��˴����ݿ��в�ѯ����user����
		System.out.println(user);

		if (user != null) {
			// ��ʾ���������5ƪ����
			List<Article> listRecentArticle = articleService.listRecentArticle(5);
			// System.out.println("��ʾ���������5ƪ����: " + listRecentArticle);

			// ��ʾ���������5������
			List<Comment> listRecentComment = commentService.listRecentComment(5);

			// ����̨���ݴ���ǰ��ҳ��
			modelMap.put("listRecentArticle", listRecentArticle);
			modelMap.put("listRecentComment", listRecentComment);
			modelMap.put("msg", "Login Success!");

			session.setAttribute("session_user", user);

			return "index";
		} else {
			modelMap.put("msg", "Error!!");
			return "login";
		}

//		String userName = "admin";
//		String passWord = "123456";

//		if (username.equals(userName) && password.equals(passWord)) {
//			modelMap.put("username", username);
//			return "index";
//		}
//
//		modelMap.put("msg", "�˺�����������󣡣�");
//		return "login";

	}

	// ��ʾ�û����ҳ��
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String gotoAddPage() {
		return "User/user-add";
	}

	// ����û� д��
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String add(User user, MultipartFile photo) throws IOException {
		user.setUserRegisterTime(new Date());
		user.setUserStatus(1);
		user.setUserPhoto(photo.getBytes());
		userService.addUser(user);

		return "forward:/admin/user";

	}

	// ��ʾ�û��б�ҳ
	@RequestMapping("/user")
	public String users(ModelMap m) {

		List<User> userList = userService.listUser();
		m.put("users", userList);

		return "User/user-list";
	}

	// ��ʾ�û��б�ҳ�е�ͷ��ͼƬ
	@RequestMapping("/photo/{id}")
	public void showPhoto(@PathVariable("id") Integer id, HttpServletResponse response) throws IOException {
		User user = userService.getUserById(id);

		response.setContentType("image/jpg");
		ServletOutputStream outStream = response.getOutputStream();
		outStream.write(user.getUserPhoto());
		outStream.flush();
	}

	// �༭�û�
	@RequestMapping("/edit")
	public String user_edit(@RequestParam(value = "id") Integer id, ModelMap m) {

//		
//		System.out.println("==================="+id);
//		System.out.println("==================="+id);
//		System.out.println("==================="+id);
//		System.out.println("==================="+id);
		User user = userService.getUserById(id);

//		System.out.println(user);

		m.put("u", user);

		return "User/user-edit";
	}

	// �༭�û� д��
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(User user, MultipartFile photo, ModelMap m) throws IOException {

		System.out.println("===================" + photo);
		System.out.println("===================" + photo);
		System.out.println("===================" + user);

//			user.setUserRegisterTime(new Date());
//			user.setUserStatus(1);

		if (photo != null) {
			user.setUserPhoto(photo.getBytes());
		} else {
			m.put("msg", "�����ͼƬ��");
		}

		userService.updateUser(user);

		return "forward:/admin/user"; // �������Ժ�.ת���û��б�

	}

	// ɾ���û�
	@RequestMapping("/delete")
	public String user_del(@RequestParam(value = "id") Integer id) {

		userService.delUserById(id);

		return "forward:/admin/user"; // �������Ժ�.ת���û��б�
	}

}
