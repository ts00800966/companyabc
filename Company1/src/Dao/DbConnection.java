package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) {
		
		System.out.println(DbConnection.getDB());

	}
	public static Connection getDB()
	{
		Connection conn=null;
		String url="jdbc:mysql://localhost:3306/company";
		String name="root";
		String password="1234";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection(url, name, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("DB呼叫錯誤");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("連線資訊錯誤");
			e.printStackTrace();
		}
		
		return conn;
	}

}
