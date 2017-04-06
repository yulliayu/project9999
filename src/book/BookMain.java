package book;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BookMain extends JFrame implements ItemListener{
	
	DBManager instance = DBManager.getInstance();
	Connection  con;
	PreparedStatement pstmt=null;
	ResultSet  rs=null;
	
	JPanel  p_west, p_center, p_content, p_north, p_table, p_grid;
	JScrollPane  scroll;
	Choice  ch_top, ch_sub;
	JTextField  t_name, t_price;
	Canvas  can;
	JButton  bt_regist;
	Checkbox  chx_table, chx_grid;
	CheckboxGroup  chx_group;
	
	public BookMain() {
		
		p_west = new JPanel();
		p_center = new JPanel();
		p_north = new JPanel();
		p_content = new JPanel();
		p_table = new JPanel();
		p_grid = new JPanel();
		
		ch_top = new Choice();
		ch_sub = new Choice();

		t_name = new JTextField(13);
		t_price = new JTextField(13);
		
		can = new Canvas();
		
		bt_regist = new JButton("등록");
		
		chx_group = new CheckboxGroup();
		chx_table = new Checkbox("테이블 방식", chx_group, true);
		chx_grid = new Checkbox("그리드 방식", chx_group, true);
		
		// size 지정
		p_west.setPreferredSize(new Dimension(200, 600));
		p_center.setPreferredSize(new Dimension(600, 600));
		p_north.setPreferredSize(new Dimension(600, 30));
		p_content.setPreferredSize(new Dimension(600, 570));
		ch_top.setPreferredSize(new Dimension(150, 20));
		ch_sub.setPreferredSize(new Dimension(150, 20));
		can.setPreferredSize(new Dimension(150, 150));
		
		// 색상 지정
		p_west.setBackground(Color.pink);
		p_center.setBackground(Color.YELLOW);
		p_north.setBackground(Color.CYAN);
		p_content.setBackground(Color.GRAY);
		p_table.setBackground(Color.green);
		p_grid.setBackground(Color.green);
		can.setBackground(Color.WHITE);
		
		// west 에 부착
		p_west.add(ch_top);
		p_west.add(ch_sub);
		p_west.add(t_name);
		p_west.add(t_price);
		p_west.add(can);
		p_west.add(bt_regist);
		
		// north 에 부착
		p_north.add(chx_table);
		p_north.add(chx_grid);
		
		// content 에 부착
		p_content.add(p_table);
		p_content.add(p_grid);
		
		// center 에 부착
		p_center.add(p_north, BorderLayout.NORTH);
		p_center.add(p_content);
		
		init();
		
		// Frame 에 부착
		add(p_west, BorderLayout.WEST);
		add(p_center);
		
		setVisible(true);
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void init(){
		con = instance.getConnection();
		
		// topcategory 가져오기
		String sql = "select category_name from topcategory order by topcategory_id ";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				ch_top.add(rs.getString("category_name"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		
	}

	public void itemStateChanged(ItemEvent e) {
		Object obj = e.getSource();
		if (obj == ch_top){
			String name = ch_top.getSelectedItem();
			
		} else if (obj == ch_sub){
			//
		}
	}

	public static void main(String[] args) {
		new BookMain();

	}

}
