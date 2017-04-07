package com.iris.employ.dao.impl;

import java.util.List;

import javax.management.Query;


import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.iris.employ.dao.EmployeeDao;
import com.iris.employ.domain.Employee;



/*
 * 员工管理Dao的实现类
 */
public class EmployeeDaoImpl implements EmployeeDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	/*
	 * 验证：DAO中根据用户名和密码查询用户
	 */
	public Employee findByNameAndPassword(Employee employee) {
		System.out.println("Dao中的findByNameAndPassword执行了....");
		String hql = "from Employee where username = ? and password = ?";
		org.hibernate.Query query = this.sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter(0, employee.getUsername());
		query.setParameter(1, employee.getPassword());
		List<Employee> list = query.list();
		//sessionFactory.close();
		if(list.size() > 0) {
			return list.get(0);
		} else{
			return null;
		}
		
	}

/*
 * 分页查询的方法
 */
	@Override
	public int findTotalSize() {
		System.out.println("Dao===================findTotalSize()");
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "select count(*) from Employee";
		org.hibernate.Query query = session.createQuery(hql);
		List<Long> list = query.list();
		if(list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}


	@Override
	public List<Employee> findByPage(int begin, int pageSize) {
		System.out.println("Dao===================findByPage()");
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from Employee";
		org.hibernate.Query query = session.createQuery(hql);
		query.setFirstResult(begin);//从哪一条开始读取
		query.setMaxResults(pageSize);//每页显示多少条
		List<Employee> list = query.list();
		return list;
	}


	@Override
	public void save(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(employee);
	}

	/*
	 * DAO中根据员工id查询员工的方法
	 */
	@Override
	public Employee findById(Integer eid) {
		Session session = this.sessionFactory.getCurrentSession();
		return (Employee) session.get(Employee.class, eid);
	}


	@Override
	public void update(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(employee);
	}


	@Override
	public void delete(Employee employee) {
		Session session =this.sessionFactory.getCurrentSession();
		session.delete(employee);
	}

	
	
	
}
