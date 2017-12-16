package com.wps.demo.services.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;


@Path("/messages")
public class MessageService {

	
	
	@GET
	public String getMessage() {
		return "Hello docker! Aldo!";
	}
}
