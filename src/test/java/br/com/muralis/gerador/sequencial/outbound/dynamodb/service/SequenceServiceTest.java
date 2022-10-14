package br.com.muralis.gerador.sequencial.outbound.dynamodb.service;

import br.com.muralis.gerador.sequencial.outbound.dynamodb.entity.Sequence;
import br.com.muralis.gerador.sequencial.outbound.dynamodb.repository.SequenceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class SequenceServiceTest {

	SequenceService sequenceService;

	@Mock
	SequenceRepository sequenceRepository;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
		sequenceService = new SequenceService(sequenceRepository);
	}

	@Test
	void carregarControleSequencial() {
		Long esperado = 10L;
		when(sequenceRepository.nextVal("teste")).thenReturn(esperado);
		when(sequenceRepository.loadBySequenceName("teste")).thenReturn(new Sequence("teste", 10L));
		assertEquals(esperado, sequenceService.carregarProximoSequencial("teste"));

	}

}
