package com.hcl.fusion.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.hcl.fusion") 
public class ThymeleafConfig extends WebMvcConfigurerAdapter {
	@Bean
	public TemplateResolver getTemplateResolver() {
		TemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		return templateResolver;
	}
	@Bean
	public SpringTemplateEngine getTemplateEngine(){
		SpringTemplateEngine templateEngine=new SpringTemplateEngine();
		templateEngine.setTemplateResolver(getTemplateResolver());
		System.out.println("this thymleafconfig class"+templateEngine);
		return templateEngine;

	}
	@Bean
	public ThymeleafViewResolver getViewResolver(){
		ThymeleafViewResolver viewResolver=new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(getTemplateEngine());
		System.out.println("this thymleafconfig class"+viewResolver);
		return viewResolver;	
	}

}
