package com.yc.ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.prefs.BackingStoreException;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

import com.yc.bean.Admin;
import com.yc.biz.Function;
import com.yc.dao.DBHelper;
import com.yc.utils.Common;
import com.yc.utils.LayoutUtil;
import com.yc.utils.PicUtil;
import com.yc.utils.RegistrationUtils;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.widgets.Group;



public class Logon {
	protected Shell shlDatabaseLogon;
	private Display display;
	private Text passwordText;
	private Text text;
	private Combo UsernameCombo;
	private DBHelper db;
	private Connection con;
	private Text text_1;
	private Text text_2;
	
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Logon window = new Logon();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlDatabaseLogon.open();
		shlDatabaseLogon.layout();
		while (!shlDatabaseLogon.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlDatabaseLogon = new Shell(display,SWT.DIALOG_TRIM);   //让窗口保持固定大小
		shlDatabaseLogon.setImage(SWTResourceManager.getImage(Logon.class, "/com/yc/ui/Image/aa.png"));
		shlDatabaseLogon.setSize(450, 297);
		shlDatabaseLogon.setText("Database Logon");
		shlDatabaseLogon.setLayout(new FillLayout(SWT.HORIZONTAL));
		LayoutUtil.centerShell1(display, shlDatabaseLogon);
		Composite composite = new Composite(shlDatabaseLogon, SWT.NONE);
		composite.setLayout(new FormLayout());
		
		Composite composite_1 = new Composite(composite, SWT.BORDER);
		FormData fd_composite_1 = new FormData();
		fd_composite_1.right = new FormAttachment(0, 422);
		composite_1.setLayoutData(fd_composite_1);
		
		Button btnNewButton = new Button(composite, SWT.NONE);
		fd_composite_1.bottom = new FormAttachment(btnNewButton, -6);

		FormData fd_btnNewButton = new FormData();
		btnNewButton.setLayoutData(fd_btnNewButton);
		btnNewButton.setText("OK");
		
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		fd_btnNewButton.top = new FormAttachment(btnNewButton_1, 0, SWT.TOP);
		fd_btnNewButton.right = new FormAttachment(btnNewButton_1, -108);
		
		FormData fd_btnNewButton_1 = new FormData();
		fd_btnNewButton_1.bottom = new FormAttachment(100, -10);
		fd_btnNewButton_1.right = new FormAttachment(100, -47);
		fd_btnNewButton_1.left = new FormAttachment(0, 317);
		btnNewButton_1.setLayoutData(fd_btnNewButton_1);
		btnNewButton_1.setText("Cancel");
		
		Composite composite_2 = new Composite(composite, SWT.NONE);
		fd_btnNewButton.left = new FormAttachment(composite_2, 35);
		fd_composite_1.left = new FormAttachment(composite_2, 6);
		FormData fd_composite_2 = new FormData();
		fd_composite_2.bottom = new FormAttachment(100, -48);
		fd_composite_2.top = new FormAttachment(0, 47);
		fd_composite_2.right = new FormAttachment(0, 121);
		fd_composite_2.left = new FormAttachment(0, 10);
		composite_2.setLayoutData(fd_composite_2);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel_1 = new Label(composite_2, SWT.NONE);
		lblNewLabel_1.setImage(SWTResourceManager.getImage(Logon.class, "/com/yc/ui/Image/aa.png"));
			
		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		fd_composite_1.top = new FormAttachment(lblNewLabel_2, 6);
		
		Label lblUser = new Label(composite_1, SWT.NONE);
		lblUser.setBounds(10, 10, 70, 20);
		lblUser.setText("Username");
		
		UsernameCombo = new Combo(composite_1, SWT.NONE);
		UsernameCombo.setBounds(88, 7, 193, 25);
		init(UsernameCombo);
		
		Label lblPassword = new Label(composite_1, SWT.NONE);
		lblPassword.setBounds(10, 43, 70, 20);
		lblPassword.setText("Password");
		
		passwordText = new Text(composite_1, SWT.BORDER | SWT.PASSWORD);
		passwordText.setBounds(88, 40, 193, 25);
		
		Label lblNewLabel3 = new Label(composite_1, SWT.NONE);
		lblNewLabel3.setBounds(10, 76, 70, 20);
		lblNewLabel3.setText("Ip");
		
		text = new Text(composite_1, SWT.BORDER);
		text.setBounds(88, 73, 193, 25);
		text.setText("127.0.0.1");
		
		Label lblDriver = new Label(composite_1, SWT.NONE);
		lblDriver.setBounds(10, 109, 70, 20);
		lblDriver.setText("Driver");
		
		text_1 = new Text(composite_1, SWT.BORDER);
		text_1.setBounds(88, 106, 193, 25);
		text_1.setText("oracle");
		
		Label lblNewLabel_3 = new Label(composite_1, SWT.NONE);
		lblNewLabel_3.setBounds(10, 142, 70, 20);
		lblNewLabel_3.setText("DBname");
		
		text_2 = new Text(composite_1, SWT.BORDER);
		text_2.setBounds(88, 139, 193, 25);
		text_2.setText("orcl");
		
		lblNewLabel_2.setFont(SWTResourceManager.getFont("微软雅黑", 17, SWT.BOLD));
		lblNewLabel_2.setAlignment(SWT.CENTER);
		FormData fd_lblNewLabel_2 = new FormData();
		fd_lblNewLabel_2.bottom = new FormAttachment(100, -221);
		fd_lblNewLabel_2.top = new FormAttachment(0, 10);
		fd_lblNewLabel_2.right = new FormAttachment(0, 366);
		fd_lblNewLabel_2.left = new FormAttachment(0, 173);
		lblNewLabel_2.setLayoutData(fd_lblNewLabel_2);
		lblNewLabel_2.setText("PL/SQL");		
		//取消
		
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		//登录
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {

				String username=UsernameCombo.getText();
				String password=passwordText.getText();
				String driver =text_1.getText();
				String  ip    =text_2.getText();
				String  oname =text.getText();
				
				if(username==null||username.equals("")  ||    password==null|| password.equals("")){
					MessageDialog.openInformation(shlDatabaseLogon , "提示" , "用户名或密码不能为空");
					return;
				}
				if(ip==null||ip.equals("")){
					MessageDialog.openInformation(shlDatabaseLogon , "提示" ,"ip地址不能为空");
					return;
				}
				if(driver==null||driver.equals("")){
					MessageDialog.openInformation(shlDatabaseLogon , "提示" ,"数据库类型不能为空");
					return;
				}
				if(oname==null||oname.equals("")){
					MessageDialog.openInformation(shlDatabaseLogon , "提示" ,"数据库名不能为空");
					return;
				}
				 try {
					 Common.dbhelper=new DBHelper();
					 Common.dbhelper.setCon(username, password, driver ,ip ,oname);
				} catch (SQLException e2) {
					MessageDialog.openError(shlDatabaseLogon, "PL/SQL Developer", e2.getMessage());
				}
				if(Common.dbhelper.con!=null){               
						try {
							Common.admin=new Admin(username, password);
							Logon.this.shlDatabaseLogon.setVisible(false);
							if(isexist(username)==false){
								Map<String,String > map=new HashMap();
								map.put(username,driver );
								RegistrationUtils.saveRegistration(map);
							}
							Logon.this.shlDatabaseLogon.dispose();
							MainUi window = new MainUi();
							window.open();
						} catch (Exception e1) {	
							MessageDialog.openError(shlDatabaseLogon, "错误", "登录失败");
						}
					}
				}

				
		});
	}
	//是否已保存用户名
	protected boolean isexist(String username) {
		try {
			String name []=RegistrationUtils.findRegistration();
			if(name!=null&&name.length>0){
				for(String sname:name){
					if(sname.equals(username)){
						return true;
					}
				}
				return false;
			}
		} catch (BackingStoreException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	//讲保存的用户名显示到Combo
	private void init(Combo Combo) {
			String[] name;
			try {
				name = RegistrationUtils.findRegistration();
				if(name!=null&&name.length>0){
					UsernameCombo.setItems(name);
					UsernameCombo.select(0);
				}
			} catch (BackingStoreException e) {
				e.printStackTrace();
			}		
	}
}
