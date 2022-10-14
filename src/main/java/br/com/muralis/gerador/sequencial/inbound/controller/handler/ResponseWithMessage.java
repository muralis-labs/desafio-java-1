package br.com.muralis.gerador.sequencial.inbound.controller.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseWithMessage {

	/**
	 * Mensagem que serve para dar uma resposta para o usuário conforme a solicitação
	 * recebida.
	 */
	String message;

}
