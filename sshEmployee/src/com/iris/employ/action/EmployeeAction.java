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
 * Ա�������Action��
 */
public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>{
	//ģ������ʹ�õĶ���
	private Employee employee = new Employee();
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
	//ע��ҵ�����
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
	 * ��¼ִ�еķ���
	 * @return
	 */
	public String login() {
		System.out.println("Action�е�loginִ����....");
		//if(employee.getUsername() == null){
			//this.addActionError("�������û���������");
			//return "filure";
		//}
		//����ҵ������
		Employee existEmployee = employeeService.login(employee);
	
		if(existEmployee == null) {
			//������
			this.addActionError("�û������������!");
			return "filure";
			
		}else{//����
			
			//�����󱣴浽session��ȥ��existEmployee�Ǹ�Ա�������ƣ���ȡ��ʱ��ҲҪ�������ƴ���get����
			ActionContext.getContext().getSession().put("existEmployee", existEmployee);
			System.out.println("�����û���session�ˣ�");
			if(existEmployee.getAdmin() == true)
				return "Admin_success";
			else
				return "Employee_success";
			
		}
		
		
		
	}
	
	//���յ�ǰҳ��
	private Integer currPage = 1;
	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}
	/*
	 * ��ҳ��ѯ
	 */
	public String findAll() {
		System.out.println("Action===================findAll()");
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "findAll";
	}
	/*
	 * ��ת�����Ա��ҳ��ִ�еķ���
	 */
	public String saveUI() {
		//��ѯ���в���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "saveUI";
	}
	/*
	 * ����Ա����ִ�з���
	 */
	public String save() {
		employeeService.save(employee);
		return "saveSuccess";
	}
	/*
	 * �༭Ա��
	 */
	public String edit() {
		//����Ա����id��ѯԱ��
		employee = employeeService.findById(employee.getEid());
		//��ѯ���в���
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		return "editSuccess";
	}
	/*
	 * ���¼�¼
	 */
	public String update() {
		employeeService.update(employee);
		return "updateSuccess";
	}
	/*
	 * ɾ��
	 */
	public String delete() {
		//${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"
		//ҳ��ֻ������id,����Ҫ�Ȳ�ѯ
		employee = employeeService.findById(employee.getEid());
		employeeService.delete(employee);
		return "deleteSuccess";
	}

	
}
