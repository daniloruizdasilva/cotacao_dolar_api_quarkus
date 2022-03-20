package com.github.daniloruizdasilva.business;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.github.daniloruizdasilva.domain.CotacaoAtualDiaUtil;
import com.github.daniloruizdasilva.dto.Root;
import com.github.daniloruizdasilva.service.CotacaoDolarBCBService;
import com.github.daniloruizdasilva.utils.Utils;

@RequestScoped
public class CotacaoDolarBCBBusiness {


	@Inject
	@RestClient
	CotacaoDolarBCBService cotacaoDolarBCBService;
	
	public CotacaoAtualDiaUtil getCotacaoDolarDataInformadaDataUtilAnterior(String dataCotacao) {

		try	{
	    	Root root = cotacaoDolarBCBService.findCotacaoPorData(dataCotacao);
	    	
	    	CotacaoAtualDiaUtil cotacaoAtualDiaUtil = new CotacaoAtualDiaUtil();
	    	
	    	cotacaoAtualDiaUtil.setCotacaoCompra(root.getValue().get(0).getCotacaoCompra());
	    	cotacaoAtualDiaUtil.setCotacaoVenda(root.getValue().get(0).getCotacaoVenda());
	    	cotacaoAtualDiaUtil.setDataHoraCotacao(root.getValue().get(0).getDataHoraCotacao());
	    	
	    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
	    	String dataUtilAnterior = Utils.getUtilAnterior(dataCotacao.replace("'","")).format(formatter);
	    	dataUtilAnterior = "'" + dataUtilAnterior + "'";
	    	
	    	root = cotacaoDolarBCBService.findCotacaoPorData(dataUtilAnterior);
	    	
	    	cotacaoAtualDiaUtil.setCotacaoCompraDiaUtilAnterior(root.getValue().get(0).getCotacaoCompra());
	    	cotacaoAtualDiaUtil.setCotacaoVendaDiaUtilAnterior(root.getValue().get(0).getCotacaoVenda());
	    	cotacaoAtualDiaUtil.setDataHoraCotacaoDiaUtilAnterior(root.getValue().get(0).getDataHoraCotacao());
	    	
	    	return cotacaoAtualDiaUtil;
		} catch (DateTimeParseException dtpe) {
			return new CotacaoAtualDiaUtil();
		}

	}
}
