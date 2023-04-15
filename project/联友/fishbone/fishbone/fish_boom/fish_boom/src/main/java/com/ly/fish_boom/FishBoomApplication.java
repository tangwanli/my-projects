package com.ly.fish_boom;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;
@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class FishBoomApplication {
	public static void main(String[] args) {
		SpringApplication.run(FishBoomApplication.class, args);
	}

}
