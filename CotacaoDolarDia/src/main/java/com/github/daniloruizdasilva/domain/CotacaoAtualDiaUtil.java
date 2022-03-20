package com.github.daniloruizdasilva.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe CotacaoAtualDiaUtil com atributos de retorno da API Cotacao Atual do
 * Dia da data informada e Cotação do Primeiro Dia Útil Anterior a data informada
 * 
 * @author Danilo Ruiz
 * @version 1.0
 */
public class CotacaoAtualDiaUtil {

	double cotacaoCompra;
	double cotacaoVenda;
	String dataHoraCotacao;

	double cotacaoCompraDiaUtilAnterior;
	double cotacaoVendaDiaUtilAnterior;
	String dataHoraCotacaoDiaUtilAnterior;

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

	@JsonProperty("cotacaoCompraDiaUtilAnterior")
	public double getCotacaoCompraDiaUtilAnterior() {
		return this.cotacaoCompraDiaUtilAnterior;
	}

	public void setCotacaoCompraDiaUtilAnterior(double cotacaoCompraDiaUtilAnterior) {
		this.cotacaoCompraDiaUtilAnterior = cotacaoCompraDiaUtilAnterior;
	}

	@JsonProperty("cotacaoVendaDiaUtilAnterior")
	public double getCotacaoVendaDiaUtilAnterior() {
		return this.cotacaoVendaDiaUtilAnterior;
	}

	public void setCotacaoVendaDiaUtilAnterior(double cotacaoVendaDiaUtilAnterior) {
		this.cotacaoVendaDiaUtilAnterior = cotacaoVendaDiaUtilAnterior;
	}

	@JsonProperty("dataHoraCotacaoDiaUtilAnterior")
	public String getDataHoraCotacaoDiaUtilAnterior() {
		return this.dataHoraCotacaoDiaUtilAnterior;
	}

	public void setDataHoraCotacaoDiaUtilAnterior(String dataHoraCotacaoDiaUtilAnterior) {
		this.dataHoraCotacaoDiaUtilAnterior = dataHoraCotacaoDiaUtilAnterior;
	}
	
	@Override
	public String toString() {
		return "CotacaoAtualDiaUtil [cotacaoCompra=" + cotacaoCompra + ", cotacaoVenda=" + cotacaoVenda
				+ ", dataHoraCotacao=" + dataHoraCotacao + ", cotacaoCompraDiaUtilAnterior="
				+ cotacaoCompraDiaUtilAnterior + ", cotacaoVendaDiaUtilAnterior=" + cotacaoVendaDiaUtilAnterior
				+ ", dataHoraCotacaoDiaUtilAnterior=" + dataHoraCotacaoDiaUtilAnterior + "]";
	}

}