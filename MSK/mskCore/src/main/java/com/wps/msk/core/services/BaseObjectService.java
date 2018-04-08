package com.wps.msk.core.services;

import com.wps.msk.core.entities.BaseNTT;
import com.wps.msk.core.entities.ConnectionNTT;

public interface BaseObjectService {

	
	public BaseNTT createRoot(BaseNTT anObject);
	
	public BaseNTT createNode(Long id, BaseNTT anObject, ConnectionNTT aConnection);
	
	
}
