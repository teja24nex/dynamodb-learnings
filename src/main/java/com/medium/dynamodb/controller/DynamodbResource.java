package com.medium.dynamodb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.medium.dynamodb.model.Messages;
import com.medium.dynamodb.repository.DynamoDBRespository;

@RestController
@CrossOrigin(origins="*",allowCredentials="true", allowedHeaders="*")
public class DynamodbResource {
	
	@Autowired 
	DynamoDBRespository dbRepo;
	
	@GetMapping(value="getAllValues")
	public List<Messages> getAllValues() {
		
		
		List<Messages> stocksList = new ArrayList();
		stocksList = dbRepo.getDetails();
		
		System.out.println("Resource--------"+stocksList.get(0));

		
		return stocksList;
	}

}
