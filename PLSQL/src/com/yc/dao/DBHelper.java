package com.yc.dao;
import java.sql.Connection;
import java.sql.DriverManager;
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

import com.yc.utils.Common;


public class DBHelper {	
	/**
	 * 加载驱动的功能，静态块来加载驱动     因为静态块一加载到jvm就会运行
	 */
	public Connection con;
	
	
	static{
		try{
			Class.forName("oracle.jdbc.OracleDriver");
		}catch(ClassNotFoundException e){
			//e.printStackTrace();
			Common.error(e);
		}
	}	
	
	
	public void setCon(String username,String password, String driver,String oname,String ip) throws SQLException{
			//"jdbc:oracle:thin:@127.0.0.1:1521:orcl","scott","a"
			String url=  "jdbc:" +driver+  ":thin:@ "+ip+  ":1521:" +oname ;
			con = DriverManager.getConnection(url,username,password);	
			con.setAutoCommit(false);
	}

	/**
	 * 更新的方法 （DML中的insert update delete）
	 * @param :
	 * 			sql要执行的语句里面可能会有？占位符
	 * @param params
	 *			？所代表的值
	 * @throws SQLException 
	 * 
	 */
	public int doUpdate(String sql) throws SQLException{
		PreparedStatement pstmt=null;
		int result=0;
			pstmt=con.prepareStatement(sql);
			result=pstmt.executeUpdate();
			//closeAll(pstmt);
		return result;	
		
	}

	
	
	/**
	 * 执行创建DDL操作   创建，删除，修改表，约束，序列。。。
	 * @throws SQLException 
	 * 
	 */
	public boolean doDDL(String sql) throws SQLException{
		PreparedStatement pstmt=null;
			pstmt=con.prepareStatement(sql);
			boolean result=pstmt.execute();
			//closeAll(pstmt);
			return result;
	}
	
	
	
	/**
	 * 查询一：聚合函数查询
	 * @throws SQLException 
	 * 
	 */
	/*
	 public double doSelectFunction(String sql) throws SQLException{
		PreparedStatement pstmt=null;
		double result=0;
		ResultSet rs=null;
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()){   
				result=rs.getDouble(1);
			}
		closeAll(rs,pstmt,con); 
		return result;
	}
	*/
	 /**
	  * 查询一： 查询出来的结果是一个List<Map<String,String>>map 中键就是记录的列名 ，map的值就是记录的值
	  * Map对应的数据表中的一条记录List对应数据表中的全部记录
	 * @throws SQLException 
	  * 
	  */
	 public List<Map<String,String>> find(String sql) throws SQLException{
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			
			List<Map<String,String>>  list=new ArrayList <Map<String,String>>();
			
			//查询开始
				pstmt=con.prepareStatement(sql);
				//得到结果集
				rs=pstmt.executeQuery();
				//得到所有的列名
				Map<String,String>columNameList=getColumname(rs);
			
				//循环结果集，取出结果
				
				list.add(columNameList);
				//把列当成第一条记录
				while(rs.next()){
					//每next一次，就是一条记录      一条记录就是一个Map<String,String>
					//将值存入到map中
					//rs.get类型（列的序号/列名）
					//TODO:循环columnNameList从中取出每个列的名字，再根据列名以rs.get类型（列名）
					//取出这一列的值
					Map<String,String> map1=new LinkedHashMap<String,String>();
					Set set=columNameList.entrySet();
					Iterator it=set.iterator();
					while(it.hasNext()){
						Entry entry=(Entry) it.next();
						String value=rs.getString((String)entry.getKey());
						map1.put((String)entry.getKey(), value);
					}
					list.add(map1);
				}
				
			return list;
		 }
		 
		/**
		 * 从 RestSet中取得列名 包装成一个方法
		 * @throws SQLException 
		 * 
		 */
		 public Map<String,String> getColumname (ResultSet rs) throws SQLException{
			 Map<String,String>columnName=new LinkedHashMap<String,String>();
			 ResultSetMetaData rsmd=rs.getMetaData();
			 for(int i=0;i<rsmd.getColumnCount(); i++){
				 columnName.put(rsmd.getColumnLabel(i+1),rsmd.getColumnTypeName(i+1));
			 }		 
			 return columnName;  
		 }
		 
		/**
		 * 重载关闭方法
		 * 
		 */
		public void closeAll(ResultSet rs,PreparedStatement pstmt ){
			if(rs!=null){
				try {
					rs.close();
				} catch (SQLException e) {
					//e.printStackTrace();
					Common.error(e);
					throw new RuntimeException(e);
				}
			}
			closeAll(pstmt);
		}
			
		/**
		 * 关闭
		 */
		public void closeAll(PreparedStatement pstmt){
			if(pstmt!=null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					//e.printStackTrace();
					Common.error(e);
				}
			}
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e) {
					//e.printStackTrace();
					Common.error(e);
				}
			}
		}
		
	}
