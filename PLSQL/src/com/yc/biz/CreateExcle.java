package com.yc.biz;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.MessageDialog;

import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class CreateExcle {
	public static void createExcle(String ulr,String tableName,List<Map<String,String >> list) throws Exception{
			if((ulr==null||ulr.equals(""))||(tableName==null||ulr.equals(""))||(list==null||list.size()<=1)){
				return;
			}
			
	             //  打开文件
	    	WritableWorkbook book  =  Workbook.createWorkbook( new  File(ulr));
	             //  生成名为“第一页”的工作表，参数0表示这是第一页
	    	WritableSheet sheet  =  book.createSheet( tableName,  0 );
	             //  在Label对象的构造子中指名单元格位置是第一列第一行(0,0)
	             //  以及单元格内容为test
	    	//列
	    	int j=0;//行
	            //写入内容
	    	for(Map map:list){
	    		int i=0; 
	    		Set set=map.entrySet();
	            Iterator it=set.iterator();
	            while(it.hasNext()){
	            	Entry entry =(Entry) it.next();
	 	            Label label  =   new  Label( i ,  j , (String) entry.getValue());
	 	            sheet.addCell(label);
	 	            i++;
	             }
	             j++;
	    	}	            
	             //  将定义好的单元格添加到工作表中            
	 
	             /**/ /*
	             * 生成一个保存数字的单元格 必须使用Number的完整包路径，否则有语法歧义 单元格位置是第二列，第一行，值为789.123
	              */
	             //  写入数据并关闭文件
	            book.write();
	            book.close();       
	}
}
