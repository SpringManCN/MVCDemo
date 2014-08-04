package com.dyl.demo.core.viewModel;

/**
 * 由于没有找到怎样在extjs的grid中显示关联数据
 * 只有在后台简历一个viewModel用来把后台数据转换成前台的数据格式
 * @author Administrator
 *
 */
public class UserView {
	private String uuid;		//用户ID
	private String userName;	//用户名称
	private String realName;	//用户真实姓名
	private String roleName;	//用户的角色名称
	private String departName;	//用户的部门名称
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDepartName() {
		return departName;
	}
	public void setDepartName(String departName) {
		this.departName = departName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	
}
