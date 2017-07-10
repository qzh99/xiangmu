package com.yc.utils;

import java.awt.event.MouseEvent;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Tray;
import org.eclipse.swt.widgets.TrayItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.wb.swt.SWTResourceManager;


public class TaryUtil {
	private Tray tray;		
	private TrayItem ti;
	public   void tary(Display display,final Shell shell){
		tray = display.getSystemTray();
		if(tray==null){
			MessageDialog.openError(shell, "错误提示", "您的系统暂不支持托盘");
		}else{
			ti=new TrayItem(tray,SWT.NONE);
			ti.setToolTipText("PL/SQL");
			ti.setImage(SWTResourceManager.getImage(TaryUtil.class, "/com/yc/ui/Image/aa.png"));
			
			final Menu menu=new Menu(shell,SWT.POP_UP);
			
			//最大化
			MenuItem menuItemMaximize = new MenuItem(menu, SWT.PUSH);// 最大化菜单
			menuItemMaximize.setText("最大化");
			menuItemMaximize.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {  //widget：装饰、小部件
					shell.setVisible(true);
					shell.setMaximized(true);
				}

				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			//最小化
			MenuItem menuItemMinimize = new MenuItem(menu, SWT.PUSH);// 最小化菜单
			menuItemMinimize.setText("最小化");
			menuItemMinimize.addSelectionListener(new SelectionListener() {
				public void widgetSelected(SelectionEvent e) {
					shell.setMinimized(true);
				}
				public void widgetDefaultSelected(SelectionEvent e) {
				}
			});
			//分割条
			new MenuItem(menu,SWT.SEPARATOR);
			//退出
			MenuItem MenuItem=new MenuItem(menu,SWT.PUSH);
			MenuItem.setText("退出");
			MenuItem.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
					if(!shell.isDisposed()){
						shell.dispose();
						ti.dispose();
						System.exit(0);
					}
					
				}
			});
			//
			ti.addListener(SWT.MenuDetect,new Listener(){
				public void handleEvent(Event arg0) {
					if(!shell.isDisposed()){
					menu.setVisible(true);
					}
				}
			});
			//点击托盘图标取消最小化 
			
			ti.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
					shell.setMinimized(false);
					shell.setVisible(true);
				}
			});
		}
	}
}
