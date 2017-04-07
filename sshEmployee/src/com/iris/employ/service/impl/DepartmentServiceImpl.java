package com.iris.employ.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.iris.employ.dao.DepartmentDao;
import com.iris.employ.dao.impl.DepartmentDaoImpl;
import com.iris.employ.domain.Department;
import com.iris.employ.domain.PageBean;
import com.iris.employ.service.DepartmentService;

/*
 * 部门管理的业务层的实现类
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//注入一个部门管理的Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	
	//分页查询部门的方法
	 @Transactional
	public PageBean<Department> findByPage(Integer currPage) {
		System.out.println("DepartmentService的findByPage()方法执行了....");
		PageBean<Department> pageBean = new PageBean<Department>();
		//封装当前的页数
		pageBean.setCurrPage(currPage);
		//封装每页显示的记录数
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//封装总记录数
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//封装总页数
		double tc = totalCount;
		Double totalPage = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//封装每页显示的数据
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	 /*
	  * 业务层保存部门的一个方法
	  * @see com.iris.employ.service.DepartmentService#save(com.iris.employ.domain.Department)
	  */
	
	@Transactional
	public void save(Department department) {
		System.out.println("Service  save()==============");
		departmentDao.save(department);
	}

//业务层修改记录的方法
	@Transactional
	public Department findById(Integer did) {
		return departmentDao.findById(did); 
		
	}

//业务层更改数据
	@Transactional
	public void update(Department department) {
		departmentDao.update(department);
		
	}


	@Transactional
	public void delete(Department department) {
		departmentDao.delete(department);
	}


	/*
	 * 查询所有的部门
	 */
	@Transactional
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
}
