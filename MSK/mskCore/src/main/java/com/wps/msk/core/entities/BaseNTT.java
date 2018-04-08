package com.wps.msk.core.entities;

import java.io.Serializable;
import java.util.Date;


public abstract class BaseNTT implements Serializable{


	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2529876608381974228L;
	
	private Long id;
	private Date createdAt;
	private Date lastModifiedAt;
	
	@SuppressWarnings("unused")
	private final EntityTypeEnum entityType = getEntityType();

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getLastModifiedAt() {
		return lastModifiedAt;
	}

	public void setLastModifiedAt(Date lastModifiedAt) {
		this.lastModifiedAt = lastModifiedAt;
	}

	public abstract EntityTypeEnum getEntityType();

	
	
}
