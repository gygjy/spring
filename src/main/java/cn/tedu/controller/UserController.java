package cn.tedu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.form.UserForm;

@Controller
public class UserController {
	@RequestMapping("/handle_reg.do")
	public String handleReg(String username,String password,Integer age,String phone,String email,ModelMap map) {
		System.out.println(username);
		System.out.println(password);
		System.out.println(age);
		System.out.println(phone);
		System.out.println(email);
		map.put("msg", "成功收到注册信息");
		return "msg";
	}
	@RequestMapping("/handle_reg2.do")
	public String reg2(UserForm form,ModelMap map) {
		System.out.println(form);
		map.put("msg","收到信息");
		return "msg";
	}
}
