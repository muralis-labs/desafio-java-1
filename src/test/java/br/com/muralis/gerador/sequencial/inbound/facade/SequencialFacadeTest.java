package br.com.muralis.gerador.sequencial.inbound.facade;

import br.com.muralis.gerador.sequencial.inbound.facade.dto.Sequencial;
import br.com.muralis.gerador.sequencial.core.service.ControleSequencialService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class SequencialFacadeTest {

	private SequencialFacade sequencialFacade;

	@Mock
	ControleSequencialService controleSequencialService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		sequencialFacade = new SequencialFacade(controleSequencialService);
	}

	@Test
	void obterSequencia() {
		Sequencial seq = new Sequencial("teste", 0L);
		when(controleSequencialService.obterSequencial("teste")).thenReturn(0L);
		Assertions.assertEquals(seq, sequencialFacade.obterSequencial("teste"));
	}

}
