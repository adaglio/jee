package com.wps.sneu.core.services;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.wps.sneu.core.entities.PersonNTT;

@Path("/persons/")
@Stateless
@Produces("application/json")
@Consumes("application/json")
public class PersonService {

	@EJB
	CrudComplexService crudService;

	@PUT
	public PersonNTT createPerson(PersonNTT aPerson) {
		PersonNTT createdPerson = crudService.create(aPerson);
		return createdPerson;
	}

	@GET
	@Path("{personId}/")
	public PersonNTT getPerson(@PathParam("personId") Long aPersonId) {
		return crudService.findByPk(aPersonId, PersonNTT.class);
	}

}
