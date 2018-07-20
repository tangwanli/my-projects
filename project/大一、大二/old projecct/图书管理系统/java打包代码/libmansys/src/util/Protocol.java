package util;

public class Protocol {

	public static String msg = null;
	private String temp = null;
	
	public Protocol()
	{
		// 调用这个构造函数的时候将temp清空。即，为了使temp的值只保存每一次运行的结果。
		temp = null;
	}
	
	
	public void setQueryBookMsg(int count, int id, String bookname, String autor, float price, String borrow)
	{
		// 第一次运行的时候需要把temp赋值，不然的话会吧null加到字符串里面去
		if(count == 1)
		{
			temp = id + "," + bookname + "," + autor + "," + price + "," + borrow + ";";
		} else
		{
			temp += id + "," + bookname + "," + autor + "," + price + "," + borrow + ";";
		}
		msg = count + "@" + temp;
	}
}
   
   
