package com.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/news") // Ŀ¼
public class HelloController {

	// ҳ�洫��
	@RequestMapping("/hello") // ��Ŀ¼ news/hello
	// http://localhost:8080/ssm-blog/news/hello?uName=Tom%20Tom
	public String demo(String uName, HttpServletRequest request, Model model, ModelMap modelMap, Map map) {
		System.out.println("��һ������: " + uName);

		// ��jspҳ�洫��
		request.setAttribute("request_msg", "request_msg: ������ҳ����5.21");
		model.addAttribute("model_msg", "model_msg: Testing springMVC ����������HandlerAdapter.");
		modelMap.put("modelMap_msg", "modelMap_msg: Testing");
		map.put("map_msg", "map_msg: Testing");
		return "index";
	}

	@RequestMapping("/add")
	public String add(String uName, String pwd, ModelMap modelMap) {
		System.out.println("Username: " + uName + " Password: " + pwd);

		modelMap.put("modelMap_msg", "This is modelMap_msg in method add()");
		modelMap.put("modelMap_msg2", "<h2>This is modelMap_msg2 in method add()<h2>");

		return "index";
	}
}
