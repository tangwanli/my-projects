package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	
	static String url = "jdbc:mysql://localhost:3306/libmansys";
	static String dbUserName="root";
	static String dbPassword="1184300287";
	
	static    
	{
	try {
		 Class.forName("com.mysql.jdbc.Driver");  
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	}
	
	// 下面这个函数为了返回链接
	public static Connection getConnection()
	{
		try {
			return DriverManager.getConnection(url,dbUserName,dbPassword);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;      
		}  
	}
	
	
	
	public static void close(ResultSet rs, Statement sta, Connection conn)
	{
		
			try {
				if(rs != null)rs.close();
				if(sta != null)sta.close();
				if(conn != null)conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	public static void close(Statement sta, Connection conn)
	{
		close(null, sta, conn);
	}

}

