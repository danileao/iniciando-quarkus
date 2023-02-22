package br.com.danieleleaoe;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.jboss.resteasy.reactive.RestQuery;

@Path("/users")
public class UserResource {

  @Inject
  private UserService userService;

  @GET()
  public Set<User> getUsers() {
    return this.userService.getUsers();
  }

  @GET
  @Path("/findByName")
  public Optional<User> getUserByName(@RestQuery String name) {
    return this.userService.getUserByName(name);
  }

  @GET
  @Path("/findByParams/{name}")
  public Optional<User> findByParams(String name) {
    System.out.println("Nome " + name);
    return this.userService.getUserByName(name);
  }

}
