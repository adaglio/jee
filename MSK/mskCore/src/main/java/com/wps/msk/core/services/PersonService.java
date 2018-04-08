package com.wps.msk.core.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.wps.msk.core.entities.BaseNTT;
import com.wps.msk.core.entities.ConnectionNTT;
import com.wps.msk.core.entities.PersonNTT;

/*
 * jeder Fachobjekt service soll ein Rest api haben um der root knoten anzulegen. Der Baum ist dann mit die unterschiedliche
 * Fachobjekte per allgemeine methode zu bestimmen
 * 
 * */

@Path("/persons")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class PersonService  {

	@EJB
	CrudComplexService crudService;

	@PUT
	public PersonNTT createRoot(BaseNTT aPerson) {
		PersonNTT createdPerson = crudService.create((PersonNTT) aPerson);
		return createdPerson;
	}

	
	@POST
	@Path("/{personId}/node")
	public PersonNTT createNode(@PathParam("personId") Long aPersonId, PersonNTT anObject, ConnectionNTT aConnection) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	@GET
	@Path("/{personId}")
	public PersonNTT getPerson(@PathParam("personId") Long aPersonId) {
		return crudService.findByPk(aPersonId, PersonNTT.class);
	}



}
