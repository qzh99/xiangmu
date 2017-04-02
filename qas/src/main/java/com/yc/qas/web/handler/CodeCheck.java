package com.yc.qas.web.handler;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class CodeCheck {
	@RequestMapping("/codeCheck")
	@ResponseBody//返回一个对象,这边是int就返回int，这边是String就返回String
	public int login(HttpSession session,String code) {
		String Rcode=(String)session.getAttribute("rand");
		int result=0;
		if(Rcode.equals(code)){
			 result=2;
		}else{
			 result=1;
		}
		return result;
	}
}
