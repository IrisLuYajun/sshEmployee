package com.iris.employ.dao;

import java.util.List;

import com.iris.employ.domain.Department;

/*
 * 部门管理的Dao接口
 */
public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int begin, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();



}
