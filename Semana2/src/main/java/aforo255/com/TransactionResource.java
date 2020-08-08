package aforo255.com;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import aforo255.com.entity.*;
import aforo255.com.service.TransactionService;

@Path("/transaction")
public class TransactionResource {
	private static ArrayList<Transaction> transaction = new ArrayList<>();

	@Inject
	Validator validator;
	@Inject
	TransactionService service;

	static {
		transaction.add(new Transaction(1, "retiro 30 dolares"));
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// public Collection<Transaction> Transaction() {
	public Response Transaction() {

		// return transaction;

		// return Response.ok(transaction).build();
		// return Response.serverError().build();
		return Response.status(202).entity(transaction).build();

	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	// public Transaction addTransaction(Transaction transact) {
	// public Response addTransaction(Transaction transact) {
	// Validacion Hibernate
	// public Response addTransaction(@Valid Transaction transact) {
	// public Response addTransaction(Transaction transact) {
	// final Set<ConstraintViolation<Transaction>> validate =
	// validator.validate(transact);

	// if (validate.size()>0) {
	// return Response.status(400).build();
	// }
	public Response addTransaction(Transaction transact) {
		service.checkTransaction(transact);
		transaction.add(transact);
		// return transact;
		return Response.ok(transact).build();
	}

	@PUT
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Transaction updateTransaction(@PathParam("id") Integer index, Transaction transact) {
		transaction.remove((int) index);
		transaction.add(index, transact);
		return transact;
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Transaction deleteTransaction(@PathParam("id") Integer index) {
		return transaction.remove((int) index);
	}

}
