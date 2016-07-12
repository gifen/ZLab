package com.nefig.lab.jettyjersey.tutorial;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("home")
public class Resource {
  @GET
  @Path("hello")
  @Produces(MediaType.TEXT_PLAIN)
  public String helloWorld() {
    return "Hello, world!";
  }
  
  @GET
  @Path("param")
  @Produces(MediaType.TEXT_PLAIN)
  public String paramMethod(@QueryParam("name") String name) {
    return "Hello, " + name;
  }
  
  @GET
  @Path("path/{var}")
  @Produces(MediaType.TEXT_PLAIN)
  public String pathMethod(@PathParam("var") String name) {
      return "Hello, " + name;
  }
  
  @POST
  @Path("post")
  @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
  @Produces(MediaType.TEXT_HTML)
  public String postMethod(@FormParam("name") String name) {
    return "<h2>Hello, " + name + "</h2>";
  }
}