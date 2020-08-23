package aforo255.jpa;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.event.Observes;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import aforo255.jpa.entity.Users;
import io.quarkus.runtime.StartupEvent;
import javax.ws.rs.core.SecurityContext;

@Path("/security")
public class SecurityResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @Transactional
    public void onStart(@Observes StartupEvent event) {
        Users.add("admin", "admin", "Admin,User");
        Users.add("user", "user", "User");
    }

    @GET
    @Path("/info")
    @RolesAllowed("User")
    public String getInfo(@Context SecurityContext context) {
        return "Hello " + context.getUserPrincipal().getName();
    }

    @GET
    @Path("/admin")
    @RolesAllowed("Admin")
    public String admin(@Context SecurityContext context) {
        return "admin secret";
    }
}