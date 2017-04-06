package pagetest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginT extends JPanel{

	JPanel  container, p_grid, p_grid_out, p_center;
	JLabel  la_login, la_pw;
	JTextField  t_login;
	JPasswordField t_pw;
	JButton  bt;
	
	public LoginT() {
		container = new JPanel();
		p_grid = new JPanel();
		
		p_grid_out = new JPanel();
		p_center = new JPanel();
		
		la_login = new JLabel("ID");
		la_pw = new JLabel("PW");
		
		t_login = new JTextField(25);
		t_pw = new JPasswordField(25);
		
		bt = new JButton("·Î±×ÀÎ");
		
		// north
		p_grid.setLayout(new GridLayout(2, 2));
		p_grid.add(la_login);
		p_grid.add(t_login);
		p_grid.add(la_pw);
		p_grid.add(t_pw);
		
		p_grid_out.add(p_grid);
		p_grid_out.setLayout(new BorderLayout());
		
		add(p_grid_out);
		
	}
}
