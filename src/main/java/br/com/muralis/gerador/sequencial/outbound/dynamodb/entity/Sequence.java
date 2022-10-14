package br.com.muralis.gerador.sequencial.outbound.dynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@DynamoDBTable(tableName = "Sequence")
public class Sequence {

	@DynamoDBHashKey(attributeName = "sequence")
	private String sequence;

	@DynamoDBAttribute(attributeName = "nexVal")
	private Long nextVal;

}
