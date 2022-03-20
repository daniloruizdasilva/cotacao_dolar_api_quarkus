package com.github.daniloruizdasilva;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CotacaoDolarBCBResourceTest {

	/**
	 * Teste de Consulta de Data Válida
	 * Data Cotação: '03-18-2022'
	 */
	 @Test public void testDataCotacaoInformadaValida() { given().queryParam("dataCotacao","'03-18-2022'")
      .when().get("/CotacaoDolarDia")
	  .then() .statusCode(200).body(is("{\"cotacaoCompra\":5.0405,\"cotacaoCompraDiaUtilAnterior\":5.0758,\"cotacaoVenda\":5.0411,\"cotacaoVendaDiaUtilAnterior\":5.0764,\"dataHoraCotacao\":\"2022-03-18 13:06:29.828\",\"dataHoraCotacaoDiaUtilAnterior\":\"2022-03-17 16:48:38.165\"}"));
	 }
	 
	 /**
	  * Teste de Consulta de Data Inválida - Formato inválido
	 * Data Cotação: '03/20/2022'
	  */
	 @Test public void testDataCotacaoInformadaFormatoInvalido() { given().queryParam("dataCotacao","'03/20/2022'")
	      .when().get("/CotacaoDolarDia")
		  .then() .statusCode(406);
		 }
	 
	 
	 /**
	  * Teste de Consulta de Data Inválida - Data de Fim de Semana
	 * Data Cotação: '03-20-2022'
	  */
	 @Test public void testDataCotacaoInformadaFimDeSemana() { given().queryParam("dataCotacao","'03-20-2022'")
	      .when().get("/CotacaoDolarDia")
		  .then() .statusCode(406);
		 }
	 
}