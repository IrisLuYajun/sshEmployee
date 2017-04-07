package com.iris.employ.dao;

import java.util.List;

import com.iris.employ.domain.Employee;

/*
 * 员工的Dao接口
 */
public interface EmployeeDao {

	Employee findByNameAndPassword(Employee employee);

	int findTotalSize();

	List<Employee> findByPage(int begin, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);



}
