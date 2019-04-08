package xyskcsj;
import javax.swing.table.*;
import java.sql.*;
import java.util.*;
public class EmployModel extends AbstractTableModel{

	Vector rowData,columnNames;
	//实现查询
	public void queryEmploy(String sql,String []paras)
    {

		SqlHelper sqh = null;
		
		//用columnNames 存放 表的列名
       	columnNames = new Vector();
		columnNames.add("工号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("出生年月");
		columnNames.add("部门");
		columnNames.add("职位");
		columnNames.add("工资");
		
		//rowData 存放表格的各行数据
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
	   //实现 表格   增  修 改  功能
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
		//获得某一个单元格的数值
		return ((Vector)this.rowData.get(row)).get(column);
	}

}
