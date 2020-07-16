package com.aforo255.account.services;

import java.util.Collection;
import java.util.concurrent.CompletionStage;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.aforo255.account.domain.Currency;


@Path("ticker")
@RegisterRestClient(configKey = "config.api.crypto")
public interface CurrencyService {
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage< Collection<Currency>> getCurrency (@QueryParam("id") String id);
}
