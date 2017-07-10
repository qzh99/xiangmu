package com.yc.biz;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.yc.utils.Common;

public class BackupTable {

	protected Shell shlBuckupsTable;
	private Table table;
	private Combo comb;
	private String [] s;


	/**
	 * Launch the application.
	 * @param args
	 */


	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlBuckupsTable.open();
		shlBuckupsTable.layout();
		while (!shlBuckupsTable.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlBuckupsTable = new Shell(SWT.CLOSE);
		shlBuckupsTable.setImage(SWTResourceManager.getImage(BackupTable.class, "/com/yc/ui/Image/aa.png"));
		shlBuckupsTable.setSize(488, 338);
		shlBuckupsTable.setText("buckups table");
		
		Composite composite = new Composite(shlBuckupsTable, SWT.NONE);
		composite.setBounds(0, 0, 482, 309);
		
		table = new Table(composite, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(10, 10, 462, 220);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("Name");
		
		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(350);
		tblclmnNewColumn_1.setText("Value");
		
		TableItem tableItem = new TableItem(table, SWT.NONE);
		
		tableItem.setText(new String[]{"table owner",Common.admin.getName()} );
		
		TableItem tableItem1 = new TableItem(table, SWT.NONE);
		tableItem1.setText("table name");
		TableEditor editor = new TableEditor(table);
		 comb = new Combo(table, SWT.READ_ONLY);
		 editor.grabHorizontal = true;
		 editor.setEditor(comb, tableItem1, 1);
		 
		 Button btnNewButton = new Button(composite, SWT.NONE);
	
		 btnNewButton.setBounds(89, 255, 80, 27);
		 btnNewButton.setText("OK");
		 
		 String sql="select TABLE_NAME from user_tables";
		 s=setComboItem(sql);
		 comb.setItems(s);
		 Button btnNewButton_1 = new Button(composite, SWT.NONE);
		 btnNewButton_1.setBounds(283, 255, 80, 27);
		 btnNewButton_1.setText("Cancel");
		 btnNewButton.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseDown(MouseEvent e) {
					int index=comb.getSelectionIndex();
					if(index<=0){
						return ;
					}
					String tableName=s[index];
					FileDialog d = new FileDialog(shlBuckupsTable,SWT.SAVE);   
					d.setFilterExtensions(new String [] {".dmp"});
					String s =d.open();//路径
					if(s==null||"".equals(s)){
						return ;
					}
					
					File file=new File(s);
					if(file.exists()){
						boolean choice=MessageDialog.openQuestion(shlBuckupsTable, "提示","文件已经存在是否覆盖");
						if(choice==false){
							return;
						}
					}
					
					String username=Common.admin.getName();
					String userPwd=Common.admin.getPwd();
					
					String exp="exp "+username+"/"+userPwd+"@orcl file="+s+" tables=("+tableName+")";
					 try {
						Process p=Runtime.getRuntime().exec(exp.toString());
						 InputStreamReader isr = new InputStreamReader(p.getErrorStream());
						 BufferedReader br = new BufferedReader(isr);
						 String line = null; 
						 while ((line = br.readLine()) != null){ 
							 if(line.indexOf("错误")!=-1){ 
							 break; 
							 } 
						 }
						 shlBuckupsTable.dispose();
						 p.destroy();
						 p.waitFor();					 
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			 	}
			 });

	}
	private static String [] setComboItem(String sql) {
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		try {
			list = Common.dbhelper.find(sql);
			if(list==null||list.size()<=1){
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String [] s=new String [list.size()];
		s[0]="%";
		for(int i=1;i<list.size();i++){
			Map mapresult=list.get(i);
			Set set=mapresult.entrySet();
			Iterator it=set.iterator();
			while(it.hasNext()){
				Entry entry =(Entry) it.next();//
				String TableName=(String) entry.getValue();
				s[i]=TableName;				
			}
		}
		return s;
	}
}
