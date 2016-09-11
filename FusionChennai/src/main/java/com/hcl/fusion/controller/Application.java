package com.hcl.fusion.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.hcl.fusion.config.DbConfig;
import com.hcl.fusion.config.ThymeleafConfig;
import com.hcl.fusion.config.WebIntializer;


@SpringBootApplication
@Import(value = {ThymeleafConfig.class,WebIntializer.class,DbConfig.class})
@ComponentScan(basePackages="com.hcl.fusion")
@EnableJpaRepositories
@EnableAutoConfiguration
public class Application{

	
	 public static void main(String[] args) throws Exception {
	      ApplicationContext ac=  SpringApplication.run(Application.class, args);
	        System.out.println("hi this fusion chennai Boot Application");
	        //System.out.println(ac.getBean(Application.class).ds);
	    }
	 	 
}
