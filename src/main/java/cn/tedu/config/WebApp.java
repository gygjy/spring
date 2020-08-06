package cn.tedu.config;


import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * Spring MVC ��ܴ󲿷����ù����Ѿ���AbstractAnnotationConfigDispatcherServletInitializer
 *��������ɣ�ֻ��Ҫ�̳�һ�� ���ܻ��Spring MVC������
 */
public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer {
	@Override
	protected Filter[] getServletFilters() {
		//ע���������ע��һ��Spring MVC �ṩ�ı��������
		return new Filter[] {new CharacterEncodingFilter("utf-8")};
	}
	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("Call getRootConfigClasses");
		//����Spring MVC������λ��
		return new Class[] {Config.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// ֪ͨ Spring MVC��do�����ɿ��������д���
		return new String[] {"*.do"} ;
	}

}
