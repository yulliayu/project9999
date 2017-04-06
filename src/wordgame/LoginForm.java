package wordgame;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginForm extends JPanel{
	
	JPanel  p_container, p_north, p_center;
	JLabel  la_id, la_pw;
	JTextField  t_id;
	JPasswordField t_pw;
	JButton  bt;
	
	public LoginForm() {
		p_container = new JPanel();
		p_north = new JPanel();
		p_center = new JPanel();
		
		la_id = new JLabel("Id");
		la_pw = new JLabel("Password");
		
		t_id = new JTextField(15);
		t_pw = new JPasswordField(15);
		
		bt = new JButton("·Î±×ÀÎ");
		
		// north
		p_north.setLayout(new GridLayout(2,2));
		p_north.add(la_id);
		p_north.add(t_id);
		p_north.add(la_pw);
		p_north.add(t_pw);
		
		p_center.add(bt);
		
		p_container.add(p_north);
		
		
	}

}
