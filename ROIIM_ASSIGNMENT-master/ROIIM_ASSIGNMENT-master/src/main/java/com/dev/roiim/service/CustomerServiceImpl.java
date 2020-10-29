package com.dev.roiim.service;

import com.dev.roiim.dto.CustomerDto;
import com.dev.roiim.dto.PaymentDto;
import com.dev.roiim.helper.User;
import com.dev.roiim.helper.PaymentJSON.*;
import com.dev.roiim.helper.ResponseCustomer;
import com.dev.roiim.helper.ResponseToken;
import com.dev.roiim.helper.Token;
import com.dev.roiim.model.Customer;
import com.dev.roiim.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders header;


    @Override
    public String registerCustomer(CustomerDto customerDto) {

        Customer customer = customerRepository.findByEmail(customerDto.getEmail());

        if(customer == null) createCustomer(new Customer(),customerDto);

        String str = createSingleUseToken(customerRepository.findByEmail(customerDto.getEmail()));
        return str;

    }


    private void createCustomer(Customer customer,CustomerDto customerDto) {
        String Url = "https://api.test.paysafe.com/paymenthub/v1/customers";
        User customerJSON = new User();

        customerJSON.setEmail(customerDto.getEmail());
        customerJSON.setMerchantCustomerId(customerDto.getEmail()+UUID.randomUUID());

        HttpEntity<User> entity = new HttpEntity<User>(customerJSON,header);
        ResponseCustomer responseCustomerJSON = (ResponseCustomer) restTemplate.postForObject(
                Url, entity, ResponseCustomer.class);

        customer.setEmail(customerDto.getEmail());
        customer.setCustomerId(responseCustomerJSON.getId());
        customerRepository.save(customer);
    }

    private String createSingleUseToken(Customer customer){
        String Url = "https://api.test.paysafe.com/paymenthub/v1/customers/"+customer.getCustomerId()+"/singleusecustomertokens";
        Token tokenJSON = new Token();

        tokenJSON.setMerchantRefNum(""+UUID.randomUUID());

        HttpEntity<Token> entity = new HttpEntity<Token>(tokenJSON,header);
        ResponseToken responseTokenJSON = (ResponseToken) restTemplate.postForObject(
                Url,  entity, ResponseToken.class);

        return responseTokenJSON.getSingleUseCustomerToken();
    }

    @Override
    public String completePayment(PaymentDto paymentDto) {
        String Url = "https://api.test.paysafe.com/paymenthub/v1/payments";
        Payment paymentJSON = new Payment();

        if (paymentDto.getCustomerOperation() != null && paymentDto.getCustomerOperation().equals("ADD")) {
            Customer customer = customerRepository.findByEmail(paymentDto.getEmail());
            customer.setCustomerOperation("ADD");
            paymentJSON.setCustomerId(customerRepository.findByEmail(paymentDto.getEmail()).getCustomerId());
            customerRepository.save(customer);
        }


        paymentJSON.setPaymentHandleToken(paymentDto.getPaymentHandleToken());
        paymentJSON.setAmount(paymentDto.getAmount());
        paymentJSON.setMerchantRefNum(UUID.randomUUID() + "");
        HttpEntity<Payment> entity = new HttpEntity<Payment>(paymentJSON, header);

        try {
            ResponsePayment responsePaymentJSON = (ResponsePayment) restTemplate.postForObject(
                    Url, entity, ResponsePayment.class);
            if (responsePaymentJSON.getStatus().equals("COMPLETED")) return responsePaymentJSON.getStatus();
        } catch (HttpClientErrorException ex) {
            if (ex.getStatusCode() != HttpStatus.BAD_REQUEST) {
                return null;
            }
        }
        return null;
    }



}

