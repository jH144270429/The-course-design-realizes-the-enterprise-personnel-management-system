package xyskcsj;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;

public class AppraisalModel extends AbstractTableModel {

	Vector rowData, columnNames;

	// 实现查询
	public void queryAppraisal(String sql) {

		SqlHelper sqh = null;

		// 用columnNames 存放 表的列名
		columnNames = new Vector();
		columnNames.add("工号");
		columnNames.add("姓名");
		columnNames.add("上次考核");
		columnNames.add("考核时间");

		// rowData 存放表格的各行数据
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

	// 查询员工考核历史记录方法
	public void queryHistory(String sql, String[] paras) {

		SqlHelper sqh = null;

		// 用columnNames 存放 表的列名
		columnNames = new Vector();
		columnNames.add("流水号");
		columnNames.add("工号");
		columnNames.add("姓名");
		columnNames.add("上次考核");
		columnNames.add("本次考核");
		columnNames.add("更改时间");

		// rowData 存放表格的各行数据
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

	// 实现 表格 增 修 改 功能
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
		// 获得某一个单元格的数值
		return ((Vector) this.rowData.get(row)).get(column);
	}

}