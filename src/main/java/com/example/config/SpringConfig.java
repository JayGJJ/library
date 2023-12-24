package com.example.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({MyBatisConfig.class, JdbcConfig.class})
	/*
	等同于<context:component-scan base-package="com.example.service">
	 */
@ComponentScan(value = "com.example.service")
	/*
	将MyBatisConfig类和JdbcConfig类交给Spring管理
	 */
public class SpringConfig {
}

