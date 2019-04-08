package xyskcsj;
import java.sql.*;

public class SqlHelper {
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String url = "jdbc:odbc:Manager";

	// ��ѯ���ݿ����
	public ResultSet queryExecute(String sql, String[] paras) {
		try {
			Class.forName(driver);
			ct = DriverManager.getConnection(url);
			ps = ct.prepareStatement(sql);
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	//ûע��ʽ��ѯ���ݿ����
	public ResultSet queryExecute(String sql) {
		try {
			Class.forName(driver);
			ct = DriverManager.getConnection(url);
			ps = ct.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}

	// �� ɾ �� ����
	public boolean updExecute(String sql, String[] paras) {
		boolean b = true;
		try {
			Class.forName(driver);
			ct = DriverManager.getConnection(url);
			ps = ct.prepareStatement(sql);
			for (int i = 0; i < paras.length; i++) {
				ps.setString(i + 1, paras[i]);
			}
			if (ps.executeUpdate() != 1)
				b = false;
		} catch (Exception e) {
			b = false;
			e.printStackTrace();
		} finally {
			this.close();
		}
		return b;

	}

	// ��д close �ر����ݿ���Դ
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (ct != null)
				ct.close();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}