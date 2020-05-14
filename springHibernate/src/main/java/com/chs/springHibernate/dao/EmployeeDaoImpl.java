package com.chs.springHibernate.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.chs.springHibernate.entity.Employee;
import com.chs.springHibernate.entity.EmployeeDtl;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List getEmployees() {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee";
		Query query = session.createQuery(hql);
		return query.getResultList();
	}

	@Override
	public void add(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(employee);
	}

	@Override
	public Employee findById(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Employee e where e.id = :employeeId";
		Query query = session.createQuery(hql);
		query.setParameter("employeeId", id);
		return (Employee)query.getSingleResult();
	}

	@Override
	public Employee findBy(String name, String value) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
		Root<Employee> root = cq.from(Employee.class);
		cq.select(root).where(cb.equal(root.get(name), value));
		Query query = session.createQuery(cq);
		return (Employee)query.getSingleResult();
	}

	@Override
	public List<Object[]> getEmailAndDep() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select e.email,d.depName from Employee e join e.dep d where d.depName like 'Sale%'");
		return query.getResultList();
	}
	
	@Override
	public List<Employee> getDepartment() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee e join fetch e.dep");
		return query.getResultList();
	}

	@Override
	public List<EmployeeDtl> getEmployeeDtls() {
		Session session = sessionFactory.getCurrentSession();
		org.hibernate.query.Query query = session.createQuery("select e.id, e.email, d.depName from Employee e, Department d where e.dep = d.id");
		query.setResultTransformer(new MyTransformer());
		return query.list();
	}
	
	@Override
	public Employee load(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.load(Employee.class, id);
	}
}
