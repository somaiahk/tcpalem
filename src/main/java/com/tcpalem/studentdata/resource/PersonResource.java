package com.tcpalem.studentdata.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.tcpalem.studentdata.service.IPersonService;

/**
 * @since 17/06/2016
 * @author somaiah
 *
 */
@Path("/person")
public class PersonResource {
	
	@Autowired private IPersonService service;
	
	@GET
	public Response getPerson() {
		return Response.ok().entity(service.get()).build();
	}

}
