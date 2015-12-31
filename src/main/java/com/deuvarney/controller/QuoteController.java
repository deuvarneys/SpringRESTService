package com.deuvarney.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class QuoteController {
	/*
	@RequestMapping(value="/quote", method = RequestMethod.GET)
	public Quote getQuote(){
		 RestTemplate restTemplate = new RestTemplate();
		 Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		 return quote;
		 //return "Sup";
	}
	*/
	@RequestMapping(value="/quote", method = RequestMethod.GET)
	public String getQuote(){
		System.out.println("TESTING HITTING QUOTE, WATCH OUT NOW");
		 //RestTemplate restTemplate = new RestTemplate();
		 //Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		 //return quote;
		 return "Suppy";
	}
	/*
	@RequestMapping(value="/south", method = RequestMethod.GET)
	//@ResponseStatus(code=HttpStatus.CONFLICT, reason= "The South will rise again")
	public String getSouth(){
		 //RestTemplate restTemplate = new RestTemplate();
		 //Quote quote = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		 //return quote;
		 return "Southy";
	}
	*/
}
