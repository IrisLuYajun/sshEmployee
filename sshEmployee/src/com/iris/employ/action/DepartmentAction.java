package com.iris.employ.action;

import com.iris.employ.domain.Department;
import com.iris.employ.domain.PageBean;
import com.iris.employ.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.core.ReturnInstruction.Return;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//注入部门管理的业务类
	private DepartmentService departmentService;
	// 用于模型驱动的对象
	private Department department=new Department(); 
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public Department getModel() {
		return department;
	}
	//接收当前页数
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//提供一个查询方法
	public String findAll() {
		System.out.println("DepartmentAction的findAll()方法执行了....");
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//将pageBean存入到值栈中
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
		
	}
	//跳转到添加部门页面的方法
	public String saveUI(){
		return "saveUI";
	}
	//添加部门的方法
	public String save() {
		System.out.println("Action  save()================");
		departmentService.save(department);
		return "saveSuccess";
	}
	//编辑部门执行的方法
	public String edit() {
		//返回的department存在于模型驱动中，默认存在于值栈中
		department = departmentService.findById( department.getDid());
		return "editSuccess";
	}
	//修改部门执行的方法
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
		
	}
	//删除部门执行的方法
	public String delete() {
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	

}
