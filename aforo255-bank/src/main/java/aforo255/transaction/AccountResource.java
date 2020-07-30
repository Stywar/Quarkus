package aforo255.transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import aforo255.transaction.domain.Account;
import aforo255.transaction.services.IAccountService;

@Path("/account")
public class AccountResource {

	@Inject
	IAccountService accountService;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@RolesAllowed({"Admin"})
	@Path("/listar")
	public List<Account> listar() {

		return accountService.findAllAccount();
	}

	@GET
	@Path("/ver/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Account detalle(@PathParam("id") Integer id) {

		Account account = accountService.findAccountById(id);
		return account;
	}
}