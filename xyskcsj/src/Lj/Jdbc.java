package Lj;

import java.sql.*;

public class Jdbc {
	//�������ݿ�
	 public Jdbc(){
	 Connection conn;
		 Connection con = null;
		 Statement stat = null;
		 ResultSet rs = null;
	 try {
     	String dbURL = "jdbc:sqlserver://127.0.0.1:1433; DatabaseName=testDB";	// �����ַ���
			  String userName = "sa";	
			  String userPwd = "123";
		     	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");	
				conn = DriverManager.getConnection(dbURL, userName, userPwd);	
				System.out.println("�������ݿ�ɹ�");

     }catch (Exception e){
         e.printStackTrace();
         System.out.println("�������ݿ�ʧ��");
     }
 }
	 public static void main(String[] args) {
			Jdbc jdbc=new Jdbc();
		}
}
