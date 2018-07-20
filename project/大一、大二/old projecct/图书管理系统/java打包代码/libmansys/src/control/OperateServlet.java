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

import util.Protocol;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import database.DBConnection;

public class OperateServlet extends HttpServlet {
	private static final long serialVersionUTD = 1L;
	
	public OperateServlet()
	{
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
			doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
	{
		System.out.println("还是先看看有没有进OperateServlet的post");
		// 首先将编码类型都设置为uft-8
		request.setCharacterEncoding("utf-8");
		int tempCount = 0;
		
		// 获取method
		int method = Integer.parseInt(request.getParameter("method"));
		switch(method)
		{
		case 1 : addBook(request);break;
		case 2 : deleteBook(request);break;
		case 3 : tempCount=3;
		         String strId = request.getParameter("id");
		         String bookname = request.getParameter("bookname");
		         String autor = request.getParameter("autor");
		         String strPrice = request.getParameter("price");
		         queryBook(strId, bookname, autor, strPrice);break;
		case 4 : alterBook(request);break;
		case 5 : tempCount=5;
		         queryAllBook();break;
		case 6 : borrowBook(request, response);break;
		case 7 : returnBook(request);break;
		case 8 : tempCount=8;
		         disBorBook(request);break;
		default: ;
		}
		
		if(tempCount == 3 || tempCount == 5 || tempCount == 8)
		{
			JSONObject jsonObject = new JSONObject();
			String msg = Protocol.msg;
			jsonObject.put("msg", msg);
			response.getWriter().write(jsonObject.toString());
			System.out.println("返回给服务器"+ msg);
		}
		
	}


	
	// 为了让这个自定义函数可以用request和response方法，必须在自定义函数里面加上这两个参数
	void addBook(HttpServletRequest request)
	{
		String bookname = request.getParameter("bookname");
		String autor = request.getParameter("autor");
		String strPrice = request.getParameter("price");
		
		ResultSet rs = null;
		Connection conn = null;
		Statement sta = null;
		float price = Float.parseFloat(strPrice);
		
		try {
			conn = DBConnection.getConnection(); 
			sta = conn.createStatement();
			int rowCount = 0;
			
			String num = "select * from bookinfo";
			rs = sta.executeQuery(num);  

			while(rs.next())
			{
				rowCount++;
			}
			rowCount++; // 这里rowCount++,用来表示添加了一行数据
			String sql = "insert into bookinfo values("+rowCount+",'"+ bookname +"','"+ autor+"',"+price+",'nobody')";
			sta.executeUpdate(sql);
			System.out.println("添加成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBConnection.close(rs, sta, conn);
		}
	}
	
	// 删除需要返回false，用来表示没有这本书
	void deleteBook(HttpServletRequest request)
	{
		String strId = request.getParameter("id");
		String bookname = request.getParameter("bookname");
		String autor = request.getParameter("autor");
		String strPrice = request.getParameter("price");
		
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
        try {
        	conn = DBConnection.getConnection();
        	sta = conn.createStatement();
        	
        	int rowCount = 0;
    		String reduceId = null;
        	
        	String bookCount = "select * from bookinfo";
        	rs = sta.executeQuery(bookCount);
        	// 总行数
        	while(rs.next())
        	{
        		rowCount++;
        	}
        	// 如果填写了id
        	if(strId.equals("") == false)
        	{
        		int id = Integer.parseInt(strId);
        		String sql = "delete from bookinfo where id="+id+"";
        		sta.executeUpdate(sql);
        		for(id++; id < rowCount; id++)
        		{
        			reduceId = "update bookinfo set id="+(id - 1)+" where id="+id+"";
        			sta.executeUpdate(reduceId);
        		}
        	} else
        	{
        		queryBook(strId, bookname, autor, strPrice);
        		System.out.println("有没有运行到这里");
        			String[] countSplit = Protocol.msg.split("@");
        			int count = Integer.parseInt(countSplit[0]);
        			String[] data = countSplit[1].split(";");
        			System.out.println("还有没有运行到这里");
        			for(int i=0; i<count; i++)
        			{
        				int findId = Integer.parseInt(data[i].split(",")[0]);
        				String sql = "delete from bookinfo where id="+findId+"";
                		sta.executeUpdate(sql);
                		for(findId++; findId < rowCount; findId++)
                		{
                			reduceId = "update bookinfo set id="+(findId - 1)+" where id="+findId+"";
                			sta.executeUpdate(reduceId);
                		}
        			}
        	}
        	System.out.println("看看有没有运行到删除的最后");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally
		{
			DBConnection.close(rs, sta, conn);
		}
	}
	
	// 核心方法
	void queryBook(String strId, String bookname, String autor, String strPrice)
	{
		Connection conn = null;
		Statement sta = null;
		ResultSet rs = null;
		System.out.println("有没有进入查询");
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			String sql = null;
			// 下面为根据用户输入的东西，来进行判断需要执行的是哪个sql语句
			if(strId.equals("") == false)
			{
				sql = "select * from bookinfo where id="+Integer.parseInt(strId)+"";
			} else
			{
				if(bookname.equals("") == false && autor.equals("") == false)
				{
					sql = "select * from bookinfo where bookname = '" + bookname + "' and autor = '" + autor + "'"; 
				} else
				{
					if(bookname.equals("") == false && strPrice.equals("") == false)
					{
						sql = "select * from bookinfo where bookname = '" + bookname + "' and price = '" + Float.parseFloat(strPrice) + "'"; 
					} else
					{
						if(autor.equals("") == false && strPrice.equals("") == false)
						{
							sql = "select * from bookinfo where autor = '" + autor + "' and price = '" + Float.parseFloat(strPrice) + "'"; 
						} else
						{
							if(bookname.equals("") == false)
							{
								sql = "select * from bookinfo where bookname = '" + bookname + "'"; 
							} else
							{
								if(autor.equals("") == false)
								{
									sql = "select * from bookinfo where autor = '" + autor + "'";
								} else
								{
									if(strPrice.equals("") == false)
									{
										sql = "select * from bookinfo where price = '" + Float.parseFloat(strPrice) + "'";
									}
								}
							}
						}
					}
				}
			}
			
			System.out.println(sql);
			// 查找失败
			rs = sta.executeQuery(sql);
			if(rs.next() == false)
			{
				
				System.out.println("有没有进入错误语句");
			} else
			{
				System.out.println("是不是这里又出错了 ");
				Protocol protocol = new Protocol();
				// 判断rs.next()一共有多少行语句
				int count = 0;
				rs.beforeFirst();
				while(rs.next())
				{
					count++;
					protocol.setQueryBookMsg(count, rs.getInt("id"), rs.getString("bookname"), rs.getString("autor"), rs.getFloat("price"), rs.getString("borrow"));
					System.out.println("结果是：" + rs.getInt("id") + rs.getString("bookname") + rs.getString("autor") + rs.getFloat("price")+ rs.getString("borrow"));
				}
			}
			System.out.println("msg is " + Protocol.msg);
			System.out.println("会不会运行到查询最后");
		} catch (SQLException e) {
			e.printStackTrace();
		}  finally
		{
			DBConnection.close(rs, sta, conn);
		}
		
	}
	
	// 后面的4个修改的值里面，至少要填写一个
	void alterBook(HttpServletRequest request)
	{

		String befStrId = request.getParameter("befid");
		String befBookname = request.getParameter("befbookname");
		String befAutor = request.getParameter("befautor");
		String befStrPrice = request.getParameter("befprice");
		String strId = request.getParameter("id");
		String bookname = request.getParameter("bookname");
		String autor = request.getParameter("autor");
		String strPrice = request.getParameter("price");
		
		Connection conn = null;
		Statement sta = null;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			
			queryBook(befStrId, befBookname, befAutor, befStrPrice);
    			String[] countSplit = Protocol.msg.split("@");
    			int count = Integer.parseInt(countSplit[0]);
    			String[] data = countSplit[1].split(";");
    			
    			String bodySql = null;
    			String sql = null;
    			for(int i=0; i<count; i++)
    			{
    				
    				if(strId.equals("") == false && bookname.equals("") == false && autor.equals("") == false && strPrice.equals("") == false)
    				{
    					bodySql = "id = "+Integer.parseInt(strId)+", bookname = '"+bookname+"', autor = '"+autor+"', price = "+Float.parseFloat(strPrice)+"";
    				} else
    				{
    					if(strId.equals("") == false && autor.equals("") == false && strPrice.equals("") == false)
    					{
    						bodySql = "id = "+Integer.parseInt(strId)+", autor = '"+autor+"', price = "+Float.parseFloat(strPrice)+"";
    					} else
    					{
    						if(strId.equals("") == false && bookname.equals("") == false && strPrice.equals("") == false)
    						{
    							bodySql = "id = "+Integer.parseInt(strId)+", bookname = '"+bookname+"', price = "+Float.parseFloat(strPrice)+"";
    						} else
    						{
    							if(strId.equals("") == false && bookname.equals("") == false && autor.equals("") == false)
    							{
    								bodySql = "id = "+Integer.parseInt(strId)+", bookname = '"+bookname+"', autor = '"+autor+"'";
    							} else
    							{
    								if(strId.equals("") == false && bookname.equals("") == false)
    								{
    									bodySql = "id = "+Integer.parseInt(strId)+", bookname = '"+bookname+"'";
    								} else
    								{
    									if(strId.equals("") == false && autor.equals("") == false)
    									{
    										bodySql = "id = "+Integer.parseInt(strId)+", autor = '"+autor+"'";
    									} else
    									{
    										if(strId.equals("") == false && strPrice.equals("") == false)
    										{
    											bodySql = "id = "+Integer.parseInt(strId)+", price = "+Float.parseFloat(strPrice)+"";
    										} else
    										{
    											if(bookname.equals("") == false && autor.equals("") == false)
    											{
    												bodySql = "bookname = '"+bookname+"', autor = '"+autor+"'";
    											} else
    											{
    												if(bookname.equals("") == false && strPrice.equals("") == false)
    												{
    													bodySql = "bookname = '"+bookname+"', price = "+Float.parseFloat(strPrice)+"";
    												} else
    												{
    													if(autor.equals("") == false && strPrice.equals("") == false)
    													{
    														bodySql = "autor = '"+autor+"', price = "+Float.parseFloat(strPrice)+"";
    													} else
    													{
    														if(strId.equals("") == false)
    														{
    															bodySql = "id = "+Integer.parseInt(strId)+"";
    														} else
    														{
    															if(bookname.equals("") == false)
    															{
    																bodySql = "bookname = '"+bookname+"'";
    															} else
    															{
    																if(autor.equals("") == false)
    																{
    																	bodySql = "autor = '"+autor+"'";
    																} else
    																{
    																	if(strPrice.equals("") == false)
    																	{
    																		bodySql = "price = "+Float.parseFloat(strPrice)+"";
    																	}
    																}
    															}
    														}
    													}
    												}
    											}
    										}
    									}
    								}
    							}
    						}
    					}
    				}
    				 
    				// 上面的一堆if else为，判断该执行哪个sql的判断语句
    				int findId = Integer.parseInt(data[i].split(",")[0]);
    				sql = "update bookinfo set " + bodySql + "  where id = "+findId+"";
    				sta.executeUpdate(sql);
    			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBConnection.close(sta, conn);	
		}
	}
	
	public void queryAllBook()
	{
		ResultSet rs = null;
		Statement sta = null;
		Connection conn = null;
		int bookCount = 0;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			
			String selectAll = "select * from bookinfo";
			rs = sta.executeQuery(selectAll);
			Protocol protocol = new Protocol();
			while(rs.next())
			{
				bookCount++;
				protocol.setQueryBookMsg(bookCount, rs.getInt("id"), rs.getString("bookname"), rs.getString("autor"), rs.getFloat("price"), rs.getString("borrow"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBConnection.close(rs, sta, conn);
		}
	}
	
	public void borrowBook(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		ResultSet rs = null;
		Statement sta = null;
		Connection conn = null;
		String state = null;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			
			String id = request.getParameter("id");
			String username = request.getParameter("username");
			System.out.println("id是： "+id+" username:"+username);
			
			String slt = "select borrow from bookinfo where id="+id+"";
			rs = sta.executeQuery(slt);
			
			if(rs.next())
			{
			  String someone = rs.getString("borrow");
			  if(someone.equals("nobody"))
			  {
				  String sql = "update bookinfo set borrow = '"+username+"' where id="+id+"";
				  sta.executeUpdate(sql);
				  state = "true";
			  } else
			  {
				  state = "false";
			  }
			}
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("state", state);
			response.getWriter().write(jsonObject.toString());
			

		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBConnection.close(rs, sta, conn);
		}
		
	}
	
	public void returnBook(HttpServletRequest request)
	{
		Statement sta = null;
		Connection conn = null;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			
			String id = request.getParameter("id");
			
			String sql = "update bookinfo set borrow='nobody' where id="+id+"";
			sta.executeUpdate(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBConnection.close(sta, conn);
		}
	}
	
	// 显示所有借的书
	public void disBorBook(HttpServletRequest request)
	{
		System.out.println("没有进借书的这个函数吗");
		ResultSet rs = null;
		Statement sta = null;
		Connection conn = null;
		int bookCount = 0;
		
		try {
			conn = DBConnection.getConnection();
			sta = conn.createStatement();
			
			String username = request.getParameter("username");
			System.out.println("username"+username);
			
			String selectAll = "select * from bookinfo where borrow='"+username+"'";
			rs = sta.executeQuery(selectAll);
			Protocol protocol = new Protocol();
			while(rs.next())
			{
				bookCount++;
				protocol.setQueryBookMsg(bookCount, rs.getInt("id"), rs.getString("bookname"), rs.getString("autor"), rs.getFloat("price"), rs.getString("borrow"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally
		{
			DBConnection.close(rs, sta, conn);
		}
	}
}
		
			
			
		

		
		
		
		
		
	


