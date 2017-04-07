package mask;

import java.awt.Dimension;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;

import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class MyMask extends  JFrame{
	
	MaskFormatter  mask;
	JTextField  t_input;
	JFormattedTextField  tf;
	
	public MyMask() {
		
		tf = new JFormattedTextField();
		//tf.setSize(new Dimension(100, 100));
		tf.setValue(new Date());
		
		
		add(tf);

		setVisible(true);
		setSize(300, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public static void main(String[] args) {
		new MyMask();

	}

}
