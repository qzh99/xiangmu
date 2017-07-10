package com.yc.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Abouts {

	protected Shell shlAboutus;
	private   Display display;

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
		shlAboutus.open();
		shlAboutus.layout();
		while (!shlAboutus.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlAboutus = new Shell(display,SWT.DIALOG_TRIM);
		shlAboutus.setSize(526, 391);
		shlAboutus.setText("AboutUs");
		shlAboutus.setLayout(new FormLayout());
		
		Composite composite = new Composite(shlAboutus, SWT.NONE);
		FormData fd_composite = new FormData();
		fd_composite.top = new FormAttachment(0);
		fd_composite.left = new FormAttachment(0);
		composite.setLayoutData(fd_composite);
		composite.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Label lblNewLabel = new Label(shlAboutus, SWT.BORDER);
		lblNewLabel.setFont(SWTResourceManager.getFont("����", 12, SWT.BOLD));
		FormData fd_lblNewLabel = new FormData();
		fd_lblNewLabel.right = new FormAttachment(100, -41);
		fd_lblNewLabel.left = new FormAttachment(0, 80);
		lblNewLabel.setLayoutData(fd_lblNewLabel);
		lblNewLabel.setText("\r\nProductName:   PL/SQL copycat\r\n\r\nVersoin:   1.1.1\r\n\r\nAuthor:   YH,QZH,MXH");
		
		Button btnOk = new Button(shlAboutus, SWT.NONE);
		fd_lblNewLabel.bottom = new FormAttachment(btnOk, -17);
		FormData fd_btnOk = new FormData();
		fd_btnOk.bottom = new FormAttachment(100, -43);
		fd_btnOk.left = new FormAttachment(100, -157);
		btnOk.setLayoutData(fd_btnOk);
		btnOk.setText("OK");
		
		Label lblNewLabel_1 = new Label(shlAboutus, SWT.NONE);
		fd_lblNewLabel.top = new FormAttachment(lblNewLabel_1, 6);
		fd_btnOk.right = new FormAttachment(lblNewLabel_1, 0, SWT.RIGHT);
		lblNewLabel_1.setAlignment(SWT.CENTER);
		lblNewLabel_1.setFont(SWTResourceManager.getFont("΢���ź�", 20, SWT.BOLD | SWT.ITALIC));
		FormData fd_lblNewLabel_1 = new FormData();
		fd_lblNewLabel_1.bottom = new FormAttachment(100, -303);
		fd_lblNewLabel_1.top = new FormAttachment(0, 10);
		fd_lblNewLabel_1.left = new FormAttachment(0, 80);
		fd_lblNewLabel_1.right = new FormAttachment(100, -62);
		lblNewLabel_1.setLayoutData(fd_lblNewLabel_1);
		lblNewLabel_1.setText("Information");
		
		
		//ȷ��
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Abouts.this.shlAboutus.setVisible(false);
			}
		});

	}

}
