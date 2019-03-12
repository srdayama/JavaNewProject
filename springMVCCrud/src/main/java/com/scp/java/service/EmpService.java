package com.scp.java.service;

import java.util.List;

import com.scp.java.bean.EmpBean;

public interface EmpService {
	
	public boolean addEmp(EmpBean emp);
	public boolean deleteEmp(int eid);
	public EmpBean getEmployee(int eid);
	public EmpBean updateEmp(EmpBean emp);
	public List<EmpBean> getAllEmployee();

}
