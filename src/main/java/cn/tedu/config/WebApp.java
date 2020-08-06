package cn.tedu.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Spring MVC 框架大部分配置工作已经在AbstractAnnotationConfigDispatcherServletInitializer
 *中配置完成，只需要继承一下 就能获得Spring MVC的配置
 */
public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Filter[] getServletFilters() {
		//注册过滤器：注册一个Spring MVC 提供的编码过滤器
		return new Filter[] {new CharacterEncodingFilter("utf-8")};
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Call getRootConfigClasses");
		//告诉Spring MVC配置类位置
		return new Class[] {Config.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// 通知 Spring MVC。do请求由控制器进行处理
		return new String[] {"*.do"} ;
	}

}
