package com.iris.employ.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;

import com.iris.employ.dao.DepartmentDao;
import com.iris.employ.domain.Department;
import com.iris.employ.domain.Employee;

/*
 * 部门管理的Dao实现类
 */
public class DepartmentDaoImpl implements DepartmentDao{
 SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

//统计个数
public int findCount() {
	System.out.println("Dao中的findCount执行了....");
	String hql = "select count(*) from Department";
	org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
	List<Long> list = query.list();
	if(list.size() > 0) {
		return list.get(0).intValue();
	}
	return 0;
}
//分页查询
public List<Department> findByPage(int begin, int pageSize) {
	System.out.println("DepartmentDao的findByPage方法执行了....");
	//DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
	Session session = this.sessionFactory.getCurrentSession();
	String hql = "from Department ";
	Query query = session.createQuery(hql);
	query.setFirstResult(begin);//从第几条开始读取数据
	query.setMaxResults(pageSize);//设置每页最多显示的记录个数
	List<Department> list = query.list();
	return list;
}


//
public void save(Department department) {
	System.out.println("department中的save()============");
	Session session = sessionFactory.getCurrentSession();
	session.save(department);//保存
	
}


public Department findById(Integer did) {
	Session session = sessionFactory.getCurrentSession();
	return (Department) session.get(Department.class, did);
	
}


public void update(Department department) {
	Session session = sessionFactory.getCurrentSession();
	session.update(department);

}

@Override
public void delete(Department department) {
	Session session = sessionFactory.getCurrentSession();
	session.delete(department);
}

/*
 * 
 * 查询所有部门
 */
public List<Department> findAll() {
	Session session = this.sessionFactory.getCurrentSession();
	String hql = "from Department";
	Query query = session.createQuery(hql);
	List<Department> list = query.list();
	return list;
}

}
