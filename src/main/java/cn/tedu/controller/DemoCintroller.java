package cn.tedu.controller;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DemoCintroller {
	/*
	 * @RequestMapping用于申明 web url 请求路径
	 * 这里讲/hello.do  请求映射到Hello()方法
	 * http://localhost:8080/springmvc01/hello.do
	 * 就会执行方法Hello(),控制台出现Hello world
	 * 浏览器得到 Hello world
	 */
	@RequestMapping("/hello.do")
	@ResponseBody //将方法返回值作为响应的Body正文信息发送
	public String hello() {
		System.out.println("Hello World");
		return "Hello World";
	}
	//返回系统时间
	//http://localhost:8080/springmvc01/date.do
	@RequestMapping("/date.do")
	@ResponseBody
	public String data() {
		//LocalDate.now().toString(); 获取当前时间字符串
		String date = LocalDate.now().toString();
		System.out.println(date);
		return date;
	}
	@RequestMapping("/istime.do")
	@ResponseBody
	public String istime() {
		String time = LocalTime.now().toString();
		System.out.println(time+"该吃饭了");
		return time+"该吃饭了";
	}
	/*
	 * 控制器执行后，转发到/resources/templates/
	 * 使用hello.html 作为显示试图
	 * 不要使用@ResponseBody,直接返回一个试图名称“hello”
	 * 试图解析器根据前后缀自动找到试图模板
	 * "/templates/"+hello+".html" 
	 *
	 */
	@RequestMapping("/demo.do")
	public String demo() {
		System.out.println("call demo()");
		//返回hello 就是返回模板/templates/hello.html
		return "hello";
	}
	/*
	 * 控制器中数据显示的模板中
	 */
	@RequestMapping("/show.do")
	public ModelAndView show() {
		//ModelAndView 是Spring 提供的组件，用于封装
		//模板上显示的数据，和模板试图名称
		ModelAndView mv = new ModelAndView("show");
		//添加需要在模板上显示的数据
		mv.addObject("time",LocalTime.now().toString());
		mv.addObject("msg","到时间了!");
		return mv;
	}
	/*
	 * 第二种数据传输方式
	 * 利用ModelMap传递数据
	 * 
	 */
	@RequestMapping("/show2.do")
	public String show2(ModelMap map) {
		map.put("time",LocalTime.now().toString());
		map.put("msg","日期到了!");
		return "show";
	}
	
}
