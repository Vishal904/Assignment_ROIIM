package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entities.Card;
import com.example.demo.repos.CardRepository;

@Controller
public class CardController {
	
	@Autowired
	private CardRepository cardRepository;
	
	@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public String makePayment(@RequestParam("cardNumber") String cardNumber, @RequestParam("cardHolderName") String cardHolderName,
			@RequestParam("expiryDate") String expiryDate, @RequestParam("cvv") String cvv, @RequestParam("isSave") String isSave) {
		
		Card card = new Card();
		//Is setId Required ?
		
		card.setCardNumber(cardNumber);
		card.setCardHolderName(cardHolderName);
		card.setExpiryDate(expiryDate);
		card.setCvv(cvv);
		
		if(isSave == "1") {
			cardRepository.save(card); //Error
		}	
		return "paymentSuccess";
	}
}
