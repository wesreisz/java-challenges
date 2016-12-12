package com.wesleyreisz.challenges.simpleservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wesleyreisz on 12/9/16.
 */
@Path("api/example")
public class Example {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "Hello, world!";
    }

    //parameters
    @GET
    @Path("param-example")
    @Produces(MediaType.TEXT_PLAIN)
    public String paramMethod(@QueryParam("name") String name) {
        return "Hello, " + name;
    }

    //path parameters
    @GET
    @Path("path/{var}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pathMethod(@PathParam("var") String name) {
        return "Hello, " + name;
    }

    //post
    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postMethod(@FormParam("name") String name) {
        return "<h2>Hello, " + name + "</h2>";
    }
}
