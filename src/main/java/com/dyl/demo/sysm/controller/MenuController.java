package com.dyl.demo.sysm.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



import com.dyl.demo.sysm.model.Menu;
import com.dyl.demo.sysm.service.MenuService;
import com.dyl.demo.sysm.viewModel.MenuView;

@Controller
@RequestMapping(value="/menu")
public class MenuController {
	
	@Resource
	private MenuService menuService;
	
	/**
	 * 添加角色
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveOrUpdata")
	public @ResponseBody Object  saveOrUpdata(Model model,@ModelAttribute Menu menu){
		try {
			if(menu.getUuid().equals("")){
				menu.setUuid(null);
			}
			if(menu.getMenu().getUuid() != null){
				Menu menu2 = menuService.findById(menu.getMenu().getUuid());
				menu.setMenu(menu2);
			}
			menuService.saveOrUpdate(menu);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody List<MenuView>  findAll(Model model,String node,String uuid){
		try {
			System.out.println(uuid);
			if(node!=null){
				if(uuid.equals("")||node.equals("root")){
					uuid=null;
				}
			}
			
			List<Menu> mList = menuService.findByPid(uuid); 
			
			List<MenuView> mvList = new ArrayList<MenuView>();
			
			//把数据库中的数据转换成extjs能识别的数据
			for(Menu menu : mList){
				MenuView mv =new MenuView();
				mv.setUuid(menu.getUuid());
				if(menu.getMenu()!=null){
					mv.setPid(menu.getMenu().getUuid());
				}
				mv.setText(menu.getText());;
				mv.setView(menu.getView());
				mv.setContr(menu.getContr());
				//判断是否有下级
				if(menu.getMenus().size()>0){//如果没有下级
					mv.setLeaf(false);
				}else{
					mv.setLeaf(true);
				}
				mvList.add(mv);
				
			}
			
			return mvList;
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
				menuService.delete(uuid);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
}
