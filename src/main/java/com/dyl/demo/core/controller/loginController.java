package com.dyl.demo.core.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dyl.demo.core.model.User;
import com.dyl.demo.core.service.UserService;
import com.dyl.demo.util.MD5Util;

@Controller
public class loginController {
	
	@Resource
	private UserService userService;
	
	@RequestMapping("/login")
	public String  login(Model model,@ModelAttribute User user){
		System.out.println(user.getUserName());
		if(user.getPassword()!=null&&!user.getPassword().equals("")){
			String password = MD5Util.MD5(user.getPassword());
			user.setPassword(password);
		}
		try {
			User user1 = userService.findByUser(user);
			if(user1!=null){
				model.addAttribute("user", user);
				return "index";
			}else{
				return "login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "login";
		}
	}
}
