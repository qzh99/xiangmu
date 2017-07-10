package com.yc.biz;

import java.awt.Toolkit;
import java.io.File;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.table.TableColumn;

import com.yc.utils.Common;
import com.yc.utils.FileUtil;

public class CreateHtml {
	private static FileUtil fileUtil=FileUtil.getFileUtil();
	public static void createHtml(List<Map<String ,String>> list,File file){
		 int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height; 
		 int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; 
		 if(list==null&&list.size()<=0){
			 return;
		 }
		StringBuffer sb=new StringBuffer();
		sb.append("<html>\n<head>\n<meta charset=\"GBK\">\n");
		sb.append("<title>查询结果</title>\n</head>\n<body>\n<table width=\"100%\" border=\"1\" >");
		int i=0;
		for(Map<String,String> map:list){	
			Set set=map.entrySet();
			Iterator it=set.iterator();
			sb.append(" <tr align = center>\n");
			sb.append("<td>"+i+"</td>");
			while(it.hasNext()){
				Entry entry =(Entry) it.next();
				String s=(String) entry.getValue();
				if(s==null){
					s="";
				}
				sb.append("<td>"+s+"</td>");
			}	
			sb.append(" <tr>\n");
			i++;
		}
		sb.append("</table>\n</body>\n</html>");
		
		 fileUtil.savaText(sb.toString(), file);
	}
}
