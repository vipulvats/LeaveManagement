package com.lms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    public Product(int id, int empId, int sickLeave) {
		this.id=id;
		this.empId=empId;
		this.sickLeave=sickLeave;
	}
    
   	private int id;
   	
   	private int empId;
   	
   	public int getId() {
   		return id;
   	}

   	public void setId(int id) {
   		this.id = id;
   	}

   	public int getEmpId() {
   		return empId;
   	}

   	public void setEmpId(int empId) {
   		this.empId = empId;
   	}

   	public int getAnnualLeave() {
   		return annualLeave;
   	}

   	public void setAnnualLeave(int annualLeave) {
   		this.annualLeave = annualLeave;
   	}

   	public int getSickLeave() {
   		return sickLeave;
   	}

   	public void setSickLeave(int sickLeave) {
   		this.sickLeave = sickLeave;
   	}

   	public int getMaternityLeave() {
   		return maternityLeave;
   	}

   	public void setMaternityLeave(int maternityLeave) {
   		this.maternityLeave = maternityLeave;
   	}

   	public int getPaternityLeave() {
   		return paternityLeave;
   	}

   	public void setPaternityLeave(int paternityLeave) {
   		this.paternityLeave = paternityLeave;
   	}

   	private int annualLeave;
   	
   	private int sickLeave;
   	
   	private int maternityLeave;
   	
   	private int paternityLeave;
    
}
