package br.com.muralis.gerador.sequencial.outbound.dynamodb.repository.customrepository.impl;

import br.com.muralis.gerador.sequencial.outbound.dynamodb.repository.customrepository.CustomDynamoRepository;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public class CustomDynamoRepositoryImpl implements CustomDynamoRepository {

	private static final String VALUE_TO_INCREMENT = "1";

	private static final String TABLE_NAME = "Sequence";

	private final AmazonDynamoDB dynamoDB;

	@Autowired
	public CustomDynamoRepositoryImpl(AmazonDynamoDB dynamoDB) {
		this.dynamoDB = dynamoDB;
	}

	@Override
	public Long nextVal(String sequenceName) {
		log.info("Iniciando consulta na tabela: {} buscando pelo sequencial: {}", TABLE_NAME, sequenceName);
		Map<String, AttributeValue> key = new HashMap<>();
		key.put("sequence", new AttributeValue().withS(sequenceName));
		UpdateItemRequest updateRequest = new UpdateItemRequest().withTableName(TABLE_NAME).withKey(key)
				.addAttributeUpdatesEntry("nexVal", new AttributeValueUpdate()
						.withValue(new AttributeValue().withN(VALUE_TO_INCREMENT)).withAction(AttributeAction.ADD))
				.withReturnValues("UPDATED_NEW");
		UpdateItemResult updateItem = dynamoDB.updateItem(updateRequest);
		String valor = updateItem.getAttributes().get("nexVal").getN();
		log.info("Valor do sequencial: {}", valor);
		return Long.parseLong(valor);
	}

}
