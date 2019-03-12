package com.scp.java.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="EmpEntity")
public class EmpEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	 private int eId;
	 private String eName;
	 private String eAddress;
	 private double sal;
	public int geteId() {
		return eId;
	}
	public void seteId(int eId) {
		this.eId = eId;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	public String geteAddress() {
		return eAddress;
	}
	public void seteAddress(String eAddress) {
		this.eAddress = eAddress;
	}
	public double getSal() {
		return sal;
	}
	public void setSal(double sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "EmpEntity [eId=" + eId + ", eName=" + eName + ", eAddress=" + eAddress + ", sal=" + sal + "]";
	}

}
