package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controllers.CardController;
import com.example.demo.entities.Card;

public class PaymentService {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@Autowired
	CardController cardController;
	
	/*@RequestMapping(value = "/makePayment", method = RequestMethod.POST)
	public String makePayment(@RequestParam("cardNumber") String cardNumber, @RequestParam("cardHolderName") String cardHolderName,
			@RequestParam("expiryDate") String expiryDate, @RequestParam("cvv") String cvv, @RequestParam("isSave") String isSave) {
		/*if(isSave == "1") {
			Card card = new Card();
			//Is setId Required ?
	
			card.setCardNumber(cardNumber);
			card.setCardHolderName(cardHolderName);
			card.setExpiryDate(expiryDate);
			card.setCvv(cvv);
			boolean response = CardController.saveCard(card); //Error
			if(!response)
				return "";
		}
		
		//CALL PAYSAFE API
		return "paymentsuccess";
	}*/
}
