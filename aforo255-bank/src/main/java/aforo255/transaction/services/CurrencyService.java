package aforo255.transaction.services;

import java.util.Collection;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import aforo255.transaction.domain.Currency;


@Path("ticker")
@RegisterRestClient(configKey = "config.api.crypto")
public interface CurrencyService {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage< Collection<Currency>> getCurrency (@QueryParam("id") String id);
}
