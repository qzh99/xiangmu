package com.yc.biz;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.wb.swt.SWTResourceManager;

import com.yc.ui.MainUi;
import com.yc.utils.Common;

public class Function {
	static String username=Common.admin.getName();
	public static  void showTree(Tree tree){
		String s []=new String []{"Receny objects","Recycle bin","Functions",
				"Procedures","packages","packag","Types","Type boTypesdies","Triggers",
				"Java class","Java sources","DNMD_Jobs","Queues","Libraries",
				"Directuries","Tables","Indexes","Constraits","Views",
				"Materialized views","Sequences","Users","Profiles","Roles","Synonyms","Database links"
				,"Tablespaces","Clusters","Window Groups","windows	"
				,"Schedules","Programs","Jobs","Job ckasses"};
				for(String ss:s){
				TreeItem t=new TreeItem(tree,SWT.None);
				t.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/文件夹.PNG"));
				t.setText(ss);
				
				if(t.getText().equals("Tables")){       //查表
					String sql="select TABLE_NAME from user_tables";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/table.PNG"));
					}
				}else if(t.getText().equals("Triggers")){
					String sql="select TRIGGER_NAME from USER_TRIGGERS";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Triggers.PNG"));
					}
				}else if(t.getText().equals("Sequences")){
					String sql="select SEQUENCE_NAME from USER_SEQUENCES";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Sequences	.PNG"));
					}
				}else if(t.getText().equals("Indexes")){
					String sql="select INDEX_NAME from user_INDEXES";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Indexes.PNG"));
					}
				}else if(t.getText().equals("Constraits")){
					String sql="select CONSTRAINT_NAME from USER_CONSTRAINTS";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Constraits.PNG"));
					}
				}else if(t.getText().equals("Views")){
					String sql="select VIEW_NAME from USER_VIEWS";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Views.PNG"));
					}
				}else if(t.getText().equals("Users")){
					String sql="select USERNAME from ALL_USERS";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Users.PNG"));
					}
				}else if(t.getText().equals("Roles")){
					String sql="select GRANTED_ROLE from user_role_privs";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Roles.PNG"));
					}
				}else if(t.getText().equals("Tablespaces")){
					String sql="SELECT TABLESPACE_NAME FROM USER_TABLESPACES";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Tablespaces.PNG"));
					}
				}else if(t.getText().equals("Java class")){
					String sql="SELECT SUPER FROM USER_JAVA_CLASSES";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Java class.PNG"));
					}
				}else if(t.getText().equals("Clusters")){
					String sql="select CLUSTER_NAME from USER_CLUSTERS";
					showTreeItem(t, sql);
					TreeItem[] tL=t.getItems();
					for(TreeItem tl:tL){
						tl.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/Java Clusters.PNG"));
					}
				}							
			}			
	}
	private static void showTreeItem(TreeItem t, String sql) {
		List<Map<String, String>> list=null;
		try {
			list = Common.dbhelper.find(sql);
			if(list==null||list.size()<=1){
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		for(int i=1;i<list.size();i++){
			Map mapresult=list.get(i);
			Set set=mapresult.entrySet();
			Iterator it=set.iterator();
			while(it.hasNext()){
				Entry entry =(Entry) it.next();//
				String FileName=(String) entry.getValue();
				TreeItem tt=new TreeItem(t,SWT.None);
				tt.setText(FileName);
			}
		}
	}
	

	
}
