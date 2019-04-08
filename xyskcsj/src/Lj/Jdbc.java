package Lj;

import java.sql.*;

public class Jdbc {
	//连接数据库
	 public Jdbc(){
	 Connection conn;
		 Connection con = null;
		 Statement stat = null;
		 ResultSet rs = null;
	 try {
     	String dbURL = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=testDB";	// 连接字符串
			  String userName = "sa";	
			  String userPwd = "123";
		     	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
				conn = DriverManager.getConnection(dbURL, userName, userPwd);	
				System.out.println("连接数据库成功");

     }catch (Exception e){
         e.printStackTrace();
         System.out.println("连接数据库失败");
     }
 }
	 public static void main(String[] args) {
			Jdbc jdbc=new Jdbc();
		}
}
