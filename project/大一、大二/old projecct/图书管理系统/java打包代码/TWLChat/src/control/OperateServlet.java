package control;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;



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
		Document doc = null;
		String method = null;
		System.out.println("还是先看看有没有进LoginServlet的post");
		request.setCharacterEncoding("utf-8");
		method = request.getParameter("method");
		
		// SAXBuilder是一个JDOM解析器 能将路径中的XML文件解析为Document对象
		/*SAXBuilder builder = new SAXBuilder();
		doc = builder.build(new File("F:\\MyEclipse Save\\TWLChat\\XMLLocation\\allmsg.xml"));*/
		
		
		try {
			//读取已存在的Xml文件
			SAXReader reader = new SAXReader();
			doc = reader.read(new File("F:\\MyEclipse Save\\TWLChat\\XMLLocation\\allmsg.xml"));
			if(method.equals("setNode"))
			{
				setNode(request,doc);
			} else
			{
				if(method.equals("returnFile"))
				{
					System.out.println("返回"+doc.asXML());
					// doc.asXML将文件转为字符串
					response.getWriter().write(doc.asXML());
				}
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	public static void setNode(HttpServletRequest request, Document doc)
	{
		 
	        try {
	        	
	    		
	    			String username = request.getParameter("username");
	    			String target = request.getParameter("target");
	    			String text = request.getParameter("text");
	    			
	    			// 获取根节点
	    			
	    			Element root = doc.getRootElement();

	    	        // 创建4个子节点
	    	        Element message = root.addElement("message");
	    	        Element from = message.addElement("from");
	    	        Element to = message.addElement("to");
	    	        Element content = message.addElement("content");
	    	        
	    	        // 给子节点赋值
	    	        from.setText(username);
	    	        to.setText(target);
	    	        content.setText(text);
	    	        


	    	      //指定文件输出的位置
	    	        FileOutputStream out =new FileOutputStream("F:\\MyEclipse Save\\TWLChat\\XMLLocation\\allmsg.xml");
	    	      //紧凑格式:去除空格换行
	    	        OutputFormat format=OutputFormat.createPrettyPrint();  
	    	        // xml文档声明的encoding编码（Xml解析时的编码）
	    	        format.setEncoding("UTF-8");
	    	      //1.创建写出对象
	    	        XMLWriter writer=new XMLWriter(out,format);
	    	      //2.写出Document对象
	    	        writer.write(doc);
	    	      //3.关闭流
	    	        writer.close();
	    	      
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	        
			

	}
	



	public static void main(String[] args)
	{

		/*Pattern p = Pattern.compile("(?<=[^c]a)\\d*(?=bd)");  
		   String str = "da12b ka3434bd ca4343bd";  
		   String astr = "5569 452369";  
		   
		   Matcher m = p.matcher(str);  
		   Matcher n = p.matcher(astr);
		   while(m.find()){  
		     System.out.println("1:"+m.group());  
		   }  
		   while(n.find()){  
			     System.out.println("2:"+n.group());  
			   } */
	}
}
		
			
			
		

		
		
		
		
		
	


