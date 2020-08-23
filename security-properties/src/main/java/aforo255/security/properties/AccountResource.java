package aforo255.security.properties;

import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountResource {

 
    
    @GET
    @RolesAllowed("User")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello user";
    }

    @GET
    @RolesAllowed("Admin")
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/admin")
    public String adminInfo() {
        return "Show more information admin: \n1:...";
    }

    @GET
    @RolesAllowed("Dev")
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/dev")
    public String devInfo() {
        return "How are you de ?: \n1:...";
    }
}