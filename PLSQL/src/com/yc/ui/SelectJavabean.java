package com.yc.ui;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

import com.yc.utils.Common;

public class SelectJavabean {

	protected Shell shell;
	private Map<String,String> map;  //传过来的
	private List<Button> list1;
	public  Map<String,String> returnmap=new LinkedHashMap();
	private Button btnCheckButto;
	private Button btnCheckButto1;

	/**
	 * Launch the application.
	 * @param args
	 */

	public SelectJavabean(Map<String,String> map){
		this.map=map;
	}
	/**
	 * Open the window.
	 */
	
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(450, 572);
		shell.setText("select get() and set()");
		
		Group group = new Group(shell, SWT.NONE);
		group.setBounds(25, 32, 272, 343);
		
		 btnCheckButto = new Button(shell, SWT.CHECK);
		
		btnCheckButto.setBounds(313, 84, 98, 17);
		btnCheckButto.setText("全选");
		
		btnCheckButto1 = new Button(shell, SWT.CHECK);
	
		btnCheckButto1.setBounds(313, 138, 98, 17);
		btnCheckButto1.setText("全不选");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
	
		btnNewButton.setBounds(180, 480, 80, 27);
		btnNewButton.setText("确定");
		 list1=new ArrayList<Button>();
		
	
		Set set=map.entrySet();
		Iterator it=set.iterator();
		int i=1;
		while(it.hasNext()){
			Entry entry =(Entry) it.next();
			Button btnCheckButton1 = new Button(group, SWT.CHECK);
			btnCheckButton1.setBounds(10,20*i , 100, 20);
			btnCheckButton1.setText((String) entry.getKey());
			list1.add(btnCheckButton1);
			i++;
		}
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				for(int i=0;i<list1.size();i++){
					Button btnCheckButton2=(Button) list1.get(i);
					if(btnCheckButton2.getSelection()){
						btnCheckButton2.getText();
						String s=map.get(btnCheckButton2.getText());
						returnmap.put(btnCheckButton2.getText(), s);
					}
				}
				Common.returnmap=returnmap;
				shell.dispose();

			}
		});
		//
		btnCheckButto.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnCheckButto.getSelection()){
					btnCheckButto1.setSelection(false);
					for(int i=0;i<list1.size();i++){
						Button btnCheckButton2=(Button) list1.get(i);
						btnCheckButton2.setSelection(true);
					}
				}
			}
		});
		//
		btnCheckButto1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if(btnCheckButto1.getSelection()){
					btnCheckButto.setSelection(false);
					for(int i=0;i<list1.size();i++){
						Button btnCheckButton2=(Button) list1.get(i);
						btnCheckButton2.setSelection(false);
					}
				}
			}
		});
	}
}
