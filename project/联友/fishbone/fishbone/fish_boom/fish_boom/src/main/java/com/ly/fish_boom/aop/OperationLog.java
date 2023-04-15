/**
 * File OperationLog.java
 * Data	Author	Changes
 * 2019年10月23日 上午9:43:01	ly-lizhyi	
 */
package com.ly.fish_boom.aop;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.ConversionException;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ly.fish_boom.entity.Doc;
import com.ly.fish_boom.entity.Opera;
import com.ly.fish_boom.entity.User;
import com.ly.fish_boom.service.IOperaService;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.lang.Console;
import cn.hutool.cron.task.Task;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

/**
 * 
 * @author ly-lizhyi 2019年10月23日 上午9:43:01
 * @version 1.0
 */
@Aspect
@Component 
public class OperationLog {
	private static Logger LOG = Logger.getLogger(OperationLog.class);
	@Autowired
	private IOperaService ios;
	public OperationLog() {
		Console.log("--------AOP 开启---------");
	}
	 @Pointcut("execution(* com.ly.fish_boom.controller..*.*(..))")  
	 public void controllerAspect(){
	    }//定义一个切入点
	 @SuppressWarnings("all")
	 @After("controllerAspect()")
	 public void after(JoinPoint jp) {
		 String logContent="";
		 Integer id=null;
		 String userName="";
		 String updateValue="";
		 //controller类的名字
		 String targetName=jp.getTarget().getClass().getName();
		 //切点方法的名字
		 String targetMethod=jp.getSignature().getName();
		 JSONObject params=null;
		 Class targetClass=null;
		 Class entity=null;
		 String entityName="";
		 String operateField=null;
		 String operation="";
		 try {
			 targetClass=Class.forName(targetName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 Method[] methods=targetClass.getMethods();
		 for(Method m:methods) {
			 //拿到切点方法
			 if(m.getName().equals(targetMethod)) {
				 if(m.getAnnotation(MyLog.class)!=null) {//判断过滤处理加 了注解的方法
					//拿到切点方法参数
					 Object[] args=jp.getArgs();
					 for(Object arg:args) {
							 if(arg instanceof String)
								 params=JSONUtil.parseObj(arg);
							 if(arg instanceof Integer)
								 id=(Integer) arg;
					 }
					 //操作名
					 logContent=m.getAnnotation(MyLog.class).operation();
					 userName=getUserName();
					 entity=m.getAnnotation(MyLog.class).entity();
					 //判断有没有指定的实体类,有修改才会进入
					 if(entity!=null) {
						 entityName=entity.getSimpleName();
						 //获取类中的字段
						 List<Field> fields=new ArrayList<Field>();
						 while(entity!=null) {
							 fields.addAll(Arrays.asList(entity.getDeclaredFields()));
							 entity=entity.getSuperclass();
						 }
						 for(Field field:fields) {
							 field.setAccessible(true);
							 String fieldName=field.getName();
							 if(field.getAnnotation(MyLog.class)!=null) {
								 if(params.containsKey(fieldName)){
									 String fieldDesc=field.getAnnotation(MyLog.class).desc();
									 String values=params.getStr(fieldName);
									 //判断json数组的字段
									 if(JSONUtil.isJsonArray(values.toString())) {
										 JSONArray users=JSONUtil.parseArray(values);
										 List<String> names=new ArrayList<String>();
										 for(int i=0;i<users.size();i++) {
											 JSONObject user=users.getJSONObject(i);
											 String name=user.getStr("name");
											 names.add(name);
										 }
										values=names.isEmpty()?"NULL":names.toString();	 
									 }
									 if(JSONUtil.isJsonObj(values)) {
										  JSONObject proj=JSONUtil.parseObj(values);
										 String names=proj.getStr("name");
										  values=names.isEmpty()?"NULL":names.toString();	
									 }
										 updateValue="为："+values;
										 logContent=logContent+fieldDesc+updateValue;
										 break;
							 }
							 }
							 
						 }
					 }
					 Opera op=new Opera();
					 op.setContent(logContent);
					 op.setCreator(userName);
					 if(entityName.equals("TaskVo") )
						 op.setTid(id);
					 else if(entityName.equals("ProjectVo"))
						 op.setPid(id);
					 ios.save(op);
				 }
			 }
				 
		 }
		 
		
	 }
		 
	 private String getUserName() {
		 RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		    ServletRequestAttributes sra = (ServletRequestAttributes)ra;
		    HttpServletRequest request = sra.getRequest();
		    User user=(User) request.getSession().getAttribute("user");
		    return user.getName();
	 }
}
