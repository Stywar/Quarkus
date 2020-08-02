package aforo255.com;

import java.util.ArrayList;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.netty.util.internal.StringUtil;

@Path("/transaction")
public class TransactionResource {
	private static ArrayList<String> transaction = new ArrayList<>();

	static {
		transaction.add("retiro 30 dolares");
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String Transaction() {
		return StringUtil.join(",", transaction).toString();
	}

	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addTransaction(String transact) {
		transaction.add(transact);
		return transact;
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateTransaction(@PathParam("id") Integer index, String transact) {
		transaction.remove((int) index);
		transaction.add(index, transact);
		return transact;
	}
	
	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteTransaction(@PathParam("id") Integer index) {
		return	transaction.remove((int) index);				
	}

}
