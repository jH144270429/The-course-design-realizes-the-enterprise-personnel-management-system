package xyskcsj;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
public class EmployModel extends AbstractTableModel{

	Vector rowData,columnNames;
	//ʵ�ֲ�ѯ
	public void queryEmploy(String sql,String []paras)
    {

		SqlHelper sqh = null;
		
		//��columnNames ��� �������
       	columnNames = new Vector();
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("��������");
		columnNames.add("����");
		columnNames.add("ְλ");
		columnNames.add("����");
		
		//rowData ��ű��ĸ�������
		rowData = new Vector();
		try {
			sqh = new SqlHelper();
			ResultSet rs = sqh.queryExecute(sql, paras);
			while(rs.next())
			{
				Vector hang = new Vector();
				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				hang.add(rs.getString(7));
				rowData.add(hang);
			}
					
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			sqh.close();
		}
    }
	   //ʵ�� ���   ��  �� ��  ����
	public boolean updEmploy(String sql,String []paras)
	{
		
    	SqlHelper sqh = new SqlHelper();
    	return sqh.updExecute(sql, paras);
	}
	
	
	public int getRowCount() {
		return this.rowData.size();
	}

	public String getColumnName(int column) {
		return (String)this.columnNames.get(column);
	}
	
	public int getColumnCount() {		
		return this.columnNames.size();
	}

	public Object getValueAt(int row, int column) {
		//���ĳһ����Ԫ�����ֵ
		return ((Vector)this.rowData.get(row)).get(column);
	}

}
