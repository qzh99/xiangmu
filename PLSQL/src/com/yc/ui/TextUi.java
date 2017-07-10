package com.yc.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.AutoCompleteField;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.jface.fieldassist.SimpleContentProposalProvider;
import org.eclipse.jface.fieldassist.TextContentAdapter;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.FillLayout;

public class TextUi extends Composite {
	private Text text_1;

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public TextUi(Composite parent, int style) {
		super(parent, style);
		setLayout(new FillLayout(SWT.HORIZONTAL));
		
		text_1 = new Text(this, SWT.BORDER | SWT.WRAP | SWT.H_SCROLL | SWT.V_SCROLL | SWT.CANCEL);
		text_1.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent arg0) {
				String temp = text_1.getText();
				//输入的文本框末尾不能为空    且它的前面是空字符
				int len = temp.length();
				if(len<3){
					return ;
				}
				if((!(temp.charAt(len-1)+"").equals(" "))&&((temp.charAt(len-2)+"").equals(" "))  ||((temp.charAt(len-2)+"").equals("\n"))){
					addNameTextFieldAssist(text_1);				
				}
			}
		});
		addNameTextFieldAssist(text_1);
	}
	public Text getText(){
		return text_1;
	}
	
	
	
	private void addNameTextFieldAssist(Text text) {
    	TextContentAdapter ad = new TextContentAdapter(){
    		/**
    		 * 在控件中添加该关键字
    		 * @param control
    		 * @param text
    		 * @param cursorPosition
    		 */
    		@Override
			public void insertControlContents(Control control, String text,int cursorPosition) {
    			Point selection = ((Text) control).getSelection();
		        ((Text) control).insert(text);
		        if (cursorPosition < text.length()) {
		        	((Text) control).setSelection(selection.x + cursorPosition,  selection.x + cursorPosition);
		        }
			}
			// * 设置关键字
			public void setControlContents(Control control, String text,int cursorPosition) {
    			int len = text_1.getText().lastIndexOf(" ");
    			int len1=text_1.getText().lastIndexOf("\n");
    			if(len1>len){
    				len=len1;
    			}
    			String temp = text_1.getText();
    			if(len==-1){
    				super.setControlContents(control, text, cursorPosition);
    			}else{
					temp = temp.substring(0, len+1);
					temp = temp.concat(text);
				super.setControlContents(control, temp, cursorPosition);
				 len=text_1.getText().length();
				 text_1.setSelection(len);
    			}
    			
    		}
    		 //* 处理搜索关键字
			//@Override
			public String getControlContents(Control control) {
				int len = text_1.getText().lastIndexOf(" ");
    			int len1=text_1.getText().lastIndexOf("\n");
    			if(len1>len){
    				len=len1;
    			}
				String temp = ((Text) control).getText();
				temp = temp.substring(len+1);
				return temp;
			}
			public Point getSelection(Control control){
				Point p= super.getSelection(text_1);
				return p;
			}
			@Override
			public Rectangle getInsertionBounds(Control control) {
				return super.getInsertionBounds(control);
			}
		//	@Override
			public void setSelection(Control control, Point range) {
				super.setSelection(control, range);
			}
    	};
    	
    	
    	
    	
    	
    	AutoCompleteField au = new AutoCompleteField(text_1,ad , new String[]{});
    	
    	List<String> list = new ArrayList<String>();
    	list.add("select");
    	list.add("drop");
    	list.add("delete");
    	list.add("update");
    	list.add("from");
    	list.add("alter");
    	list.add("create");
    	list.add("table");
    	list.add("where");
    	
    	
    	String strs[] = new String[list.size()];
	    for (int i = 0; i < strs.length; i++) {
			strs[i] = list.get(i).toLowerCase();
		}
	    au.setProposals(strs);
    }

}
