package br.com.muralis.gerador.sequencial.outbound.mockgenerator.service;

import br.com.muralis.gerador.sequencial.core.service.ControleSequencialSalvoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Neste projeto, estamos usando este gerador mock que salva os dados somente em memória.
 *
 * Se você quiser, pode usar a implementação SequenceService que usa o dynamodb, mas aí
 * você vai precisar de um banco do dynamo para rodar o projeto.
 */
@Service
@Primary
public class MockSequenceService implements ControleSequencialSalvoService {

	private Map<String, Long> tabelaMock;

	public MockSequenceService() {
		tabelaMock = new HashMap<>();
	}

	@Override
	public Long carregarProximoSequencial(String nome) {
		if (tabelaMock.containsKey(nome)) {
			// Usar este valor, incrementando 1
			Long sequencialAtual = tabelaMock.get(nome);
			tabelaMock.put(nome, sequencialAtual + 1);
			return sequencialAtual + 1;
		}
		else {
			// Adicionar um sequencial novo, começando em 0.
			tabelaMock.put(nome, 0L);
			return 0L;
		}
	}

}
