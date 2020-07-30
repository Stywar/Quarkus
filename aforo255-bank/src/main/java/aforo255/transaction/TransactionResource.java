package aforo255.transaction;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import aforo255.transaction.document.DocumentTransaction;
import aforo255.transaction.domain.Account;
import aforo255.transaction.domain.Transaction;
import aforo255.transaction.services.IAccountService;
import aforo255.transaction.services.ITransactionService;
@Path("/transaction")
public class TransactionResource {
	@Inject
	ITransactionService service;
	@Inject
	IAccountService account;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Transactional
	public Response saveTransaction(Transaction transaction) {
		Transaction trx = null;
		Map<String, Object> response = new HashMap<>();
		try {

			trx = service.save(transaction);
			if (trx != null) {
				if (trx.getId() > 0) {

					System.out.println("Transaction =>" + trx.getId());
					double newmonto = 0;
					Account objAccount = new Account();
					objAccount = account.findAccountById(trx.getAccountId());

					if (objAccount == null) {
						response.put("mensaje", "El AccountId :"
								.concat(trx.getAccountId().toString().concat(" no existe en la base de datos  ")));
						return Response.status(Status.NOT_FOUND).entity(response).build();
					}

					switch (trx.getType()) {
					case "deposito":
						newmonto = objAccount.getTotalAmount() + trx.getAmount();
						break;

					case "retiro":
						newmonto = objAccount.getTotalAmount() - trx.getAmount();
						break;

					}

					objAccount.setTotalAmount(newmonto);
					account.mergeAccount(objAccount);
					
					DocumentTransaction document = setDocument(trx);
					service.saveDocument(document);

				}
			}

		} catch (Exception ex) {

			response.put("mensaje", "Error al  insertar en la base de datos");
			response.put("error", ex.getMessage().concat(": ").concat(ex.getLocalizedMessage()));
			return Response.status(Status.INTERNAL_SERVER_ERROR).entity(response).build();
		}
		
		response.put("mensaje", "Transaccion realizada con exito!");
		response.put("transaction", trx);
		return Response.status(Status.CREATED).entity(response).build();
		//return Response.status(Status.CREATED).entity(trx).build();
		// return trx;
	}

	private DocumentTransaction setDocument(Transaction trx) {
		DocumentTransaction document = new DocumentTransaction();
		document.setId(trx.getId().toString());
		document.setAccountId(trx.getAccountId());
		document.setAmount(trx.getAmount());
		document.setCreationDate(trx.getCreationDate());
		document.setType(trx.getType());
		return document;

	}

}
