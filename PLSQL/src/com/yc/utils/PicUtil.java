package com.yc.utils;

import java.io.InputStream;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;

public class PicUtil {
	static Display display;
	public static void showPic( Label picLabel,InputStream is){
			ImageData imageData=new ImageData(is);
			imageData =imageData.scaledTo(picLabel.getBounds().width, picLabel.getBounds().height);
			Image image=new Image(display,imageData);
			picLabel.setImage(image);

	}
}
