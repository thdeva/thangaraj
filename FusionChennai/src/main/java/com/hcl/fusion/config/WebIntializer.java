package com.hcl.fusion.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.hcl.fusion.config.ThymeleafConfig;

public class WebIntializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("this is WebIntializer class getRootConfigClasses()");
		// TODO Auto-generated method stub
		return new Class[]{ThymeleafConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		System.out.println("this is the WebIntializer class getServletConfigClasses()");
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		System.out.println("this is WebIntializer class getServletMappings()");
		return new String[] {"/"};
	}

}
