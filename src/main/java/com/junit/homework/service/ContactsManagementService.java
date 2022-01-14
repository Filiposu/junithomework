package com.junit.homework.service;

import javax.validation.ValidationException;

import com.junit.homework.domain.CustomerContact;
import com.junit.homework.repos.CustomerContactRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactsManagementService {
	private Logger Logger  = LoggerFactory.getLogger(ContactsManagementService.class);

	@Autowired
	private CustomerContactRepository customerContactRepository;
	
	public CustomerContact add(CustomerContact aContact) {
		CustomerContact newContact = null;
		if(!aContact.getEmail().contains("@gmail.com")){
			throw new ValidationException("only gmail accounts are supported");
		}
		if(aContact.getDeliveryAddressCity()!=null && aContact.getDeliveryAddressLZipCode()==null){
			throw new IllegalArgumentException("Zip code can not be null if city is selected");
		}
		try {
			newContact = customerContactRepository.save(aContact);
		} catch (Exception ex) {
			Logger.error("Exception occured while trying to save customer contact");
		}
		return newContact;	
	}
}
