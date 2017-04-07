package com.iris.employ.action;

import com.iris.employ.domain.Department;
import com.iris.employ.domain.PageBean;
import com.iris.employ.service.DepartmentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import freemarker.core.ReturnInstruction.Return;

public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	//ע�벿�Ź����ҵ����
	private DepartmentService departmentService;
	// ����ģ�������Ķ���
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
	//���յ�ǰҳ��
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	//�ṩһ����ѯ����
	public String findAll() {
		System.out.println("DepartmentAction��findAll()����ִ����....");
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		//��pageBean���뵽ֵջ��
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
		
	}
	//��ת����Ӳ���ҳ��ķ���
	public String saveUI(){
		return "saveUI";
	}
	//��Ӳ��ŵķ���
	public String save() {
		System.out.println("Action  save()================");
		departmentService.save(department);
		return "saveSuccess";
	}
	//�༭����ִ�еķ���
	public String edit() {
		//���ص�department������ģ�������У�Ĭ�ϴ�����ֵջ��
		department = departmentService.findById( department.getDid());
		return "editSuccess";
	}
	//�޸Ĳ���ִ�еķ���
	public String update() {
		departmentService.update(department);
		return "updateSuccess";
		
	}
	//ɾ������ִ�еķ���
	public String delete() {
		department = departmentService.findById(department.getDid());
		departmentService.delete(department);
		return "deleteSuccess";
	}
	

}
