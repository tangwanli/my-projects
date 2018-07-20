package control;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import database.DBConnection;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUTD = 1L;
	
	public LoginServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
			doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("还是先看看有没有进LoginServlet的post");
		// 首先将编码类型都设置为uft-8
		request.setCharacterEncoding("utf-8");
		// 用于返回的字符串
		String isJudge = null;
		
		// 获取username
		
		// 这个getParameter()只能接受一个参数的内容，如果需要读取的是一组参数（同名参数），如：checkbox，那么需要用getParameterValues()方法
		// getParameter()方法类型为String，getParameterValues()方法返回类型为String[]
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// new一个jsonobject对象，用于返回
		JSONObject jsonObject = new JSONObject();
		if(password.equals(""))
		{
			if(validateUser(username))
			{
				isJudge = "true";
			} else
			{
				isJudge = "false";
			}
		} else 
		{
			if(validateUser(username, password))
			{
				// 将用户名存在session对象的username属性（自定义属性）里面，为了方便以后用session.getAttribute("username")来获取用户名
				// setAttribute()有两个参数，第一个参数是属性名，第二个是属性值
				request.getSession().setAttribute("username", username);
				isJudge = "true";
			} else
			{
				isJudge = "false";
			}
		}
		
		// 用put方法把值加到jsonobject中属性名为isresult
		jsonObject.put("isReturn", isJudge);
		System.out.println("jsonObject.toString()结果为:" + jsonObject.toString());
		// 返回给客户端消息
		response.getWriter().write(jsonObject.toString());
		
	}
	
	public boolean validateUser(String username, String password)
	{
		ResultSet rs = null;
		Statement sta = null;
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = "select username,password from userinfo where username='"+username+"' and password='"+password+"'";
			rs = sta.executeQuery(sql);
			if(rs.next())
			{
				return true;
			} else
			{
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close(rs,sta,conn);		
		}
			
	}
	
	public boolean validateUser(String username)
	{
		System.out.println("进了数据库没");
		ResultSet rs = null;
		Statement sta = null;
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			
			String sql = "select username from userinfo where username='"+ username +"'";
			System.out.println("到底是哪里的错");
			rs = sta.executeQuery(sql);
			if(rs.next())
			{
				System.out.println("数据库返回了成功的吧");
				return true;
			} else 
			{
				System.out.println("数据库返回了失败的吧");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			DBConnection.close(rs,sta,conn);
		}
	}

	
	
	// 下面这个跳转是客户端跳转，跳转之后地址栏会变成跳转之后的地址栏，而服务器跳转不会改变
	// response.sendRedirect("index.html");
	// request.getRequestDispatcher("bookdetail_forward.jsp").forward(request, response);
	
/*public static void main(String[] args) {

		// json的字符串，必须要用转义\将“转义，然后再调用JSONObject对象变为json对象
		String is2= "{\"isJudge\":\"123\"}";
	  String is1 = "[{\"isJudge\":\"123\"},\"dsa\"]";
	  //String is2 = "1";
		
		//JSONObject a2 = JSONObject.fromObject(is2);
		
		JSONArray arr=JSONArray.fromObject(is1);
		JSONArray arr2=new JSONArray();
		System.out.println(arr);
        JSONObject a=new JSONObject();

        JSONObject obj=new JSONObject();

        // jsonobject的put()方法，第二个参数为value（可以直接用字符串），即添加到obj中的属性值，第一个参数为key,即为属性名称，
        obj.put("what", arr);

			
			System.out.println(obj);

	}*/
	public static void main(String[] args)
	{

		Pattern p = Pattern.compile("(?<=[^c]a)\\d*(?=bd)");  
		   String str = "da12b ka3434bd ca4343bd";  
		   String astr = "5569 452369";  
		   
		   Matcher m = p.matcher(str);  
		   Matcher n = p.matcher(astr);
		   while(m.find()){  
		     System.out.println("1:"+m.group());  
		   }  
		   while(n.find()){  
			     System.out.println("2:"+n.group());  
			   } 

	}
}
		
			
			
		

		
		
		
		
		
	


