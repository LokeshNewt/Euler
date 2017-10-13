package com.carl.friedrich;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by neerbans on 10/11/2017.
 */

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getParamsUsingAnnotations(@MatrixParam("param") String matrixParam,
                                            @HeaderParam("authSessionID") String header,
                                            @CookieParam("name") String cookie) {
        return "Matrix param: " + matrixParam + " Header Param: " + header + " Cookie: " + cookie;
    }
}
