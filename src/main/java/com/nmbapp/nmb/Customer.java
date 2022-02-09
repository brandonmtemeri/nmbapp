package com.nmbapp.nmb;

public class Customer{

	public String firstName, lastName, nationalID, title, username, gender, creationDate;
	public boolean homeOwner;
	private Account account;

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
