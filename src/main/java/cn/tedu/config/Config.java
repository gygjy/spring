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
@EnableWebMvc  //开启Spring的MVC组件配置
public class Config {
	/*
	 * 配置试图解析器：Thymeleaf 试图解析器
	 */
	@Bean
	public ThymeleafViewResolver viewResolver(){
	    System.out.println("init ThymeleafViewResolver");

	    //设置模板保存位置为 /resources/templates/*.html
	    ClassLoaderTemplateResolver templateResolver = 
	            new ClassLoaderTemplateResolver();
	    //模版存储文件夹
	    templateResolver.setPrefix("/templates/");
	    //模版后缀
	    templateResolver.setSuffix(".html");
	    templateResolver.setCharacterEncoding("UTF-8");
	    templateResolver.setTemplateMode(TemplateMode.HTML);
	    templateResolver.setCacheable(true);
	    //创建模板引擎
	    SpringTemplateEngine templateEngine = 
	            new SpringTemplateEngine();
	    templateEngine.setTemplateResolver(templateResolver);
	    templateEngine.setEnableSpringELCompiler(true);
	    //创建模版解析器
	    ThymeleafViewResolver viewResolver =
	            new ThymeleafViewResolver();
	    viewResolver.setCharacterEncoding("UTF-8");
	    viewResolver.setTemplateEngine(templateEngine); 
	    return viewResolver;
	}
}
