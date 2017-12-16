package com.wps.sneu.core.entities;

import com.wps.sneu.core.entities.connectionTypes.ConnectionTypeEnum;

public abstract class ConnectionableNTT extends BaseNTT {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6970593272593930761L;
	
	
	private ConnectionTypeEnum connectionType;

	public ConnectionTypeEnum getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionTypeEnum connectionType) {
		this.connectionType = connectionType;
	}

}
