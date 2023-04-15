package com.ly.fish_boom.congfig;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
@Configuration
@MapperScan("com.ly.fish_boom.mapper")
public class Mybatispluscongfig {
	@Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
