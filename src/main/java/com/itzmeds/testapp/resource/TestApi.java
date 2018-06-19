package com.itzmeds.testapp.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.itzmeds.mac.core.service.AbstractResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "Test Api Endpoints")
@Path("/test")
public class TestApi extends AbstractResource {

	@ApiOperation(value = "Say Hello")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "success") })
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@ApiParam(value = "Some Text", required = true) @PathParam("param") String msg) {

		String output = "{\"message\":\"" + msg + "\"}";

		return Response.ok(output).build();
	}

}