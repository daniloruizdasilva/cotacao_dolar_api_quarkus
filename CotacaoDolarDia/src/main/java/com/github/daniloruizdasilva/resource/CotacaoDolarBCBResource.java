package com.github.daniloruizdasilva.resource;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponseSchema;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.github.daniloruizdasilva.business.CotacaoDolarBCBBusiness;
import com.github.daniloruizdasilva.domain.CotacaoAtualDiaUtil;
import com.github.daniloruizdasilva.utils.Utils;

/**
 * Classe CotacaoDolarBCBResource para expor informações da Cotacao Atual do
 * Dia da data informada e Cotação do Primeiro Dia Útil Anterior a data informada
 * @author Danilo Ruiz
 * @version 1.0
 *
 */

@Path("/CotacaoDolarDia")
public class CotacaoDolarBCBResource {

	private static final Logger LOG = Logger.getLogger("CotacaoDolarBCBResource");
    
	@Inject
	CotacaoDolarBCBBusiness cotacaoDolarBCBBusiness;
	
		
    @GET
    @Tag(name = "Cotação do Dólar", description = "Cotação do Dólar da Data Informada e da Data com Dia Útil Anterior a "
    		+ "Data Informada.") 
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Cotação do Dólar em uma determinada data e a cotação em dólar do dia útil anterior a data informada.",
    description = "Retorna a cotação do dólar da data informada e da data do dia útil anteriro a data informada. Ex: '03-18-2022'")
    @Parameter(
            description = "Data da cotação deve ser informada.",
            required = true)
	 @APIResponseSchema(value = CotacaoAtualDiaUtil.class,
     responseDescription = "Objeto de retorno",
     responseCode = "200")
    @APIResponse(responseCode = "406", description = "Not Acceptable - Dia não útil")
    
    
    public Response getCotacaoDolarDataInformada(@NotNull @QueryParam("dataCotacao") String dataCotacao) {
    	
    	LOG.info("Data informada: " + dataCotacao);
    	
    	if(!Utils.isDataValida(dataCotacao))
    	{
    	    LOG.info("Data informada " + dataCotacao + " nao e valida.");
    	    
            //Requisição não aceita - Data invalida.
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    	}
    	
    	if(Utils.isFimDeSemana(dataCotacao))
    	{
    	    LOG.info("Data informada " + dataCotacao + " nao e dia  util.");
    	    
            //Requisição não aceita - Dia não útil.
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
    	}
    	
    	CotacaoAtualDiaUtil cotacaoAtualDiaUtil = cotacaoDolarBCBBusiness.getCotacaoDolarDataInformadaDataUtilAnterior(dataCotacao);
    	LOG.info(cotacaoAtualDiaUtil.toString());
        return Response.ok(cotacaoAtualDiaUtil).build();

    }
    

}