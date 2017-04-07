package com.iris.employ.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.iris.employ.dao.DepartmentDao;
import com.iris.employ.dao.impl.DepartmentDaoImpl;
import com.iris.employ.domain.Department;
import com.iris.employ.domain.PageBean;
import com.iris.employ.service.DepartmentService;

/*
 * ���Ź����ҵ����ʵ����
 */
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	//ע��һ�����Ź����Dao
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	
	//��ҳ��ѯ���ŵķ���
	 @Transactional
	public PageBean<Department> findByPage(Integer currPage) {
		System.out.println("DepartmentService��findByPage()����ִ����....");
		PageBean<Department> pageBean = new PageBean<Department>();
		//��װ��ǰ��ҳ��
		pageBean.setCurrPage(currPage);
		//��װÿҳ��ʾ�ļ�¼��
		int pageSize = 3;
		pageBean.setPageSize(pageSize);
		//��װ�ܼ�¼��
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		//��װ��ҳ��
		double tc = totalCount;
		Double totalPage = Math.ceil(tc/pageSize);
		pageBean.setTotalPage(totalPage.intValue());
		//��װÿҳ��ʾ������
		int begin = (currPage - 1) * pageSize;
		List<Department> list = departmentDao.findByPage(begin,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	 /*
	  * ҵ��㱣�沿�ŵ�һ������
	  * @see com.iris.employ.service.DepartmentService#save(com.iris.employ.domain.Department)
	  */
	
	@Transactional
	public void save(Department department) {
		System.out.println("Service  save()==============");
		departmentDao.save(department);
	}

//ҵ����޸ļ�¼�ķ���
	@Transactional
	public Department findById(Integer did) {
		return departmentDao.findById(did); 
		
	}

//ҵ����������
	@Transactional
	public void update(Department department) {
		departmentDao.update(department);
		
	}


	@Transactional
	public void delete(Department department) {
		departmentDao.delete(department);
	}


	/*
	 * ��ѯ���еĲ���
	 */
	@Transactional
	public List<Department> findAll() {
		return departmentDao.findAll();
	}
}
