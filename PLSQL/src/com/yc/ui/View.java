package com.yc.ui;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.TableColumn;

import com.yc.utils.Common;

import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;

public class View {

	protected Shell shlView;
	private SashForm sashForm;
	private Composite composite;
	private Composite composite_1;
	private Tree tree;
	private Button btnNewButton_1;

	private List<Text> list1 = new ArrayList<Text>();// 存动态生成的text
	private List<Map<String, String>> list = null;
	private List<String> list2 = new ArrayList<String>();// 存列名

	private Button button;
	private TreeItem ti;//
	private Composite composite_2;
	private Table table;
	private TabFolder tabFolder;
	private TabItem tabItem;

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlView.open();
		shlView.layout();
		while (!shlView.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	public View(Tree tree) {
		this.tree = tree;
	}

	/**
	 * Create contents of the window.
	 * 
	 * @wbp.parser.entryPoint
	 */
	protected void createContents() {
		shlView = new Shell();
		shlView.setText("View");
		shlView.setSize(742, 588);
		shlView.setLayout(new FillLayout(SWT.HORIZONTAL));

		sashForm = new SashForm(shlView, SWT.VERTICAL);

		TreeItem[] t = tree.getSelection();
		ti = t[0];

		composite_2 = new Composite(sashForm, SWT.NONE);
		composite_2.setLayout(new FillLayout(SWT.HORIZONTAL));

		tabFolder = new TabFolder(composite_2, SWT.NONE);

		tabItem = new TabItem(tabFolder, SWT.NONE);
		tabItem.setText("result");

		table = new Table(tabFolder, SWT.BORDER | SWT.FULL_SELECTION
				| SWT.HIDE_SELECTION);

		tabItem.setControl(table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		composite = new Composite(sashForm, SWT.NONE);
		composite.setLayout(null);

		composite_1 = new Composite(sashForm, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));

		button = new Button(composite_1, SWT.NONE);

		button.setText("增加");

		Button btnNewButton = new Button(composite_1, SWT.NONE);

		btnNewButton.setText("更新");

		btnNewButton_1 = new Button(composite_1, SWT.NONE);

		btnNewButton_1.setText("删除");
		sashForm.setWeights(new int[] {319, 142, 74});

		widgetSelected();
		getLieMing();

		// 增加按钮
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				StringBuffer sb = new StringBuffer();
				sb.append("insert into " + ti.getText() + " values(");
				for (int i = 0; i < list1.size() - 1; i++) {
					sb.append("?,");
				}
				sb.append("?)");
				try {
					PreparedStatement pstmt = Common.dbhelper.con
							.prepareStatement(sb.toString());
					for (int i = 1; i <= list1.size(); i++) {
						pstmt.setString(i, list1.get(i - 1).getText());
					}
					pstmt.executeUpdate();
					Common.dbhelper.con.commit();
					initTable();
				} catch (SQLException e1) {
					MessageDialog.openError(shlView, "错误", e1.getMessage());
				}
			}
		});

		// 删除按钮
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] t = table.getSelection();
				if (t == null || t.length <= 0) {
					MessageDialog.openError(shlView, "错误", "请选择删除项");

					return;
				}
				TableItem ta = t[0];
				StringBuffer sb = new StringBuffer();
				sb.append("delete from ");
				sb.append(ti.getText());
				sb.append(" where ");
				for (int i = 1; i < list2.size(); i++) {
					sb.append(list2.get(i - 1) + "=? and ");
				}
				sb.append(list2.get(list1.size() - 1) + "=?");
				try {
					PreparedStatement pstmt = Common.dbhelper.con
							.prepareStatement(sb.toString());
					for (int i = 1; i <= list2.size(); i++) {
						pstmt.setString(i, ta.getText(i));
						// delete from ASDF where AID=?,ANAME=?
					}
					pstmt.executeUpdate();
					Common.dbhelper.con.commit();
					initTable();
				} catch (SQLException e1) {
					MessageDialog.openError(shlView, "错误", e1.getMessage());
				}

			}
		});

		// 更新按钮
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] t = table.getSelection();
				if (t == null || t.length <= 0) {
					MessageDialog.openError(shlView, "错误", "请选择更新项");

					return;
				}
				TableItem ta = t[0];
				ti.getText();// 表名
				// update ti.getText() set ?=? where ?=?
				StringBuffer sb = new StringBuffer();
				sb.append("update " + ti.getText() + " set ");
				for (int i = 1; i < list1.size(); i++) {
					sb.append(list2.get(i - 1) + "=?,");
				}
				sb.append(list2.get(list2.size() - 1) + "=?");
				sb.append(" where ");
				for (int i = 1; i < list1.size(); i++) {
					sb.append(list2.get(i - 1) + "=? and ");

				}
				sb.append(list2.get(list1.size() - 1) + "=? ");

				try {
					PreparedStatement pstmt = Common.dbhelper.con
							.prepareStatement(sb.toString());
					for (int i = 1; i <= list1.size(); i++) {
						pstmt.setString(i, list1.get(i - 1).getText());
					}
					for (int i = 1; i <= list1.size(); i++) {
						pstmt.setString(list1.size() + i, ta.getText(i));
					}
					pstmt.executeUpdate();
					Common.dbhelper.con.commit();
					initTable();
				} catch (SQLException e1) {
					MessageDialog.openError(shlView, "错误", e1.getMessage());
				}
			}
		});

		// 显示内容到text中
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				TableItem[] tab = table.getSelection();
				if (tab == null || tab.length <= 0) {
					return;
				}
				TableItem ta = tab[0];
				for (int i = 0; i < list1.size(); i++) {
					list1.get(i).setText(ta.getText(i + 1));
				}
			}
		});

	}

	// 在composite中动态生成label 和text
	private void widgetSelected() {
		if (ti == null) {
			return;
		}
		List<Map<String, String>> list = initTable();

		Map<String, String> map = list.get(0);// 字段名
		Set set = map.entrySet();
		Iterator it = set.iterator();
		int i = 0;
		while (it.hasNext()) {// hasNext()只能取值
			Entry entry = (Entry) it.next();// 下一个键值对
			Label lblNewLabel = new Label(composite, SWT.NONE);
			lblNewLabel.setBounds(25 + 100 * i, 35, 60, 20);
			lblNewLabel.setText((String) entry.getKey());

			Text text = new Text(composite, SWT.NONE);
			text.setBounds(20 + i * 100, 80, 60, 20);
			list1.add(text);
			i++;

		}

	}

	// 获取列名
	private void getLieMing() {
		Map<String, String> map = list.get(0);// 列名
		Set set = map.entrySet();
		Iterator it = set.iterator();
		while (it.hasNext()) {// hasNext()只能取值
			Entry entry = (Entry) it.next();// 下一个键值对
			String lieMing = (String) entry.getKey();
			list2.add(lieMing);
		}
	}

	// 初始化表
	private List<Map<String, String>> initTable() {
		TreeItem tpi = ti.getParentItem();
		String parentItemName = tpi.getText();

		if (parentItemName.equals("Tables")) {

			String sql = "select  *  from " + ti.getText();
			try {
				list = Common.dbhelper.find(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			MainUi mu = new MainUi();
			TabItem[] cTabItem = tabFolder.getItems();
			if (cTabItem.length <= 0) {
				return null;
			}
			
			for (TabItem ct : cTabItem) {
				ct.dispose();
			}
			TabItem ct = new TabItem(tabFolder, SWT.CLOSE);
			ct.setText(ti.getText());
			table = new Table(tabFolder, SWT.BORDER | SWT.FULL_SELECTION
					| SWT.HIDE_SELECTION);
			ct.setControl(table);
			table.setLinesVisible(true);
			table.setHeaderVisible(true);
			mu.showResult(list, table);
		}
		return list;
	}
}
