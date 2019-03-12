package com.scp.java.daoImpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.scp.java.dao.EmpDao;
import com.scp.java.entity.EmpEntity;

public class EmpDaoImpl implements EmpDao {
	
	public SessionFactory sessionFactory;

	public boolean saveEmp(EmpEntity emp) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(emp);
		tr.commit();
		session.close();
		return true;
	}

	public boolean removeEmp(int eid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
	     if(fetchEmployee(eid)!=null){
		session.delete(eid);
		tr.commit();
		session.close();
		return true;
	     }
	     else{
	    	 System.out.println("Emp id not found");
	    	 return false;
	     }
				
		
	}

	public EmpEntity fetchEmployee(int eid) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		EmpEntity e = (EmpEntity) session.load(EmpEntity.class, eid);
		tr.commit();
		session.close();
		return e;
	}

	public EmpEntity modifyEmp(EmpEntity emp) {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		EmpEntity e1 = (EmpEntity) session.load(EmpEntity.class, emp.geteId());
	  e1.seteName("sheetal");
	  session.update(e1);
	  tr.commit();
	  session.close();
	  return e1;
		

	   
	}

	public List<EmpEntity> fetchAllEmployee() {
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		List<EmpEntity> empList = session.createQuery("from EmpEntity").list();
		for(EmpEntity ee : empList){
			System.out.println("Person List::"+ee);
		}
		return empList;
	}

}
