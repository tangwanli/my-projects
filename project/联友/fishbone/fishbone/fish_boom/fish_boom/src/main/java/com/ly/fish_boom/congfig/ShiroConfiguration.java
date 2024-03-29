package com.ly.fish_boom.congfig;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.ly.fish_boom.realm.MyRealm;

@Configuration
public class ShiroConfiguration {
	 	@Bean
	    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
	        return new LifecycleBeanPostProcessor();
	    }
	 	
	 	@Bean
	    public SecurityManager securityManager(){
	        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
	        securityManager.setRealm(getRealm());
	        return securityManager;
	    }
	 	@Bean
	    public MyRealm getRealm(){
	        MyRealm myShiroRealm = new MyRealm();
	        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
	        return myShiroRealm;
	    }
	 	@Bean
	    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
	 		//拦截器.
	        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();
	        shiroFilterFactoryBean.setSecurityManager(securityManager);
	        return shiroFilterFactoryBean;
	    }
	 	@Bean
	    public HashedCredentialsMatcher hashedCredentialsMatcher(){
	        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
	        hashedCredentialsMatcher.setHashAlgorithmName("md5");
	        hashedCredentialsMatcher.setHashIterations(2);
	        return hashedCredentialsMatcher;
	    }
	 	/**
	     *  开启shiro aop注解支持.
	     *  使用代理方式;所以需要开启代码支持;
	     * @param securityManager
	     * @return
	     */
	 	@Bean
	    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
	        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
	        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
	        return authorizationAttributeSourceAdvisor;
	    }
}
