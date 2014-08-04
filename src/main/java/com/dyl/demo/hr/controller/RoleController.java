package com.dyl.demo.hr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyl.demo.hr.model.Role;
import com.dyl.demo.hr.service.RoleService;
import com.dyl.demo.hr.viewModel.RoleView;

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private RoleService roleService;
	
	
	/**
	 * 添加角色
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveOrUpdata")
	public @ResponseBody Object  saveOrUpdata(Model model,@ModelAttribute Role role){
		try {
			if(role.getUuid().equals("")){
				role.setUuid(null);
			}
			roleService.saveOrUpdate(role);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody List<RoleView>  findAll(Model model,int page,int start,int limit){
		try {
			//查找所有角色
			List<Role> roleList=roleService.findAll(page,limit);
			
			List<RoleView> rvList = new ArrayList<RoleView>();
			for(Role role:roleList){
				RoleView rv = new RoleView();
				rv.setUuid(role.getUuid());
				rv.setRoleName(role.getRoleName());
				rv.setNote(role.getNote());
				rvList.add(rv);
			}
			
			
			return rvList;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	/**
	 * 删除角色
	 * @param model
	 * @param uuids
	 * @return
	 */
	@RequestMapping("/delete")
	public @ResponseBody String delete(Model model,String[] uuids){
		try {
			for(String uuid :uuids){
				roleService.delete(uuid);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
		

}
