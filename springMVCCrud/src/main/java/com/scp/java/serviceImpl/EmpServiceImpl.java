package com.scp.java.serviceImpl;

import java.util.ArrayList;
import com.scp.java.*;
import java.util.List;

import com.scp.java.bean.EmpBean;
import com.scp.java.dao.EmpDao;
import com.scp.java.entity.EmpEntity;
import com.scp.java.service.EmpService;

public class EmpServiceImpl implements EmpService {

	public boolean addEmp(EmpBean emp) {
		//return EmpDao.sa
		//return empDao.insertNewEmp(convertBeanToEntity(bean));
		return false;
		
	}

	public boolean deleteEmp(int eid) {
		return false;
	}

	public EmpBean getEmployee(int eid) {
		return null;
	}

	public EmpBean updateEmp(EmpBean emp) {
		return null;
	}

	public List<EmpBean> getAllEmployee() {
		return null;
	}
	
	public EmpEntity convertEmpBeanToEmpEntity(EmpBean b){
		EmpEntity entity = new EmpEntity();
		entity.seteId(b.getEmpId());
		entity.seteName(b.getEmpName());
		entity.seteAddress(b.getEmpAddress());
		entity.setSal(b.getSalary());
		
		return entity;
		
	}

	public EmpBean convertEmpEntityToEmpBean(EmpEntity e){
		EmpBean bean = new EmpBean();
		bean.setEmpId(e.geteId());
		bean.setEmpName(e.geteName());
		bean.setEmpAddress(e.geteAddress());
		bean.setSalary(e.getSal());
		
		return bean;
		
	}
	
	public List<EmpBean> convertEmpEntitiesToEmpBeans(List <EmpEntity> entities){
		List <EmpBean> beans = new ArrayList(); 
		for (EmpEntity entity : entities) {
			EmpBean bean = new EmpBean();
			bean.setEmpId(entity.geteId());
			bean.setEmpName(entity.geteName());
			bean.setEmpAddress(entity.geteAddress());
			bean.setSalary(entity.getSal());
			beans.add(bean);
			
		}
		
		return beans;
	}
}



