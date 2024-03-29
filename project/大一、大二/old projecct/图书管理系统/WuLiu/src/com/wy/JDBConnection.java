package com.wy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBConnection {

	private static Connection conn = null; // 设置Connection类的对象
	private static Statement st = null; // 设置Statement类的对象
	private ResultSet rs = null; // 设置ResultSet类的对象

	private String dbUrl = "jdbc:mysql://localhost:3306/db_wuliu";
	private String dbUserName = "root";
	private String dbPassword = "554523";
	private String jdbcName = "com.mysql.jdbc.Driver";

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 * @throws Exception
	 */
	public Connection getCon() throws Exception {
		Class.forName(jdbcName);
		Connection con = DriverManager.getConnection(dbUrl, dbUserName,
				dbPassword);
		return con;
	}

	public void close(Connection con) throws Exception {
		if (con != null) {
			con.close();
		}
	}

	public ResultSet executeQuery(String sql) throws Exception {
		conn = this.getCon();
		try {
			st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = st.executeQuery(sql); // 执行对数据库的查询操作
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query Exception"); // 在控制台中输入异常信息
		} 
		return rs; // 将查询的结果通过return关键字返回
	}

	public boolean executeUpdata(String sql) {
		try {
			st = conn.createStatement(); // 创建声明对象连接
			st.executeUpdate(sql); // 执行添加、修改、删除操作
			return true; // 如果执行成功则返回true
		} catch (Exception e) {
			e.printStackTrace();
			return false; // 如果执行成功则返回false
		}
	}

}
