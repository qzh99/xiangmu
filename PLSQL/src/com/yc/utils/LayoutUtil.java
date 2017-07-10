package com.yc.utils;

import java.awt.Toolkit;

import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class LayoutUtil {
	 public static void centerShell(Display display,Shell shell){ 
	        Rectangle displayBounds = display.getPrimaryMonitor().getBounds(); 
	        Rectangle shellBounds = shell.getBounds(); 
	        int x = displayBounds.x + (displayBounds.width - shellBounds.width)>>1; 
	        int y = displayBounds.y + (displayBounds.height - shellBounds.height)>>1; 
	        shell.setLocation(x, y); 
	    } 
	 
	 public static void centerShell1(Display display,Shell shell){
	  //得到屏幕的宽度和高度 
	  int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height; 
	  int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width; 
	  //得到Shell窗口的宽度和高度
	  int shellHeight = shell.getBounds().height; 
	  int shellWidth = shell.getBounds().width; 
	  //如果窗口大小超过屏幕大小，让窗口与屏幕等大 
	  if(shellHeight > screenHeight) 
	                    shellHeight = screenHeight; 
	  if(shellWidth > screenWidth) 
	                   shellWidth = screenWidth; 
	  //让窗口在屏幕中间显示 
	         shell.setLocation(( (screenWidth - shellWidth) / 2),((screenHeight - shellHeight) / 2) ); 
	 } 

}
