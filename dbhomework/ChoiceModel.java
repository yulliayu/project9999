package dbhomework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.AbstractTableModel;

public class ChoiceModel extends AbstractTableModel{
	
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:XE";
	String user="batman";
	String password="1234";
	
	Connection con;
	PreparedStatement pstmtCol, pstmtData;
	ResultSet rsCol, rsData;
	
	String tableName;
	String[] colNames;
	String[] colTypes;
	String[][] data;
	int  rowCount, colCount;
	
	boolean  dataDoneFlag=false;
	
	public ChoiceModel(String tableName) {
		//System.out.println("(1) ChoiceModel ");
		this.tableName = tableName;
		if (tableName.equals("")){
			// choice ���� �׸��� ���õ��� �ʾ�����.
			rowCount = 0;
			colCount=1;
		} else {
			//System.out.println("tableName1 = "+tableName);
			try {
				// 1. ����̹� �ε�
				Class.forName(driver);
				
				// 2. ����
				con = DriverManager.getConnection(url, user, password);
				
				if (con!=null){
					// Column �� ���ϱ�
					String sql=" select tc.COLUMN_NAME, tc.DATA_TYPE "
	                        	  +" from   user_tab_columns tc "
	                        	  +" where tc.table_name = Upper('"+tableName+"') "
	                        	  +" order by tc.COLUMN_ID";
					
					pstmtCol = con.prepareStatement(sql
																	, ResultSet.TYPE_SCROLL_INSENSITIVE
																	, ResultSet.CONCUR_READ_ONLY);
					
					rsCol = pstmtCol.executeQuery();
					
					rsCol.last();
					colCount=rsCol.getRow();
					
					rsCol.beforeFirst();
					
					int index=0;
					colNames = new String[colCount];
					colTypes   = new String[colCount];
					while (rsCol.next()){
						// �÷���, �÷� ������ Ÿ�� �迭�� ��� ����
						colNames[index]=rsCol.getString("COLUMN_NAME");
						colTypes[index]=rsCol.getString("DATA_TYPE");

						index++;
					}
					//System.out.println("col index = "+index);
					
					dataQuery();
				} else {
					System.out.println("DB ���� �Ұ�");
				}
				
			} catch (ClassNotFoundException e) {
				System.out.println("ClassNotFoundException");
				e.printStackTrace();
			} catch (SQLException e) {
				//System.out.println("SQLException : "+e.getCause());
				e.printStackTrace();
			} finally {
				if (con!=null )
					try {
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
			}
		}
	}
	
	// ������ ��ȸ
	public void dataQuery(){
		//System.out.println("(3) ChoiceModel ");

		try {
			if (con!=null){
				// 3. ���ϴ� ���� ����
				String sql="select * from "+tableName;
				pstmtData = con.prepareStatement(sql
						                                          ,ResultSet.TYPE_SCROLL_INSENSITIVE
						                                          ,ResultSet.CONCUR_READ_ONLY);
				rsData = pstmtData.executeQuery();
				rsData.last();
				
				// Row ��
				rowCount = rsData.getRow();
				
				// row ����ġ ��Ŵ
				rsData.beforeFirst();
				int index=0;
				String value;
				data = new String[rowCount][colCount];
				while (rsData.next()){			
					
					for (int i=0; i<colCount;i++){
						/* <���ǻ���?????> -----------------------------------------------
						    ���������� String ���� ��ȯ��Ű�µ� 
						    �� String ���� �ȹް� Int �� �޾Ҵٰ� String ���� ��ȯ�ϴ��� �ñ��մϴ�.?
						 --------------------------------------------------------------------*/
						if (colTypes[i].equals("NUMBER") && colNames[i].equals("COMM")==false){
							value = Integer.toString(rsData.getInt(colNames[i]));
						} else {
							value = rsData.getString(colNames[i]);
						}
						data[index][i]=value;
					}
					
					index++;
				}
				//System.out.println("row index = "+index);
				dataDoneFlag=true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// ResultSet �ݱ�
			if (rsData!=null)
				try {
					rsData.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			// PreparedStatement �ݱ�
			if (pstmtData!=null)
				try {
					pstmtData.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	
	}

	public int getColumnCount() {
		return colCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
