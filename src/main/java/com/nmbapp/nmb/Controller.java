package com.nmbapp.nmb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import com.nmbapp.nmb.Customer;
import com.nmbapp.nmb.Account;

@RestController
public class Controller{

	@PostMapping(path = "/create", consumes = "application/json")
	public Object createAccount(@RequestBody Customer customer){
		try{
			Account account = new Account();
			return customer;
		}catch(Exception e){
			e.printStackTrace();
			return "{operation:0xff000000, code:-1}";
		}
	}

	@GetMapping("/info")
	public String getAccountInfo(){
		try{

                        return "{operation:0xff000001, code:0}";
                }catch(Exception e){
                        e.printStackTrace();
                        return "{operation:0xff000001, code:-1}";
                }

	}

	@PostMapping(path = "/update", consumes = "application/json")
	public String updateAccountInfo(){
                try{

                        return "{operation:0xff000002, code:0}";
                }catch(Exception e){
                        e.printStackTrace();
                        return "{operation:0xff000002, code:-1}";
                }

	}


	@GetMapping("/delete")
	public String deleteAccount(){
                try{

                        return "{operation:0xff000003, code:0}";
                }catch(Exception e){
                        e.printStackTrace();
                        return "{operation:0xff000003, code:-1}";
                }

	}
}
