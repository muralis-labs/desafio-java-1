package br.com.muralis.gerador.sequencial.outbound.dynamodb.repository.customrepository;

public interface CustomDynamoRepository {

	Long nextVal(String sequenceName);

}
