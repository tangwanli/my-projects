<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.jspsmart.upload.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  try {
  
  
    SmartUpload smart = new SmartUpload();
    
    smart.initialize(this.getServletConfig(), request, response);
    // 设置文件大小限制（单位：字节）  
/*smart.setMaxFileSize(10000000);             
// 设置总上传数据总大小（单位：字节）  
smart.setTotalMaxFileSize(20000000);  
// 设置允许的文件扩展名  
smart.setAllowedFilesList("jpg,png,gif,bmp,jpeg");  
// 设置不允许的文件扩展名  
smart.setDeniedFilesList("exe,bat,jsp,htm,html,,"); */
smart.upload();
    System.out.println("提交没");
    // 保存文件
    // 这个下面语句遍历所有的东西
    for (int i = 0; i < smart.getFiles().getCount(); i++) {  
    File file = smart.getFiles().getFile(i);  
      
    if (file.isMissing()) continue;  
   
        file.saveAs("F:/MyEclipse Save/location/" + file.getFileName());  
        System.out.println("提交成功");
}     
  } catch (Exception e) {
    e.printStackTrace();
  }
%>

</body>
</html>