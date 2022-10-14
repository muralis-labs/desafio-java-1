package br.com.muralis.gerador.sequencial.core.service.impl;

import br.com.muralis.gerador.sequencial.core.exception.DomainException;
import br.com.muralis.gerador.sequencial.core.service.ControleSequencialSalvoService;
import br.com.muralis.gerador.sequencial.core.service.ControleSequencialService;
import com.google.common.base.Strings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record ControleSequencialServiceImpl(
		ControleSequencialSalvoService controleSequencialSalvoService) implements ControleSequencialService {

	@Override
	public Long gerarSequencial(String nome) {
		return this.gerarSequencial(nome, 0, 0);
	}

	@Override
	public Long gerarSequencial(String nome, Integer tamanho, Integer inicio) {
		Long proximoNumero = controleSequencialSalvoService.carregarProximoSequencial(nome);
		log.info("Proximo numero para o sequencial {}: {}", nome, proximoNumero);
		if (inicio == null || Integer.valueOf(0).equals(inicio))
			return proximoNumero;

		String prefixo = String.valueOf(inicio);
		String sequencial = String.valueOf(proximoNumero);
		sequencial = Strings.padEnd(prefixo, tamanho - sequencial.length(), '0') + sequencial;
		return Long.valueOf(sequencial);
	}

	@Override
	public Long obterSequencial(String nome) {
		validarSequenceRecebida(nome);
		log.info("Iniciando obtenção de sequencial com nome: {}", nome);
		return controleSequencialSalvoService.carregarProximoSequencial(nome);
	}

	private void validarSequenceRecebida(String sequence) throws DomainException {
		if (sequence.length() == 0)
			throw DomainException.GSQ_FORMATO_NAO_ACEITO();
	}
}
