package com.medium.dynamodb.model;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;

public class Messages implements Serializable{

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public String getStockValue() {
		return stockValue;
	}

	public void setStockValue(String stockValue) {
		this.stockValue = stockValue;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2077992697029525233L;
	
	@DynamoDBHashKey(attributeName="stock_id")
	private String stockId;
	
	@DynamoDBAttribute(attributeName="stock_value")
	private String stockValue;

}
