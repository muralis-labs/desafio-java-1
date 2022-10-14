package br.com.muralis.gerador.sequencial.inbound.facade;

import br.com.muralis.gerador.sequencial.inbound.facade.dto.Sequencial;
import br.com.muralis.gerador.sequencial.core.service.ControleSequencialService;
import org.springframework.stereotype.Service;

@Service
public final class SequencialFacade {

	private final ControleSequencialService controleSequencialService;

	public SequencialFacade(ControleSequencialService controleSequencialService) {
		this.controleSequencialService = controleSequencialService;
	}

	public Sequencial obterSequencial(String nomeSequence) {
		return new Sequencial(nomeSequence, controleSequencialService.obterSequencial(nomeSequence));
	}

}
