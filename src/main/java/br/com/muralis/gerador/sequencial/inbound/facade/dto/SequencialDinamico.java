package br.com.muralis.gerador.sequencial.inbound.facade.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
@Schema(description = "Objeto contendo os detalhes do sequencial solicitado e que permite ser dinamizado de acordo com o critério do solicitante.")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SequencialDinamico implements Serializable {

	/**
	 * Serviço que a sequence desejada deve ser atribuida.
	 */
	private String servico;

	/**
	 * Sequencial retornado da consulta.
	 */
	private Long sequencial;

	/**
	 * Prefixo é um campo que padroniza o servico. </br>
	 * </br>
	 * Ex: </br>
	 * Serviço A - 900 Serviço B - 800 Serviço C - 700
	 */
	private Integer prefixo;

	/**
	 * Esse é um campo opcional, e serve para dar um tamanho total para a sequence
	 * requisitada.
	 */
	private Integer tamanhoSolicitado;

}
