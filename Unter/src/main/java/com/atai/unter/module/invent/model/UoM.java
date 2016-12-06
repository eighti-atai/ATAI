package com.atai.unter.module.invent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="uom_tab")
public class UoM {
	@Id
	@Column(name="uom_id")
	private String uoMId;
	private String description;
	private String objid;
	
	public String getUoMId() {
		return uoMId;
	}
	public void setUoMId(String uomId) {
		this.uoMId = uomId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getObjid() {
		return objid;
	}
	public void setObjid(String objid) {
		this.objid = objid;
	}
}
