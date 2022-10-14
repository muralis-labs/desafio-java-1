package br.com.muralis.gerador.sequencial.outbound.dynamodb.repository;

import br.com.muralis.gerador.sequencial.outbound.dynamodb.entity.Sequence;
import br.com.muralis.gerador.sequencial.outbound.dynamodb.repository.customrepository.CustomDynamoRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface SequenceRepository extends CrudRepository<Sequence, String>, CustomDynamoRepository {

	Optional<Sequence> findBySequence(String sequence);

	default Sequence loadBySequenceName(String sequenceName) {
		Optional<Sequence> sequence = findBySequence(sequenceName);
		return sequence.orElseGet(() -> save(new Sequence(sequenceName, 0L)));

	}

}
