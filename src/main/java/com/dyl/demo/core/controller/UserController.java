package com.dyl.demo.core.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyl.demo.core.model.User;
import com.dyl.demo.core.service.UserService;
import com.dyl.demo.core.viewModel.UserView;
import com.dyl.demo.util.MD5Util;

@Controller
@RequestMapping("/user")
public class UserController {
	
	
	
	@Resource
	private UserService userService;
	
	/**
	 * 添加用户
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveOrUpdata")
	public @ResponseBody Object  saveOrUpdata(Model model,@ModelAttribute User user){
		try {
			if(!user.getPassword().equals("")){
				//使用MD5对密码进行加密
				String password = MD5Util.MD5(user.getPassword());
				user.setPassword(password);
			}
			if(user.getUuid().equals("")){
				user.setUuid(null);
			}
			if(user.getPassword().equals("")){
				User user2 = userService.findById(user.getUuid());
				user2.setUserName(user.getUserName());
				user2.setRealName(user.getRealName());
				userService.saveOrUpdate(user2);
			}	
			else{
				userService.saveOrUpdate(user);
			}
		
			
			
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	/**
	 * 查找所有用户
	 * @param model
	 * @return
	 */
	@RequestMapping("/findAll")
	public @ResponseBody List<UserView>  findAll(Model model,int page,int start,int limit){
		try {
			//查找所有用户
			List<User> userList=userService.findAll(page,limit);
			//转换成页面的用户数据格式
			List<UserView> uvList =new ArrayList<UserView>();
			for(User user :userList){
				UserView uv =new UserView();
				uv.setUuid(user.getUuid());
				uv.setUserName(user.getUserName());
				uv.setRealName(user.getRealName());
				//防止用户角色为空报错
				if(user.getRole()!=null){
					uv.setRoleName(user.getRole().getRoleName());
				}
				//防止用户部门为空报错
				if(user.getDepart()!=null){
					uv.setDepartName(user.getDepart().getDepartName());
				}
				
				uvList.add(uv);
			}
			return uvList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	@RequestMapping("/delete")
	public @ResponseBody String delete(Model model,String[] uuids){
		try {
			for(String uuid :uuids){
				userService.delete(uuid);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
