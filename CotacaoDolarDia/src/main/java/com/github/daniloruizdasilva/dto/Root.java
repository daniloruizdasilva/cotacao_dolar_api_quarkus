package com.github.daniloruizdasilva.dto;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Classe Root com atributos de retorno da API do BCB
 * 
 * @author Danilo Ruiz
 * @version 1.0
 */
public class Root {
	
	@JsonProperty("@odata.context")
	public String getOdataContext() {
		return this.odataContext;
	}

	public void setOdataContext(String odataContext) {
		this.odataContext = odataContext;
	}

	String odataContext;

	@JsonProperty("value")
	public ArrayList<Value> getValue() {
		return this.value;
	}

	public void setValue(ArrayList<Value> value) {
		this.value = value;
	}

	ArrayList<Value> value;
}
