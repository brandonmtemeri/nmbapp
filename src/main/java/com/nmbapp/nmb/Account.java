package com.nmbapp.nmb;

public class Account{

	public String accountNumber, dateOfCreation, currency, mobileNumber, branch;
	public double initialBalance, activeBalance, debitAmmount, creditAmmount;
	public String debitNarration, creditNarration;

	public Account(){}
	public Account(
		String accountNumber, String dateOfCreation, String currency, String mobileNumber, String branch,
		double initialBalance, double activeBalance, double debitAmmount, double creditAmmount,
		String debitNarration, String creditNarration
	){}

}
