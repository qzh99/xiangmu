package com.yc.qas.web.handler;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.qas.util.AttributeData;

@Controller
public class GetLoginInfoHandler {
	
	@RequestMapping("/getLoginInfo")
	@ResponseBody
	public int getLoginInfo(HttpSession session) {
		Object obj=session.getAttribute(AttributeData.CURRENTUSER);
		int result=0;
		if(obj==null||obj.equals("")){
			result=1;
		}
		return result;
	}
}
