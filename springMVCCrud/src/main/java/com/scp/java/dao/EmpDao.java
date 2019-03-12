package com.scp.java.dao;

import java.util.List;


import com.scp.java.entity.EmpEntity;

public interface EmpDao {
	
	public boolean saveEmp(EmpEntity emp);
	public boolean removeEmp(int eid);
	public EmpEntity fetchEmployee(int eid);
	public EmpEntity modifyEmp(EmpEntity emp);
	public List<EmpEntity> fetchAllEmployee();

}
