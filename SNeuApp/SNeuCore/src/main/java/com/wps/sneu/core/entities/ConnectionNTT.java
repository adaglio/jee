package com.wps.sneu.core.entities;

import com.wps.sneu.core.entities.connectionTypes.ConnectionTypeEnum;

public class ConnectionNTT extends BaseNTT{

	/**
	 * 
	 */
	private static final long serialVersionUID = 571173786266856729L;

	
	private Long sourceId;
	private EntityTypeEnum sourceType;
	
	private Long destinationId;
	private EntityTypeEnum destinationType;
	
	private ConnectionTypeEnum connectionType;
	private Boolean isConfirmed;
	
	
	
	@Override
	public EntityTypeEnum getEntityType() {
		return EntityTypeEnum.CONNECTION;
	}



	public Long getSourceId() {
		return sourceId;
	}



	public void setSourceId(Long sourceId) {
		this.sourceId = sourceId;
	}



	public EntityTypeEnum getSourceType() {
		return sourceType;
	}



	public void setSourceType(EntityTypeEnum sourceType) {
		this.sourceType = sourceType;
	}



	public Long getDestinationId() {
		return destinationId;
	}



	public void setDestinationId(Long destinationId) {
		this.destinationId = destinationId;
	}



	public EntityTypeEnum getDestinationType() {
		return destinationType;
	}



	public void setDestinationType(EntityTypeEnum destinationType) {
		this.destinationType = destinationType;
	}



	public ConnectionTypeEnum getConnectionType() {
		return connectionType;
	}



	public void setConnectionType(ConnectionTypeEnum connectionType) {
		this.connectionType = connectionType;
	}



	public Boolean getIsConfirmed() {
		return isConfirmed;
	}



	public void setIsConfirmed(Boolean isConfirmed) {
		this.isConfirmed = isConfirmed;
	}

}
