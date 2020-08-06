package cn.tedu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

@Configuration
@ComponentScan(basePackages = "cn.tedu.controller")
@EnableWebMvc  //����Spring��MVC�������
public class Config {
	/*
	 * ������ͼ��������Thymeleaf ��ͼ������
	 */
	@Bean
	public ThymeleafViewResolver viewResolver(){
	    System.out.println("init ThymeleafViewResolver");

	    //����ģ�屣��λ��Ϊ /resources/templates/*.html
	    ClassLoaderTemplateResolver templateResolver = 
	            new ClassLoaderTemplateResolver();
	    //ģ��洢�ļ���
	    templateResolver.setPrefix("/templates/");
	    //ģ���׺
	    templateResolver.setSuffix(".html");
	    templateResolver.setCharacterEncoding("UTF-8");
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setCacheable(true);
	    //����ģ������
	    SpringTemplateEngine templateEngine = 
	            new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    templateEngine.setEnableSpringELCompiler(true);
	    //����ģ�������
	    ThymeleafViewResolver viewResolver =
	            new ThymeleafViewResolver();
	    viewResolver.setCharacterEncoding("UTF-8");
	    viewResolver.setTemplateEngine(templateEngine); 
	    return viewResolver;
	}
}
