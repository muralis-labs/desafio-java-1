package br.com.muralis.gerador.sequencial.inbound.controller.handler;

import br.com.muralis.gerador.sequencial.core.exception.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

	@ExceptionHandler(DomainException.class)
	protected ResponseEntity<ResponseWithMessage> handleDomainException(DomainException exception) {
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE)
				.body(ResponseWithMessage.builder().message(exception.getMessage()).build());
	}

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<ResponseWithMessage> handleUnespectedException(Exception e) {
		log.error("Erro ao rodar aplicação: {}", e);
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
				.body(ResponseWithMessage.builder().message(
						"Erro inesperado ao processar sua solicitaçao, por favor, analise os parametros enviados.")
						.build());
	}

}
