package com.nmbapp.nmb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.ResponseEntity;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.nmbapp.nmb.*;
import java.util.Date;

@RestController
public class Controller{

	@PostMapping(path = "/create", consumes = "application/json")
	public Object createAccount(@RequestBody Customer customer){
		try{
			Account account = new Account();
			String accountNumber = account.generateAccountNumber();

			account.accountNumber = accountNumber;
			account.dateOfCreation = new Date().toString();
			account.currency = "US$";
			account.mobileNumber = customer.phoneNumber;
			account.branch = customer.branch;
			account.initialBalance = 200.00;
			account.activeBalance = 100.00;
			account.debitAmmount = 0;
			account.creditAmmount = 0;
			customer.account = account;

			MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
			MongoDatabase database = mongoClient.getDatabase("nmb");
			MongoCollection<Document> collection = database.getCollection("customers");

			collection.insertOne(customer);
			database.getCollection("accounts").insertOne(account);
			return customer;

		}catch(Exception e){
			e.printStackTrace();
			return "Internal Server Error";
		}
	}

	@GetMapping("/info")
	public Object getAccountInfo(@RequestParam String id){
		try{
			MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
                        MongoDatabase database = mongoClient.getDatabase("nmb");
                        MongoCollection<Document> collection = database.getCollection("customers");
			return collection.find(new Document("nationalID", id)).first();

                }catch(Exception e){
                        e.printStackTrace();
                        return "Internal Server Error";
                }

	}

	@PostMapping(path = "/update", consumes = "application/json")
	public Object updateAccountInfo(){
                try{
			MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
                        MongoDatabase database = mongoClient.getDatabase("nmb");
                        MongoCollection<Document> collection = database.getCollection("customers");
                        return "{operation:0xff000002, code:0}";
                }catch(Exception e){
                        e.printStackTrace();
                        return "Internal Server Error";

		}
	}

	@GetMapping("/delete")
	public Object deleteAccount(@RequestParam String id){
                try{
			MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
                        MongoDatabase database = mongoClient.getDatabase("nmb");
                        MongoCollection<Document> collection = database.getCollection("customers");
                        collection.deleteOne(new Document("nationalID", id));
                        return "{operation:0xff000003, code:0}";
                }catch(Exception e){
                        e.printStackTrace();
                        return "Internal Server Error";
                }

	}
}
