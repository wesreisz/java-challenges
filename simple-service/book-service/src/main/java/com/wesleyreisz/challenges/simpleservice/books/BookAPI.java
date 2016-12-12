package com.wesleyreisz.challenges.simpleservice.books;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by wesleyreisz on 12/9/16.
 */
@Path("api/book")
public class BookAPI {

    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld() {
        return "This api is an example for jerset with embedded Jetty";
    }


    //path parameters
    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String pathMethod(@PathParam("id") long id) {
        BookService service = new BookService();
        return service.find(id).toString();
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
