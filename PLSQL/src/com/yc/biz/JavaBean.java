package com.yc.biz;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;

import com.yc.ui.SelectJavabean;
import com.yc.utils.Common;
import com.yc.utils.FileUtil;

public class JavaBean {
	private static FileUtil fileUtil=FileUtil.getFileUtil();

	public static void createJavaBean(String tableName,File file){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Map<String,String>>  list=new ArrayList <Map<String,String>>();
		String sql="select * from "+tableName;
		//查询开始
			try {
				pstmt=	Common.dbhelper.con.prepareStatement(sql);
				rs=pstmt.executeQuery();
				if(rs==null){
					return;
				}
				String [] s=file.getName().split("\\.");
				StringBuffer sb=new StringBuffer();
				 
				ResultSetMetaData rsmd=rs.getMetaData();//元数据  有类型  有列名
				//循环列名  拿到对应的类型
				Map <String,String>map=new LinkedHashMap<String,String>();
				 for(int i=1;i<=rsmd.getColumnCount(); i++){
					 map.put(rsmd.getColumnLabel(i).toLowerCase(),rsmd.getColumnTypeName(i));
				 }
					try {
						SelectJavabean window = new SelectJavabean(map);
						window.open();
					} catch (Exception e) {
						e.printStackTrace();
					}
			
					Map<String ,String > remap=Common.returnmap;
					sb.append("public class "+s[0]+"{\t\n");
				
				 	Set set=map.entrySet();
					Iterator it=set.iterator();
					int i=1;
					while(it.hasNext()){
						Entry entry =(Entry) it.next();
						String name=((String)entry.getKey()).toLowerCase();
						String type=((String)entry.getValue()).toLowerCase();
						if(type.equals("number")){
							type="double";
						} if(type.equals("varchar")||type.equals("varchar2")||type.equals("char")){
							type="String";
						}if(type.equals("date")){
							type="Date";
						}
						sb.append("\tprivate "+type+" "+name+";\n");
						
					}			
				 sb.append("\tpublic "+s[0]+"(){\n");
				 sb.append("\t\tsuper();\n\t}\n");
				  writeGet(sb, remap);
					 
				 sb.append("}\n");
				 fileUtil.savaText(sb.toString(), file);
		 
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	protected static void writeGet(StringBuffer sb, Map<String, String> remap) {
		if(remap==null){
			return;
		}
		Set set;
		Iterator it;
		set=remap.entrySet();
		  it=set.iterator();
			
			while(it.hasNext()){
				Entry entry =(Entry) it.next();
				String name=((String)entry.getKey()).toLowerCase();
				String type=((String)entry.getValue()).toLowerCase();
				if(type.equals("number")){
					type="double";
				} if(type.equals("varchar")||type.equals("varchar2")||type.equals("char")){
					type="String";
				}if(type.equals("date")){
					type="Date";
				}
				sb.append("\tpublic "+type+" get"+name.substring(0, 1).toUpperCase()+name.substring(1)+"(){\n");
				sb.append("\t\treturn "+name+";\n\t}\n");
				//set
				sb.append("\tpublic void set"+name.substring(0, 1).toUpperCase()+
						name.substring(1)+"("+type+" "+name+"){\n");
				sb.append("\t\t"+"this."+name+"="+name+";\n\t}\n");											
			}
	}
}
