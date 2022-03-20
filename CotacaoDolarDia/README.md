# cotacao_dolar_api_quarkus
Cotação do Dólar - Cotação do Dólar da Data Informada e da Data com Dia Útil Anterior a Data Informada.

Ao realizar o download e a execução da aplicação, acessar a URI http://localhost:8081/q/swagger-ui para realizar teste da API pelo Swagger UI ou utilizar o Postman utilizando a URI http://localhost:8081/CotacaoDolarDia?dataCotacao='03-18-2022'.


Conteúdo do arquivo: Openapi_API_Cotacao_Dolar

---
openapi: 3.0.3
info:
  title: cotacao-dolar-data-informada API
  version: 1.0.0-SNAPSHOT
tags:
- name: Cotação do Dólar
  description: Cotação do Dólar da Data Informada e da Data com Dia Útil Anterior
    a Data Informada.
paths:
  /CotacaoDolarDia:
    get:
      tags:
      - Cotação do Dólar
      summary: Cotação do Dólar em uma determinada data e a cotação em dólar do dia
        útil anterior a data informada.
      description: Retorna a cotação do dólar da data informada e da data do dia útil
        anteriro a data informada.
      parameters:
      - name: dataCotacao
        in: query
        required: true
        schema:
          type: string
          nullable: false
      responses:
        "406":
          description: Not Acceptable - Dia não útil
        "200":
          description: Objeto de retorno
          content:
            application/json:
              schema:
                $ref: '#/components/schemas/CotacaoAtualDiaUtil'
components:
  schemas:
    CotacaoAtualDiaUtil:
      type: object
      properties:
        cotacaoCompra:
          format: double
          type: number
        cotacaoVenda:
          format: double
          type: number
        dataHoraCotacao:
          type: string
        cotacaoCompraDiaUtilAnterior:
          format: double
          type: number
        cotacaoVendaDiaUtilAnterior:
          format: double
          type: number
        dataHoraCotacaoDiaUtilAnterior:
          type: string
