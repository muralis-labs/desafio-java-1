package br.com.muralis.gerador.sequencial.core.service.impl;

import br.com.muralis.gerador.sequencial.core.exception.DomainException;
import br.com.muralis.gerador.sequencial.core.service.ControleSequencialSalvoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ControleSequencialServiceImplTest {

	ControleSequencialServiceImpl controleSequencialService;

	@Mock
	ControleSequencialSalvoService controleSequencialSalvoService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		controleSequencialService = new ControleSequencialServiceImpl(controleSequencialSalvoService);
	}

	@Test
	void criaSequencialSemPrefixo() {
		when(controleSequencialSalvoService.carregarProximoSequencial("teste")).thenReturn(11L);
		assertEquals(11L, controleSequencialService.gerarSequencial("teste", 0, 0));
	}

	@Test
	void criaSequencialSemParametros() {
		when(controleSequencialSalvoService.carregarProximoSequencial("teste")).thenReturn(11L);
		assertEquals(11L, controleSequencialService.gerarSequencial("teste"));
	}

	@Test
	void criaSequencialComPrefixoTamanhoExato() {
		when(controleSequencialSalvoService.carregarProximoSequencial("teste")).thenReturn(11L);
		assertEquals(111L, controleSequencialService.gerarSequencial("teste", 3, 1));
	}

	@Test
	void criaSequencialComPrefixoTamanhoDiferente() {
		when(controleSequencialSalvoService.carregarProximoSequencial("teste")).thenReturn(11L);
		assertEquals(100000000000011L, controleSequencialService.gerarSequencial("teste", 15, 1));
	}

	@Test
	void obterSequencial() {
		when(controleSequencialSalvoService.carregarProximoSequencial(any(String.class))).thenReturn(1L);
		assertEquals(1L, controleSequencialService.obterSequencial("Algum"));
	}

	@Test
	void sequenciaInvalida() {
		DomainException e = assertThrows(DomainException.class, () -> controleSequencialService.obterSequencial(""));
		assertEquals(DomainException.GSQ_FORMATO_NAO_ACEITO().getMessage(), e.getMessage());
	}

}
