package com.iris.employ.service;

import com.iris.employ.domain.Employee;
import com.iris.employ.domain.PageBean;

/*
 * 员工管理的业务层接口
 */
public interface EmployeeService {

	Employee login(Employee employee);

	PageBean<Employee> findByPage(Integer currPage);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);
	
}
