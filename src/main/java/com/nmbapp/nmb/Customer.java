package com.nmbapp.nmb;
import org.bson.Document;


public class Customer extends Document{

	public String firstName, lastName, nationalID, title, username, gender, creationDate, phoneNumber, branch;
	public boolean homeOwner;
	public Account account;

	public Customer() {}
	public Customer(String firstName, String lastName,
			String nationalID, String title,
			String username, String gender, String creationDate, boolean homeOwner){

		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalID = nationalID;
		this.title = title;
		this.username = username;
		this.gender = gender;
		this.creationDate = creationDate;
		this.homeOwner = homeOwner;
	}
}
