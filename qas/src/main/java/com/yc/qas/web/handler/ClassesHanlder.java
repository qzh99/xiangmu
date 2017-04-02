package com.yc.qas.web.handler;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.entity.Teacher;
import com.yc.qas.entity.TreeNode;
import com.yc.qas.service.ClassesService;

@Controller
@RequestMapping("/classes")
public class ClassesHanlder {
	@Resource(name = "classesService")
	private ClassesService classesService;

	@RequestMapping("/selcetAllClass")
	@ResponseBody
	public List<TreeNode> selcetAllClass() {

		return classesService.selcetAllClass();
	}
	
	@RequestMapping("/teacherSelcetClass")
	@ResponseBody
	public List<TreeNode> teacherSelcetClass(HttpSession session) {
		Teacher teacher=(Teacher) session.getAttribute("currentuser");
		int teacherId=teacher.gettId();
		return classesService.teacherSelcetClass(teacherId);
	}
}
