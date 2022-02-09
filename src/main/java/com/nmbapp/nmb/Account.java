package com.nmbapp.nmb;

import org.bson.Document;

public class Account extends Document{

	public String accountNumber, dateOfCreation, currency, mobileNumber, branch;
	public double initialBalance, activeBalance, debitAmmount, creditAmmount;
	public String debitNarration, creditNarration;

	public String generateAccountNumber(){
		double a,b,c,d;
		String acc;

		while (true){
			a = Math.random() * 10000;
			b = Math.random() * 10000;
			c = Math.random() * 10000;
			d = Math.random() * 10000;
			acc = String.format("%.0f-%.0f-%.0f-%.0f",a,b,c,d);
			if(acc.length() == 19){
				return acc;
			}
		}
	}

	public Account(){}
	public Account(
		String accountNumber, String dateOfCreation, String currency, String mobileNumber, String branch,
		double initialBalance, double activeBalance, double debitAmmount, double creditAmmount,
		String debitNarration, String creditNarration
	){}

}
