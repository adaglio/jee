package com.wps.msk.core.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.wps.msk.core.entities.AddressNTT;
import com.wps.msk.core.entities.ConnectionNTT;
import com.wps.msk.core.entities.EntityTypeEnum;

@Path("/addresses")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class AddressService {

	@EJB
	CrudComplexService crudService;
	
	
	
	@PUT
	@Path("")
	public AddressNTT createAddress(@PathParam("personId") Long aPersonId, AddressNTT anAddress) {
		AddressNTT createdAddress = crudService.create(anAddress);

		ConnectionNTT aConnection = new ConnectionNTT();
		aConnection.setSourceId(aPersonId);
		aConnection.setSourceType(EntityTypeEnum.PERSON);

		aConnection.setDestinationType(EntityTypeEnum.ADDRESS);
		aConnection.setDestinationId(createdAddress.getId());
		
		ConnectionNTT createdConnection = crudService.create(aConnection);

		return createdAddress;
	}

	@GET
	@Path("/{addressId}")
	public AddressNTT getAddress(@PathParam("addressId") Long anAddressId) {
		return crudService.findByPk(anAddressId, AddressNTT.class);
	}

	
}
