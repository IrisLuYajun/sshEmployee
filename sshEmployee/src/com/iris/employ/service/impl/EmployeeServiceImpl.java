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
	 * ҵ���ĵ�¼����
	 */
	@Transactional
	public Employee login(Employee employee) {
		System.out.println("Service�е�loginִ����....");
		Employee exitsEmployee = employDao.findByNameAndPassword(employee);
		return exitsEmployee;
	}

	/*
	 * ҵ����ҳ��ѯԱ���ķ���
	 * (non-Javadoc)
	 * @see com.iris.employ.service.EmployeeService#findByPage(java.lang.Integer)
	 */
	@Transactional
	public PageBean<Employee> findByPage(Integer currPage) {
		System.out.println("Service===================findByPage()");
		PageBean<Employee> pageBean = new PageBean<Employee>();
		//��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = employDao.findTotalSize();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double totalPage = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//��װÿҳ��ʾ������
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
	 * ҵ������Ա��ID��ѯԱ���ķ���
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
