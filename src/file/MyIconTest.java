package file;

import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;

public class MyIconTest extends ImageIcon{
	
	public MyIconTest(URL url, int width, int height) {
		
		super(url);

		Image  img = this.getImage();
		Image   result = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		this.setImage(result);
		
		 
	}

}
