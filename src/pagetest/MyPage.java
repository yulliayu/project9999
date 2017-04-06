package pagetest;

import java.awt.BorderLayout;
import java.awt.Color;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyPage extends JFrame{
	
	JPanel  p_north, p_center;
	JButton[]  btArr = new JButton[3];
	ImageIcon[] iconArr = new ImageIcon[3];
	URL[]  urlArr = new URL[3];
	String[] path  = {"/login.png", "/content.png", "/etc.png"};

	public MyPage() {

		p_north = new JPanel();

		for (int i=0; i<path.length;i++){
			urlArr[i] = this.getClass().getResource(path[i]);
			System.out.println(urlArr[i]);
			iconArr[i] = new ImageIcon(urlArr[i]);
			btArr[i] = new JButton(iconArr[i]);
			p_north.add(btArr[i]);
		}
		
		p_center = new JPanel();
		p_center.setBackground(Color.YELLOW);
		
		LoginT login = new LoginT();
		p_center.add(login);
		
		add(p_north, BorderLayout.NORTH);
		add(p_center, BorderLayout.CENTER);
		
		setVisible(true);
		setSize(600, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
		
	}
	
	public static void main(String[] args) {
		new MyPage();

	}

}
