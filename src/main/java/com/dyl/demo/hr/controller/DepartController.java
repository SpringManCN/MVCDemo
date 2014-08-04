package com.dyl.demo.hr.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dyl.demo.hr.model.Depart;
import com.dyl.demo.hr.service.DepartService;
import com.dyl.demo.hr.viewModel.DepartView;

@Controller
@RequestMapping("/depart")
public class DepartController {
	
	@Resource
	private DepartService departService;

	
	/**
	 * 添加角色
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping("/saveOrUpdata")
	public @ResponseBody Object  saveOrUpdata(Model model,@ModelAttribute Depart depart){
		try {
			if(depart.getUuid().equals("")){
				depart.setUuid(null);
			}
			if(depart.getDepart().getUuid() != null){
				Depart depart2 = departService.findById(depart.getDepart().getUuid());
				depart.setDepart(depart2);
			}
			departService.saveOrUpdate(depart);
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	@RequestMapping("/findAll")
	public @ResponseBody List<DepartView>  findAll(Model model,String node,String uuid){
		try {
			if(uuid.equals("")||node!=null){
				uuid=null;
			}
			//查找所有角色
			List<Depart> departList=departService.findByPid(uuid);
			
			List<DepartView> dvList =new ArrayList<DepartView>();
			//把数据库中的数据转换成extjs能识别的数据
			for(Depart depart : departList){
				DepartView dv1 = new DepartView();
				dv1.setUuid(depart.getUuid());
				dv1.setText(depart.getDepartName());
				if(depart.getDepart()!=null){
					dv1.setPid(depart.getDepart().getUuid());
				}
				dv1.setNote(depart.getNote());
				//判断是否有下级
				if(depart.getDeparts().size()>0){//如果没有下级
					dv1.setLeaf(false);
				}else{
					dv1.setLeaf(true);
				}
				dvList.add(dv1);
				
			}
			
			
			return dvList;
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
				departService.delete(uuid);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}

}
