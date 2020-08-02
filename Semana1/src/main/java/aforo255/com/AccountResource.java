package aforo255.com;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/account")
public class AccountResource {

	public static final String ACCESS = "dev";
	
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String helloParam(@PathParam("id") String id) {
        return "hello "+id;
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addAccunt(String body) {
        return body;
    }
    
    
    @POST
    @Path("/param")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addAccuntParam(@QueryParam("account") String qAccount) {
        return "{\"key\":\"" +qAccount+"\"}";
    }
    
    
    @POST
    @Path("/token")
    // es la salida el retorno (response)
    // @Produces(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_HTML)
    // es lo que se recibe el (request)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addAccountToken(@HeaderParam("token") String htoken ,  @QueryParam("token") String qtoken) {
     
    	 String token =htoken != null ?htoken:qtoken;
    	 if(!ACCESS.equals(token)) {
    		 throw new RuntimeException("Unauthorized");
    	 }
    	
    	//return "{\"key\":\"" +token+"\"}";
    	 return "<b> TEXT </br>";
    }
    
    
    
    
}