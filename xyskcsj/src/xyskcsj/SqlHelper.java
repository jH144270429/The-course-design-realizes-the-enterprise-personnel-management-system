package xyskcsj;
import java.sql.*;

public class SqlHelper {
	Connection ct = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	String driver = "sun.jdbc.odbc.JdbcOdbcDriver";
	String url = "jdbc:odbc:Manager";

	// 查询数据库操作
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
	//没注入式查询数据库操作
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

	// 增 删 改 功能
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

	// 重写 close 关闭数据库资源
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