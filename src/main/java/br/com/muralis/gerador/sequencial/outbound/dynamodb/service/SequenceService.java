package br.com.muralis.gerador.sequencial.outbound.dynamodb.service;

import br.com.muralis.gerador.sequencial.core.service.ControleSequencialSalvoService;
import br.com.muralis.gerador.sequencial.outbound.dynamodb.entity.Sequence;
import br.com.muralis.gerador.sequencial.outbound.dynamodb.repository.SequenceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public record SequenceService(SequenceRepository sequenceRepository) implements ControleSequencialSalvoService {

	@Override
	public Long carregarProximoSequencial(String nome) {
		// O método nextVal, incrementa o valor atual e o retorna sendo assim equivalente
		// ao sucessor do valor atual.
		log.info("Buscando sequence com nome: {}", nome);
		Sequence sequenciaPesquisada = sequenceRepository.loadBySequenceName(nome);
		return sequenceRepository.nextVal(sequenciaPesquisada.getSequence());
	}

}
