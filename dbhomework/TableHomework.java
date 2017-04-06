package dbhomework;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIDefaults.ActiveValue;
import javax.swing.table.AbstractTableModel;

public class TableHomework extends JFrame implements ItemListener{
	
	JPanel  		p_west, p_center;
	Choice  		choice;
	JScrollPane	scroll;
	JTable			table;
	
	String[][] 	choiceList={
											{"▼ 선택해 주세요", ""},
											{"부서목록","dept"},
											{"사원목록","emp"}
										};
	String tableName;
	
	public TableHomework() {
		
		p_west = new JPanel();
		p_center = new JPanel();
		
		choice = new Choice();
		// choice List 추가
		for (int i=0; i<choiceList.length; i++){
			// choice 에 항목 추가
			choice.add(choiceList[i][0]);
			// table name 
			String tname = choiceList[i][1];
		}		
		
		// choiceModelList 의 초기값으로 JTable 생성
		table = new JTable(null );
		setTableModel();
		scroll = new JScrollPane(table);
		
		// west
		p_west.setPreferredSize(new Dimension(150, 500));
		p_west.add(choice);
		p_west.setBackground(Color.YELLOW);
		
		// 리스너 연결
		choice.addItemListener(this);	
		
		// center
		p_center.setLayout(new BorderLayout());
		p_center.add(scroll, BorderLayout.CENTER);
		
		add(p_west, BorderLayout.WEST);
		add(p_center, BorderLayout.CENTER);		
		
		setVisible(true);
		setSize(700, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void itemStateChanged(ItemEvent e) {
		//System.out.println("itemStateChanged");
		Object obj = e.getSource();
		if (obj == choice){
			setTableModel();
		}		
	}
	
	public void setTableModel(){
		int index=choice.getSelectedIndex();
		// 이렇게 계속 생성하면 메모리에 계속 올라가서 안좋을듯 한데.....
		table.setModel(new ChoiceModel(choiceList[index][1]));
		table.updateUI();		
	}

	public static void main(String[] args) {
		new TableHomework();

	}

}
