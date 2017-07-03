package com.rest;

//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by neerbans on 11/3/2016.
 */

@Path("/hello")
@Api( value = "/hello", description = "print hello world")
public class HelloWorldService {

    @ApiOperation(
            value = "method api",
            notes = "method api notes"
//            httpMethod = "GET",
//            response = Response.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success"),
            @ApiResponse(code = 500, message = "error")
    })
    @Produces({MediaType.TEXT_PLAIN})
    @GET
    @Path("/{param}")
    public String getMsg(
            //@ApiParam( value = "api param", required = true)
            @PathParam("param")
            String msg
    ) {

        String output = "Jersey say : " + msg;

        return output;

        //return Response.status(200).entity(output).build();
    }

    // localhost:8080/jax-rs/rest/hello/kb26  //http://localhost:8080/jax-rs //http://localhost:8080/jax-rs/rest/api-docs
}
