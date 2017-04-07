package com.iris.employ.service;

import java.util.List;

import com.iris.employ.domain.Department;
import com.iris.employ.domain.PageBean;

/*
 * ���Ź����ҵ���Ľӿ�
 */
public interface DepartmentService {

	PageBean<Department> findByPage(Integer currPage);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();



}
