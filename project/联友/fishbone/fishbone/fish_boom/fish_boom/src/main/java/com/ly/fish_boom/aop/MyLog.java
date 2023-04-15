/**
 * File MyLog.java
 * Data	Author	Changes
 * 2019年10月23日 上午9:25:35	ly-lizhyi	
 */
package com.ly.fish_boom.aop;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.log4j.Logger;

/**
 * 
 * @author ly-lizhyi 2019年10月23日 上午9:25:35
 * @version 1.0
 */
@Target({ElementType.METHOD,ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyLog {
	public String operation() default "";
	public String desc() default "";
	public Class entity() default void.class;
}
