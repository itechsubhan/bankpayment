package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecieverModel {
	@Id
	String BIC;
	String RecInstitutionName;
	public String getBIC() {
		return BIC;
	}
	public void setBIC(String bIC) {
		BIC = bIC;
	}
	public String getRecInstitutionName() {
		return RecInstitutionName;
	}
	public void setRecInstitutionName(String recInstitutionName) {
		RecInstitutionName = recInstitutionName;
	}
	public RecieverModel(String bIC, String recInstitutionName) {
		super();
		BIC = bIC;
		RecInstitutionName = recInstitutionName;
	}
	public RecieverModel() {
		super();
	}
	
	

}
