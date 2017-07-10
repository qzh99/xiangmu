package com.yc.ui;

import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.FontDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.internal.win32.OS;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

import com.yc.biz.BackupTable;
import com.yc.biz.CreateExcle;
import com.yc.biz.CreateHtml;
import com.yc.biz.Function;
import com.yc.biz.JavaBean;
import com.yc.dao.DBHelper;
import com.yc.utils.Common;
import com.yc.utils.FileUtil;
import com.yc.utils.LayoutUtil;
import com.yc.utils.TaryUtil;

import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;


public class MainUi {
	protected Display display;
	protected Shell shlPlsqlDeveloper;
	private DBHelper dbh;
	private Composite composite_6;
	private  CTabFolder ctabFolder;
	private CTabFolder ctabFolder_1 ;
	private FileUtil fileUtil=FileUtil.getFileUtil();
	private int screenHeight;
	private int screenWidth;
	private Composite composite_4 ;
	private int cwidht;
	private int cheight;
	private Text text_1;
	private Tree tree;
	private Label lblNewLabel_1;
	private Label lblNewLabel_2;
	private Composite composite;
	private List<Map<String,String>> list1;
	/**
	 * Launch the application.
	 * @param args
	 */


	/**
	 * Open the window.
	 */
	public void open() {
		display = Display.getDefault();
		createContents();
		shlPlsqlDeveloper.open();
		shlPlsqlDeveloper.layout();
		while (!shlPlsqlDeveloper.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		 int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height-20; 
		 int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width+20; 
		shlPlsqlDeveloper = new Shell();
		shlPlsqlDeveloper.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/aa.png"));
		shlPlsqlDeveloper.setSize(screenWidth,screenHeight);
		int height= shlPlsqlDeveloper.getBounds().height;
		int width=shlPlsqlDeveloper.getBounds().width-3;
		shlPlsqlDeveloper.setText("PL/SQL Developer - "+Common.admin.getName()+"@orcl");
		shlPlsqlDeveloper.setLayout(new FillLayout(SWT.HORIZONTAL));
		LayoutUtil.centerShell(display,shlPlsqlDeveloper );
		
		Menu menu = new Menu(shlPlsqlDeveloper, SWT.BAR);
		shlPlsqlDeveloper.setMenuBar(menu);
		
		MenuItem mntmNewSubmenu = new MenuItem(menu, SWT.CASCADE);
		mntmNewSubmenu.setText("File ");
		
		Menu menu_1 = new Menu(mntmNewSubmenu);
		mntmNewSubmenu.setMenu(menu_1);
		
		MenuItem mntmNew = new MenuItem(menu_1, SWT.NONE);
	
		mntmNew.setText("New    ");
		
		MenuItem mntmOpen = new MenuItem(menu_1, SWT.NONE);
		
		mntmOpen.setText("Open");
		
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		
		mntmSave.setText("Save");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmExit = new MenuItem(menu_1, SWT.NONE);
		
		mntmExit.setText("Exit");
		
		MenuItem mntmEdit = new MenuItem(menu, SWT.CASCADE);
		mntmEdit.setText("Edit");
		
		Menu menu_2 = new Menu(mntmEdit);
		mntmEdit.setMenu(menu_2);
		
		MenuItem mntmSelectall = new MenuItem(menu_2, SWT.NONE);
		
		mntmSelectall.setText("Select All");
		
		MenuItem mntmCopy = new MenuItem(menu_2, SWT.NONE);
		
		mntmCopy.setText("Copy");
		
		MenuItem mntmPaste = new MenuItem(menu_2, SWT.NONE);
		
		mntmPaste.setText("Paste");
		
		MenuItem mntmCut = new MenuItem(menu_2, SWT.NONE);
		
		mntmCut.setText("Cut");
		
		MenuItem mntmClear = new MenuItem(menu_2, SWT.NONE);
		
		mntmClear.setText("Clear");
		
		new MenuItem(menu_2, SWT.SEPARATOR);
		
		MenuItem mntmFont = new MenuItem(menu_2, SWT.NONE);
		
		mntmFont.setText("Font");
		
		MenuItem mntmSession = new MenuItem(menu, SWT.CASCADE);
		mntmSession.setText("Session");
		
		Menu menu_9 = new Menu(mntmSession);
		mntmSession.setMenu(menu_9);
		
		MenuItem mntmLogOn = new MenuItem(menu_9, SWT.NONE);

		mntmLogOn.setText("Log on");
		
		MenuItem mntmReprots = new MenuItem(menu, SWT.CASCADE);
		mntmReprots.setText("Reprots");
		
		Menu menu_4 = new Menu(mntmReprots);
		mntmReprots.setMenu(menu_4);
		
		MenuItem mntmBd = new MenuItem(menu_4, SWT.CASCADE);
		mntmBd.setText("BDA");
		
		Menu menu_5 = new Menu(mntmBd);
		mntmBd.setMenu(menu_5);
		
		MenuItem mntmObjects = new MenuItem(menu_4, SWT.CASCADE);
		mntmObjects.setText("Objects");
		
		Menu menu_6 = new Menu(mntmObjects);
		mntmObjects.setMenu(menu_6);
		
		MenuItem mntmPlsql = new MenuItem(menu_4, SWT.CASCADE);
		mntmPlsql.setText("PL/SQL");
		
		Menu menu_7 = new Menu(mntmPlsql);
		mntmPlsql.setMenu(menu_7);
		
		MenuItem mntmUsers = new MenuItem(menu_4, SWT.CASCADE);
		mntmUsers.setText("User");
		
		Menu menu_8 = new Menu(mntmUsers);
		mntmUsers.setMenu(menu_8);
		
		MenuItem mntmBackup = new MenuItem(menu_4, SWT.NONE);
	
		mntmBackup.setText("Backup");
		
		MenuItem mntmRestore = new MenuItem(menu_4, SWT.NONE);
		
		mntmRestore.setText("Restore");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_3 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_3);
		
		MenuItem mntmAbout = new MenuItem(menu_3, SWT.NONE);
		
		mntmAbout.setText("About");
		
		 composite = new Composite(shlPlsqlDeveloper, SWT.BORDER);
		composite.setLayout(null);
		
		SashForm sashForm = new SashForm(composite, SWT.VERTICAL);
		sashForm.setBounds(0, (int) (height*0.05),width-20,(int) (height*0.85) );
		
		Composite composite_2 = new Composite(sashForm, SWT.EMBEDDED);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_1 = new SashForm(composite_2, SWT.NONE);
		Composite composite_3 = new Composite(sashForm_1, SWT.NONE);
		composite_3.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_3 = new SashForm(composite_3, SWT.VERTICAL);
		
		Composite composite_8 = new Composite(sashForm_3, SWT.BORDER);
		composite_8.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		SashForm sashForm_4 = new SashForm(composite_8, SWT.VERTICAL);
		
		Composite composite_9 = new Composite(sashForm_4, SWT.NONE);
		composite_9.setLayout(null);
		
		Combo combo = new Combo(composite_9, SWT.READ_ONLY);
		combo.setBounds((int) (width*0.020), (int) (height*0.05), (int) (width*0.1), 28);
		
		Combo combo_1 = new Combo(composite_9, SWT.READ_ONLY);
		combo_1.setBounds((int) (width*0.020), (int) (height*0.10), (int) (width*0.1), 28);
		
		text_1 = new Text(composite_9, SWT.BORDER);
		text_1.setText("Search");
		text_1.setBounds((int) (width*0.020), (int) (height*0.15), (int) (width*0.1), 28);
		
		Label label = new Label(composite_9, SWT.NONE);
		label.setBounds(30, 48, 0, 2);
		
		Composite composite_10 = new Composite(sashForm_4, SWT.NONE);
		composite_10.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		  tree = new Tree(composite_10, SWT.BORDER);
		  Function.showTree(tree);
		  
		  Menu menu_10 = new Menu(tree);
		  tree.setMenu(menu_10);
		  MenuItem mntmCreateexcle = new MenuItem(menu_10, SWT.NONE);
		  
		  mntmCreateexcle.setText("createExcle");
		  	
		  	composite_4 = new Composite(sashForm_1, SWT.NONE);
		  	composite_4.setLayout(new FillLayout(SWT.HORIZONTAL));
	  			
		  	SashForm sashForm_2 = new SashForm(composite_4, SWT.VERTICAL);
		  		
		  	Composite composite_5 = new Composite(sashForm_2, SWT.BORDER);
		  	composite_5.setLayout(new FillLayout(SWT.HORIZONTAL));
		  			
		  	ctabFolder_1 = new CTabFolder(composite_5, SWT.NONE);
		  			
		  	composite_6 = new Composite(sashForm_2, SWT.BORDER);
		  	composite_6.setLayout(new FillLayout(SWT.HORIZONTAL));
		  			//composite_6.setSize(screenWidth, screenHeight/4);
		  			//MainUi.this.composite_6.setVisible(true);
		  	ctabFolder = new CTabFolder(composite_6, SWT.BORDER);
		  	ctabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		  	ctabFolder.setSimple(false);
		  			
		  	CTabItem tbtmNewItem = new CTabItem(ctabFolder, SWT.NONE);
		  	tbtmNewItem.setText("result");
		  	sashForm_2.setWeights(new int[] {(int) (height*0.85*0.69),(int) (height*0.85*0.29)});
		  	sashForm.setWeights(new int [] {(int) (height*0.85)});
		  	Composite composite_1 = new Composite(composite, SWT.NONE);
		  	composite_1.setSize( width-20,(int) (height*0.05));
		  	composite_1.setLayout(null);
		
		  	lblNewLabel_1 = new Label(composite_1, SWT.BORDER);

		  	lblNewLabel_1.setEnabled(false);
		  	lblNewLabel_1.setBounds(70, 0, 35, 33);
		
		  	lblNewLabel_1.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/提交.PNG"));
		
		  	lblNewLabel_2 = new Label(composite_1, SWT.BORDER);

		  	lblNewLabel_2.setEnabled(false);
		  	lblNewLabel_2.setBounds(125, 0, 35, 32);
		  	lblNewLabel_2.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/回滚.PNG"));
				
				Label lblNewLabel = new Label(composite_1, SWT.BORDER);
				
				lblNewLabel.setImage(SWTResourceManager.getImage(MainUi.class, "/com/yc/ui/Image/执行.PNG"));
				lblNewLabel.setBounds(15, 0,35, 33);
				
				Composite composite_7 = new Composite(composite, SWT.NONE);
 				composite_7.setBounds(0, (int) (height*0.9), width-20, (int) (height*0.03));
			  	
			  	MenuItem mntmJavabean = new MenuItem(menu_10, SWT.NONE);
			
			  	mntmJavabean.setText("javabean");
			  	
			  	MenuItem mntmView = new MenuItem(menu_10, SWT.NONE);
			
			  	mntmView.setText("View");
			  	
			  	MenuItem mntmSelecttable = new MenuItem(menu_10, SWT.NONE);
			
			  	mntmSelecttable.setText("selectTable");

			  	MenuItem mntmFlush = new MenuItem(menu_10, SWT.NONE);
			  	
	  			mntmFlush.setText("Flush");
	  			sashForm_4.setWeights(new int[] {(int) (height*0.85*0.29), (int) (height*0.85*0.69)});
	  			sashForm_1.setWeights(new int []{(int) (width*0.14),(int) (width*0.85)});
	  			
	  			
	  			//托盘
	  			
	  			TaryUtil tu =new TaryUtil() ;
	  			tu.tary(display, shlPlsqlDeveloper);
	  			
	  			//刷新
	  			mntmFlush.addSelectionListener(new SelectionAdapter() {
	  				@Override
	  				public void widgetSelected(SelectionEvent e) {
	  					tree.removeAll();
	  					Function.showTree(tree);

	  				}
	  			});
	  			//直接查看表
	  		  	mntmSelecttable.addSelectionListener(new SelectionAdapter() {
			  		@Override
			  		public void widgetSelected(SelectionEvent e) {
			  			CTabItem[] cTabItem =ctabFolder.getItems();
			  			for(CTabItem ct:cTabItem){
			  				ct.dispose();
			  			}
			  			TreeItem[] t=tree.getSelection();
			  			TreeItem ti=t[0];
			  			 TreeItem tt=ti.getParentItem();
			  			 if(tt==null){
			  				 return;
			  			 }
			  			String parentItemName=tt.getText();
			  			if(parentItemName.equals("Tables")){
			  				String sql="select * from "+ti.getText();
			  				CTabItem ct=new CTabItem(ctabFolder, SWT.CLOSE);
			  				ct.setText(ti.getText());
			  				Table table=new Table(ctabFolder, SWT.BORDER | SWT.FULL_SELECTION);
							ct.setControl(table);
							
							
							table.setHeaderVisible(true);
							table.setLinesVisible(true);
							ctabFolder.setSelection(ct);
							list1=new ArrayList<Map<String,String>>();							
							try {
								list1=Common.dbhelper.find(sql);
							} catch (SQLException e1) {
								MessageDialog.openError(shlPlsqlDeveloper, "错误", e1.getMessage());	
							}	
							if(list1==null||list1.size()<=0){
								return;
							}
							showResult(list1, table);
							Menu menu_11 = new Menu(table);
							table.setMenu(menu_11);
							MenuItem mntmCreateHtml = new MenuItem(menu_11, SWT.NONE);					  
							mntmCreateHtml.setText("createHtml");
							mntmCreateHtml.addSelectionListener(new SelectionAdapter() {
				  				public void widgetSelected(SelectionEvent e) {
				  					FileDialog d = new FileDialog(shlPlsqlDeveloper,SWT.SAVE);   
				  					d.setFilterExtensions(new String []{".html"});
				  					String s =d.open();
				  					if(s==null){
				  						return;
				  					}
				  					File f=new File(s);				
				  					while(true){
				  						if(f.exists()){
				  							boolean b=MessageDialog.openQuestion(shlPlsqlDeveloper,"确认","是否覆盖");
				  							if(b==true){
				  								break;
				  							}else{
				  								s=d.open();
				  								if(s==null){
				  			  						return;
				  			  					}
				  							}			
				  						}else{
				  							break;
				  						}
				  					}
				  					f=new File(s);
				  					CreateHtml.createHtml(list1, f);
				  				}
				  			});
			  			}
			  			
			  		}
			  	});
	  			//生成excle
	  			mntmCreateexcle.addSelectionListener(new SelectionAdapter() {
	  				@Override
	  				public void widgetSelected(SelectionEvent e) {
	  					createExcle();
	  				}
	  			});
	  			//表生成表结构   触发器生成源码
	  		  	mntmView.addSelectionListener(new SelectionAdapter() {
			  		@Override
			  		public void widgetSelected(SelectionEvent e) {
			  			TreeItem[] t=tree.getSelection();
			  			TreeItem ti=t[0];
			  			 TreeItem tt=ti.getParentItem();
			  			 if(tt==null){
			  				 return;
			  			 }
			  			String parentItemName=tt.getText();
			  			if(parentItemName.equals("Triggers")){
			  				CTabItem ctabItem = new CTabItem(ctabFolder_1, SWT.CLOSE);
							ctabItem.setText(ti.getText());
							TextUi textui= new TextUi(ctabFolder_1,SWT.None);
							ctabItem.setControl(textui);
							ctabFolder_1.setSelection(ctabItem);
							String sql="Select Description,Trigger_Body From User_Triggers  where TRIGGER_Name='"+ti.getText()+"'";
							List<Map<String, String>> list=null;
							try {
								 list=Common.dbhelper.find(sql);
							} catch (SQLException e1) {
								MessageDialog.openError(shlPlsqlDeveloper, "错误", e1.getMessage());
							}
							if(list==null||list.size()<=0){
								return;
							}
							Map map=list.get(1);
							Set set= map.entrySet();
							 Iterator it=set.iterator();
							 String [] s=new String[2];
							 int i=0;
							 while(it.hasNext()){
								 Entry entry=(Entry) it.next();
								 entry.getValue();
								 s[i]=	 (String) entry.getValue();
								 i++;
							 }
							 String	s1=s[0];
							String s2=s[1];
							StringBuffer sb=new StringBuffer();
							sb.append("CREATE OR REPLACE TRIGGER "+ ti.getText()+"\n\t"); 
							 sb.append(s1.split("\\n")[1]+"\n");
							 sb.append(s2);
							 textui.getText().setText(sb.toString());
			  			}else if(parentItemName.equals("Tables")){
			  				View v=new View(tree);
			  				v.open();;
			  			}
			  		}
			  	});
		//新建
		mntmNew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem ctabItem = new CTabItem(ctabFolder_1, SWT.CLOSE);
				ctabItem.setText("new  sql");
				TextUi textui= new TextUi(ctabFolder_1,SWT.None);
				ctabItem.setControl(textui);
				//text.setHeaderVisible(true);
			//	table.setLinesVisible(true);
				ctabFolder_1.setSelection(ctabItem);
			}
		});
		shlPlsqlDeveloper.addShellListener(new ShellListener() {


            /**
             * Sent when a shell is minimized. Shell 最小化后事件
             */
            public void shellIconified(org.eclipse.swt.events.ShellEvent e) {
                // 最小化时不显示在任务栏
            	shlPlsqlDeveloper.setVisible(false);
            }

			@Override
			public void shellActivated(ShellEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void shellClosed(ShellEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void shellDeactivated(ShellEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

			@Override
			public void shellDeiconified(ShellEvent arg0) {
				// TODO 自动生成的方法存根
				
			}

        });

		
		//打开
		mntmOpen.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog d=new FileDialog(shlPlsqlDeveloper,SWT.OPEN);
				String s =d.open();
				if(s==null){
					return;
				}
				File file=new File(s);
				 if(file.getName().endsWith(".sql")||file.getName().endsWith(".txt")){
					 		
 		  				if(isOpen(file,ctabFolder_1)){
 		  					return;
 		  				}
 		  				String bs = null;
						bs = fileUtil.readText(file,"GBK");
 		  				CTabItem ctabltem=new CTabItem(ctabFolder_1,SWT.CLOSE);
 		  				ctabltem.setText(file.getName());
 		  				TextUi ed=new TextUi(ctabFolder_1, SWT.None);
 		  				ctabltem.setControl(ed);
 		  				ed.setLayout(new FillLayout(SWT.HORIZONTAL));
 		  				ed.getText().setText(bs);
 		  				ctabFolder_1.setSelection( ctabltem);
 		  			}
				}
		});
		
		//保存   保存为.sql文件  
		mntmSave.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem t= ctabFolder_1.getSelection();
				if(t==null){
					MessageDialog.openInformation(shlPlsqlDeveloper, "提示", "没有可保存文件");
					return;
				}
				FileDialog d = new FileDialog(shlPlsqlDeveloper,SWT.SAVE);  
				d.setFilterExtensions(new String [] {".sql"});
				String s =d.open();
				if(s==null){
					return;
				}
				File f=new File(s);
				while(true){
					if(f.exists()){
						boolean b=MessageDialog.openConfirm(shlPlsqlDeveloper,"提示","文件重名");
						if(b==true){
							break;
						}
						d.open();
					}else{
						break;
					}
					f=new File(s);
				}
				TextUi ed=	(TextUi) t.getControl();
				String ss=ed.getText().getText();
				ed.getText().getForeground();
				fileUtil.savaText(ss, f);
			}
			
		});
		
		//退出
		mntmExit.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.exit(0);
			}
		});
		//提交
		 lblNewLabel_1.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseDown(MouseEvent e) {
			 		boolean result =MessageDialog.openQuestion(shlPlsqlDeveloper, "确认？", "是否确认提交");
			 		if(result==false){
			 			return;
			 		}
			 		try {
			 			Common.dbhelper.con.commit();
						MessageDialog.openInformation(shlPlsqlDeveloper, "提示", "提交成功");
						lblNewLabel_1.setEnabled(false);
						lblNewLabel_2.setEnabled(false);			
					} catch (SQLException e1) {
						MessageDialog.openInformation(shlPlsqlDeveloper, "提示", "提交失败");
					}
			 	}
			 });
		 //回滚
		 lblNewLabel_2.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseDown(MouseEvent e) {
			 		boolean result =MessageDialog.openQuestion(shlPlsqlDeveloper, "确认？", "是否确认回滚");
			 		if(result==false){
			 			return;
			 		} 	
			 		try {
			 			Common.dbhelper.con.rollback();		 		
			 			MessageDialog.openInformation(shlPlsqlDeveloper, "提示", "回滚成功");			 		
						lblNewLabel_1.setEnabled(false);
						lblNewLabel_2.setEnabled(false);			
					} catch (SQLException e1) {
						MessageDialog.openInformation(shlPlsqlDeveloper, "提示", "回滚失败");
					}
			 	}		 	
			 });
		
		//字体
		mntmFont.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				CTabItem ti= ctabFolder_1.getSelection();
				if(ti==null){
					return;
				}
					FontDialog fd=new FontDialog(shlPlsqlDeveloper);
					FontData f=fd.open();
					if(f==null){
						return;
					}
					TextUi ed=	(TextUi) ti.getControl();
					Font ft=new Font(display, f);
					ed.getText().setFont(ft);
					Color color=new Color(display, fd.getRGB());
					ed.getText().setForeground(color);
					
			}	
		});
		
		//关于
		mntmAbout.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Abouts au=new Abouts();
				au.open();
			}
		});
		//登陆
		mntmLogOn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				MainUi.this.shlPlsqlDeveloper.dispose();
				try {
					Logon window = new Logon();
					window.open();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		//生成javabean
	  	mntmJavabean.addSelectionListener(new SelectionAdapter() {
	  		public void widgetSelected(SelectionEvent e) {
	  			javaBean();		
					
	  		}
	  	});
	  	//执行
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				zhixing();
			}
			
		});
		
		//备份
		mntmBackup.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				BackupTable b=new BackupTable();
				b.open();
			}
		});
		//还原
		mntmRestore.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog d = new FileDialog(shlPlsqlDeveloper, SWT.OPEN);
				// d.setFilterExtensions(new String [] {".dmp"});
				String s = d.open();
				if (s == null || "".equals(s)) {
					return;
				}
				String username = Common.admin.getName();
				String userPwd = Common.admin.getPwd();
				String imp = "imp " + username + "/" + userPwd + "@orcl file="
						+ s + " full=y ";
				Common.linkCmd(imp);
				MessageDialog.openInformation(shlPlsqlDeveloper, "提示","还原成功");
			}
		});
	}
//是否打开
	
	
	
	
protected boolean isOpen(File f, CTabFolder ctabFolder) {
	CTabItem[] tb=ctabFolder.getItems();
	for(CTabItem t : tb){
		if(t.getText().equals(f.getName())){
			return true;
		}
	}
	return false;
}
	//显示结果
	protected void showResult(List<Map<String, String>> list, Table table) {
		TableColumn tct=new TableColumn(table,SWT.BORDER);
		tct.pack();
		tct.setWidth(50);
		tct.setText("");
		Map<String,String>map=list.get(0);
		Set set=map.entrySet();
		Iterator it=set.iterator();
		while(it.hasNext()){
			Entry entry =(Entry) it.next();
			TableColumn tc=new TableColumn(table,SWT.NONE);
			tc.setWidth(100);
			tc.setText((String)entry.getKey()+"("+((String)entry.getValue()).toLowerCase()+")");
		}
		Integer j=new Integer(1);
		
		for(int i=1;i<list.size();i++){
			Map mapResult=list.get(i);
			TableItem ti=new TableItem(table,SWT.NONE);
			set=mapResult.entrySet();
			it=set.iterator();
			String [] strings=new String [map.size()+1];
			strings[0]=j.toString();
			int z=1;
			while(it.hasNext()){
				Entry entry =(Entry) it.next();
				strings [z]=(String) entry.getValue();
				z++;
			}
			j++;
			ti.setText(strings);
		}
	}
	
	
	//执行按钮
	private void zhixing() {
		CTabItem ctt=ctabFolder_1.getSelection();
		if(ctt==null){
			return;
		}
		TextUi ti=(TextUi) ctt.getControl();
		Text text=ti.getText();
		String sqls=text.getSelectionText().trim();
		CTabItem[] cTabItem =ctabFolder.getItems();
		if(cTabItem==null||cTabItem.length<=0){
			return;
		}
		for(CTabItem ct:cTabItem){
			ct.dispose();
		}
		if(sqls==null||"".equals(sqls)){
			sqls=text.getText().trim();
		}
		if(sqls==null||sqls.equals("")){
			return;
		}
		String [] everone=sqls.split(";");
		if(everone==null||everone.length<=0){
			return;
		}
		for(String temp:everone){
			CTabItem ct=new CTabItem(ctabFolder, SWT.CLOSE);
			ct.setText("result");
			String sql=temp.trim().toUpperCase();
			if(sql.startsWith("INSERT")||sql.startsWith("UPDATE")||sql.startsWith("DALETE")){
					int result;
					Text text1=new Text(ctabFolder, SWT.BORDER | SWT.FULL_SELECTION);
					ct.setControl(text1);
					ctabFolder.setSelection(ct);
					
					try {
						result = Common.dbhelper.doUpdate(sql);
						if(result>0){
							lblNewLabel_1.setEnabled(true);
							lblNewLabel_2.setEnabled(true);
							text1.setText("操作成功");
						}
					} catch (SQLException e1) {
						text1.setText("操作失败");
						MessageDialog.openError(shlPlsqlDeveloper, "错误", e1.getMessage());
					}
			}else if(sql.startsWith("CREATE")||sql.startsWith("GRANT")||sql.startsWith("REVOKE")||
				sql.startsWith("DROP")||sql.startsWith("ALTER")||sql.startsWith("COMMIT")){
					
				Text text1=new Text(ctabFolder, SWT.BORDER | SWT.FULL_SELECTION);
				ct.setControl(text1);
				ctabFolder.setSelection(ct);
				boolean result;
					try {
					result = Common.dbhelper.doDDL(sql);
					if(result==false){
						text1.setText("操作成功");	
					}
				} catch (SQLException e1) {
					text1.setText("操作失败");
					MessageDialog.openError(shlPlsqlDeveloper, "错误", e1.getMessage());
				}
			}else if(sql.startsWith("SELECT")){
				Table table=new Table(ctabFolder, SWT.BORDER | SWT.FULL_SELECTION);
				ct.setControl(table);
				table.setHeaderVisible(true);
				table.setLinesVisible(true);
				ctabFolder.setSelection(ct);
				list1=new ArrayList<Map<String,String>>();							
				try {
					list1=Common.dbhelper.find(sql);
				} catch (SQLException e1) {
					Text text1=new Text(ctabFolder, SWT.BORDER | SWT.FULL_SELECTION);
					ct.setControl(text1);
					ctabFolder.setSelection(ct);
					text1.setText("操作失败");
					MessageDialog.openError(shlPlsqlDeveloper, "错误", e1.getMessage());	
				}	
				if(list1==null||list1.size()<=0){
					return;
				}
				showResult(list1, table);
				Menu menu_11 = new Menu(table);
				table.setMenu(menu_11);
				MenuItem mntmCreateHtml = new MenuItem(menu_11, SWT.NONE);					  
				mntmCreateHtml.setText("createHtml");
				mntmCreateHtml.addSelectionListener(new SelectionAdapter() {
	  				public void widgetSelected(SelectionEvent e) {
	  					FileDialog d = new FileDialog(shlPlsqlDeveloper,SWT.SAVE);   
	  					d.setFilterExtensions(new String []{".html"});
	  					String s =d.open();
	  					if(s==null){
	  						return;
	  					}
	  					File f=new File(s);				
	  					while(true){
	  						if(f.exists()){
	  							boolean b=MessageDialog.openQuestion(shlPlsqlDeveloper,"确认","是否覆盖");
	  							if(b==true){
	  								break;
	  							}else{
	  								s=d.open();
	  								if(s==null){
	  			  						return;
	  			  					}
	  							}			
	  						}else{
	  							break;
	  						}
	  					}
	  					f=new File(s);
	  					CreateHtml.createHtml(list1, f);
	  				}
	  			});
				
			}else{
				Text text1=new Text(ctabFolder, SWT.BORDER | SWT.FULL_SELECTION);
				ct.setControl(text1);
				ctabFolder.setSelection(ct);
				boolean result;
					try {
					result = Common.dbhelper.doDDL(sql);
					if(result==false){
						text1.setText("操作成功");	
					}
				} catch (SQLException e1) {
					text1.setText("操作失败");
					MessageDialog.openError(shlPlsqlDeveloper, "错误", e1.getMessage());

				}
			}
		}
	}
//生成excle
	protected void createExcle() {
		TreeItem[] t=tree.getSelection();
		TreeItem ti=t[0];
		 TreeItem tt=ti.getParentItem();
		 if(tt==null){
			 return;
		 }
		String parentItemName=tt.getText();
		if(parentItemName.equals("Tables")){
			String ulr=null;
			while(true){						
				FileDialog dialog = new FileDialog(shlPlsqlDeveloper,SWT.SAVE);   
				dialog.setFilterPath("c:\\windows");//设置初始路径   
				dialog.setFilterExtensions(new String [] {".xls"});
				ulr=dialog.open();
				if(ulr==null||ulr.equals("")){
					return;
				}
				File file=new File(ulr);
				if(file.exists()){
					boolean b=MessageDialog.openQuestion(shlPlsqlDeveloper, "提示", "文件已存在,是否覆盖");
					if(b==true){
						break;
					}
				}else{
					break;
				}
			}
			String sql="select  *  from "+ti.getText();
			List <Map<String ,String >>list=null;
			try {
				list = Common.dbhelper.find(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
			try {
				CreateExcle.createExcle(ulr,ti.getText(),list);
			} catch (Exception e1) {
				MessageDialog.openInformation(shlPlsqlDeveloper, "提示", "创建失败");
			}
		}
	}
//生成javaBean
	protected void javaBean() {
		TreeItem[] t=tree.getSelection();
			TreeItem ti=t[0];
			 TreeItem tt=ti.getParentItem();
			 if(tt==null){
				 return;
			 }
			String parentItemName=tt.getText();
			File file=null;
			if(parentItemName.equals("Tables")){
				while(true){						
					FileDialog dialog = new FileDialog(shlPlsqlDeveloper,SWT.SAVE);   
					dialog.setFilterPath("c:\\windows");//设置初始路径   
					dialog.setFilterExtensions(new String [] {".java"});
					String ulr=dialog.open();
					if(ulr==null||ulr.equals("")){
						return;
					}
					 file=new File(ulr);
					if(file.exists()){
						boolean b=MessageDialog.openQuestion(shlPlsqlDeveloper, "提示", "文件已存在,是否覆盖");
						if(b==true){
							file.delete();
							try {
								file.createNewFile();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							break;
						}
					}else{
						break;
					}
				}
				JavaBean.createJavaBean(ti.getText(), file);
			}
	}
}
