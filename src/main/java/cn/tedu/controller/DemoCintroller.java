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
	 * @RequestMapping�������� web url ����·��
	 * ���ｲ/hello.do  ����ӳ�䵽Hello()����
	 * http://localhost:8080/springmvc01/hello.do
	 * �ͻ�ִ�з���Hello(),����̨����Hello world
	 * ������õ� Hello world
	 */
	@RequestMapping("/hello.do")
	@ResponseBody //����������ֵ��Ϊ��Ӧ��Body������Ϣ����
	public String hello() {
		System.out.println("Hello World");
		return "Hello World";
	}
	//����ϵͳʱ��
	//http://localhost:8080/springmvc01/date.do
	@RequestMapping("/date.do")
	@ResponseBody
	public String data() {
		//LocalDate.now().toString(); ��ȡ��ǰʱ���ַ���
		String date = LocalDate.now().toString();
		System.out.println(date);
		return date;
	}
	@RequestMapping("/istime.do")
	@ResponseBody
	public String istime() {
		String time = LocalTime.now().toString();
		System.out.println(time+"�óԷ���");
		return time+"�óԷ���";
	}
	/*
	 * ������ִ�к�ת����/resources/templates/
	 * ʹ��hello.html ��Ϊ��ʾ��ͼ
	 * ��Ҫʹ��@ResponseBody,ֱ�ӷ���һ����ͼ���ơ�hello��
	 * ��ͼ����������ǰ��׺�Զ��ҵ���ͼģ��
	 * "/templates/"+hello+".html" 
	 *
	 */
	@RequestMapping("/demo.do")
	public String demo() {
		System.out.println("call demo()");
		//����hello ���Ƿ���ģ��/templates/hello.html
		return "hello";
	}
	/*
	 * ��������������ʾ��ģ����
	 */
	@RequestMapping("/show.do")
	public ModelAndView show() {
		//ModelAndView ��Spring �ṩ����������ڷ�װ
		//ģ������ʾ�����ݣ���ģ����ͼ����
		ModelAndView mv = new ModelAndView("show");
		//�����Ҫ��ģ������ʾ������
		mv.addObject("time",LocalTime.now().toString());
		mv.addObject("msg","��ʱ����!");
		return mv;
	}
	/*
	 * �ڶ������ݴ��䷽ʽ
	 * ����ModelMap��������
	 * 
	 */
	@RequestMapping("/show2.do")
	public String show2(ModelMap map) {
		map.put("time",LocalTime.now().toString());
		map.put("msg","���ڵ���!");
		return "show";
	}
	
}
