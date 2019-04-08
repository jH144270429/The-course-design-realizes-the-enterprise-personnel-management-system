package xyskcsj;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class AppraisalModel extends AbstractTableModel {

	Vector rowData, columnNames;

	// ʵ�ֲ�ѯ
	public void queryAppraisal(String sql) {

		SqlHelper sqh = null;

		// ��columnNames ��� �������
		columnNames = new Vector();
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("�ϴο���");
		columnNames.add("����ʱ��");

		// rowData ��ű��ĸ�������
		rowData = new Vector();
		try {
			sqh = new SqlHelper();
			ResultSet rs = sqh.queryExecute(sql);
			while (rs.next()) {
				Vector hang = new Vector();

				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));

				rowData.add(hang);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqh.close();
		}
	}

	// ��ѯԱ��������ʷ��¼����
	public void queryHistory(String sql, String[] paras) {

		SqlHelper sqh = null;

		// ��columnNames ��� �������
		columnNames = new Vector();
		columnNames.add("��ˮ��");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("�ϴο���");
		columnNames.add("���ο���");
		columnNames.add("����ʱ��");

		// rowData ��ű��ĸ�������
		rowData = new Vector();
		try {
			sqh = new SqlHelper();
			ResultSet rs = sqh.queryExecute(sql, paras);
			while (rs.next()) {
				Vector hang = new Vector();

				hang.add(rs.getString(1));
				hang.add(rs.getString(2));
				hang.add(rs.getString(3));
				hang.add(rs.getString(4));
				hang.add(rs.getString(5));
				hang.add(rs.getString(6));
				rowData.add(hang);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqh.close();
		}
	}

	// ʵ�� ��� �� �� �� ����
	public boolean updAppraisal(String sql, String[] paras) {

		SqlHelper sqh = new SqlHelper();
		return sqh.updExecute(sql, paras);
	}

	public int getRowCount() {
		return this.rowData.size();
	}

	public String getColumnName(int column) {
		return (String) this.columnNames.get(column);
	}

	public int getColumnCount() {
		return this.columnNames.size();
	}

	public Object getValueAt(int row, int column) {
		// ���ĳһ����Ԫ�����ֵ
		return ((Vector) this.rowData.get(row)).get(column);
	}

}