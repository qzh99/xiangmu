package com.yc.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yc.bean.Admin;
import com.yc.dao.DBHelper;



//常用对象及方法类 
public class Common {
	public static Admin admin;
	public static DBHelper dbhelper;
	
	public static Map<String,String> returnmap;
	public static void linkCmd(String s){
		try {
			Process p = Runtime.getRuntime().exec(s.toString());
			InputStreamReader isr = new InputStreamReader(p
					.getErrorStream());
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				if (line.indexOf("错误") != -1) {
					break;
				}
			}
			p.destroy();
			p.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//获取一个log4j的日志记录器
	public static Logger log=Logger.getLogger(Common.class);
	
	public static void error(Exception e){
		StackTraceElement[] sts=e.getStackTrace();
		for(StackTraceElement ste:sts){
			log.error(ste.toString());
		}
	}
}
