package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import database.DBConnection;

public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUTD = 1L;
	
	public ValidateServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
			doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		// 首先将编码类型都设置为uft-8
		request.setCharacterEncoding("utf-8");
		
		JSONObject jsonObject = new JSONObject();
		// 获取session
		String username = (String)request.getSession().getAttribute("username");
		if(username != null)
		{
			jsonObject.put("username", username);	
		} else 
		{
			jsonObject.put("username", "false");
		}

		System.out.println("validataservlet返回给客户端结果为:" + jsonObject.toString());
		// 返回给客户端消息
		response.getWriter().write(jsonObject.toString());
		
	}
	
}
		
			
			
		

		
		
		
		
		
	


