package com.iris.employ.action;

import java.util.List;

import com.iris.employ.domain.Department;
import com.iris.employ.domain.Employee;
import com.iris.employ.domain.PageBean;
import com.iris.employ.service.DepartmentService;
import com.iris.employ.service.EmployeeService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/*
 * 员工管理的Action类
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//模型驱动使用的对象
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//注入业务层类
	private EmployeeService employeeService;
	private DepartmentService departmentService;
	
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	public EmployeeService getEmployeeService() {
		return employeeService;
	}


	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	/*
	 * 登录执行的方法
	 * @return
	 */
	public String login() {
		System.out.println("Action中的login执行了....");
		//if(employee.getUsername() == null){
			//this.addActionError("请输入用户名或密码");
			//return "filure";
		//}
		//调用业务层的类
		Employee existEmployee = employeeService.login(employee);
	
		if(existEmployee == null) {
			//不存在
			this.addActionError("用户名或密码错误!");
			return "filure";
			
		}else{//存在
			
			//将对象保存到session中去，existEmployee是该员工的名称，获取的时候也要将该名称传入get函数
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			System.out.println("保存用户到session了！");
			if(existEmployee.getAdmin() == true)
				return "Admin_success";
			else
				return "Employee_success";
			
		}
		
		
		
	}
	
	//接收当前页数
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	/*
	 * 分页查询
	 */
	public String findAll() {
		System.out.println("Action===================findAll()");
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/*
	 * 跳转到添加员工页面执行的方法
	 */
	public String saveUI() {
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/*
	 * 保存员工的执行方法
	 */
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}
	/*
	 * 编辑员工
	 */
	public String edit() {
		//根据员工的id查询员工
		employee = employeeService.findById(employee.getEid());
		//查询所有部门
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/*
	 * 更新记录
	 */
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
	/*
	 * 删除
	 */
	public String delete() {
		//${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"
		//页面只传来了id,所以要先查询
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}

	
}
