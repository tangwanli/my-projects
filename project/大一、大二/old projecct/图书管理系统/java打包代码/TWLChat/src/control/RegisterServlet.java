package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import database.DBConnection;

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUTD = 1L;
	
	public RegisterServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
			doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("还是先看看有没有进RegisterServlet的post");
		request.setCharacterEncoding("utf-8");
		

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		register(username,password);
		
	}
	
	public void register(String username, String password)
	{
		ResultSet rs = null;
		Statement sta = null;
		Connection conn = null;
		int rowCount = 0;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			
			String num = "select * from userinfo";
			rs = sta.executeQuery(num);
			while(rs.next())
			{
				rowCount++;
			}
			System.out.println("数据库中已加入用户数目为：" + rowCount);
			String sql = "insert into userinfo values("+rowCount+",'"+username+"','"+password+"')";
			sta.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs,sta,conn);
		}
	}

}
		
			
			
		

		
		
		
		
		
	


