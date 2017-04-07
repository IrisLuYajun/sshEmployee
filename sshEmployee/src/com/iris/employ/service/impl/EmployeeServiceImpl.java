package com.iris.employ.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.iris.employ.dao.EmployeeDao;
import com.iris.employ.dao.impl.EmployeeDaoImpl;
import com.iris.employ.domain.Employee;
import com.iris.employ.domain.PageBean;
import com.iris.employ.service.EmployeeService;



public class EmployeeServiceImpl implements EmployeeService {
	private EmployeeDao employDao;

	public EmployeeDao getEmployDao() {
		return employDao;
	}

	public void setEmployDao(EmployeeDao employDao) {
		this.employDao = employDao;
	}


	/*
	 * 业务层的登录方法
	 */
	@Transactional
	public Employee login(Employee employee) {
		System.out.println("Service中的login执行了....");
		Employee exitsEmployee = employDao.findByNameAndPassword(employee);
		return exitsEmployee;
	}

	/*
	 * 业务层分页查询员工的方法
	 * (non-Javadoc)
	 * @see com.iris.employ.service.EmployeeService#findByPage(java.lang.Integer)
	 */
	@Transactional
	public PageBean<Employee> findByPage(Integer currPage) {
		System.out.println("Service===================findByPage()");
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//封装当前页数
		pageBean.setCurrPage(currPage);
		//封装每页记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = employDao.findTotalSize();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double totalPage = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Employee> list = employDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	@Transactional
	public void save(Employee employee) {
		employDao.save(employee);
	}

	/*
	 * 业务层根据员工ID查询员工的方法
	 * 
	 */
	@Transactional
	public Employee findById(Integer eid) {

		return employDao.findById(eid);
	}

	@Transactional
	public void update(Employee employee) {
		employDao.update(employee);
	}

	@Transactional
	public void delete(Employee employee) {
		employDao.delete(employee);
	}
	
	
	
}
