package com.github.daniloruizdasilva.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe Value com atributos de retorno da API do BCB
 * 
 * @author Danilo Ruiz
 * @version 1.0
 */
public class Value {

	double cotacaoCompra;
	double cotacaoVenda;
	String dataHoraCotacao;
	
	@JsonProperty("cotacaoCompra")
	public double getCotacaoCompra() {
		return this.cotacaoCompra;
	}

	public void setCotacaoCompra(double cotacaoCompra) {
		this.cotacaoCompra = cotacaoCompra;
	}


	@JsonProperty("cotacaoVenda")
	public double getCotacaoVenda() {
		return this.cotacaoVenda;
	}

	public void setCotacaoVenda(double cotacaoVenda) {
		this.cotacaoVenda = cotacaoVenda;
	}


	@JsonProperty("dataHoraCotacao")
	public String getDataHoraCotacao() {
		return this.dataHoraCotacao;
	}

	public void setDataHoraCotacao(String dataHoraCotacao) {
		this.dataHoraCotacao = dataHoraCotacao;
	}

}