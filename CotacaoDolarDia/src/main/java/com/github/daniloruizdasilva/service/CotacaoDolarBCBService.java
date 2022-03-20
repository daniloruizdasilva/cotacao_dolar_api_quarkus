package com.github.daniloruizdasilva.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.github.daniloruizdasilva.dto.Root;

/**
 * Interface para consumo da API do BCB
 * 
 * @author Danilo Ruiz
 * @version 1.0
 */
@Path("/CotacaoDolarDia(dataCotacao=@dataCotacao)")
@RegisterRestClient
public interface CotacaoDolarBCBService {

	/**
	 * @author Danilo Ruiz
	 * @version 1.0
	 * @param dataCotacao Data de cotacao informada
	 * @return Cotacoes da data informada
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	// @Path("findByStatus")
	public Root findCotacaoPorData(@QueryParam("@dataCotacao") String dataCotacao);
}
