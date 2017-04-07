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
 * ���Ź����Daoʵ����
 */
public class DepartmentDaoImpl implements DepartmentDao{
 SessionFactory sessionFactory;

public void setSessionFactory(SessionFactory sessionFactory) {
	this.sessionFactory = sessionFactory;
}

//ͳ�Ƹ���
public int findCount() {
	System.out.println("Dao�е�findCountִ����....");
	String hql = "select count(*) from Department";
	org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
	List<Long> list = query.list();
	if(list.size() > 0) {
		return list.get(0).intValue();
	}
	return 0;
}
//��ҳ��ѯ
public List<Department> findByPage(int begin, int pageSize) {
	System.out.println("DepartmentDao��findByPage����ִ����....");
	//DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
	Session session = this.sessionFactory.getCurrentSession();
	String hql = "from Department ";
	Query query = session.createQuery(hql);
	query.setFirstResult(begin);//�ӵڼ�����ʼ��ȡ����
	query.setMaxResults(pageSize);//����ÿҳ�����ʾ�ļ�¼����
	List<Department> list = query.list();
	return list;
}


//
public void save(Department department) {
	System.out.println("department�е�save()============");
	Session session = sessionFactory.getCurrentSession();
	session.save(department);//����
	
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
 * ��ѯ���в���
 */
public List<Department> findAll() {
	Session session = this.sessionFactory.getCurrentSession();
	String hql = "from Department";
	Query query = session.createQuery(hql);
	List<Department> list = query.list();
	return list;
}

}
