package com.medium.dynamodb.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.HttpServerErrorException;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.QueryResultPage;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException;
import com.medium.dynamodb.model.Messages;

@Repository
public class DynamoDBRespository {
	
	@Resource(name="dynamoDBMapper")
	DynamoDBMapper dbMapper;
	
	public List<Messages> getDetails(){
		
		Regions region = Regions.US_EAST_1;
		List<Messages> listing = new ArrayList<>();
		QueryResultPage<Messages> itemList;
		
		// #Expression Attributes
		Map<String, String> expressionAttributeNames = new HashMap();
		expressionAttributeNames.put("#stock_id", "stock_id");
		Map<String, AttributeValue> expressionAttributeValues = new HashMap();
		expressionAttributeValues.put(":stock_id", new AttributeValue().withS("MU"));
		
		
		DynamoDBQueryExpression<Messages> retrieveQuery = new DynamoDBQueryExpression<Messages>()
		.withKeyConditionExpression("#stock_id=:stock_id")
		.withExpressionAttributeNames(expressionAttributeNames)
		.withExpressionAttributeValues(expressionAttributeValues)
		.withScanIndexForward(false);
		try {
			// DynamoDB Query
			itemList = dbMapper.queryPage(Messages.class, retrieveQuery);
			listing = itemList.getResults();
		}
		  catch (ResourceNotFoundException e) {
			throw e;
		} catch (HttpServerErrorException e) {
			throw e;
		}
		  catch(Exception e) {
			  throw e;
		}
		return listing;
	}

}
