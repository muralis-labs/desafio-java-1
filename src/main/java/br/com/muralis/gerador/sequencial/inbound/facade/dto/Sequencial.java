package br.com.muralis.gerador.sequencial.inbound.facade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(description = "Objeto contendo os detalhes do sequencial solicitado de forma sucinta, ou seja apenas o proximo valor.")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sequencial {

	/**
	 * Indica o nome da sequência correspondente a solicitação realizada.
	 */
	private String codigoSequencial;

	/**
	 * Indica o sequêncial retornado correspondente a solicitação/requisição realizada.
	 */
	private Long numeroSequencial;

}
