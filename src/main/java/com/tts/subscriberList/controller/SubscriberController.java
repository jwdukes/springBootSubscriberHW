package com.tts.subscriberList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.tts.subscriberList.model.Subscriber;
import com.tts.subscriberList.repository.SubscriberRepository;

@Controller
public class SubscriberController {
	
	@Autowired
	private SubscriberRepository subscriberRepository;
	
	@GetMapping(value = "/")
	public String index(Subscriber subscriber) {	
		return "subscriber/index";
	}
	
	
	@PostMapping(value = "/")
	public  String addNewSubscriber(Subscriber subscriber, Model model) {
	 Subscriber subscriberToAdd = new Subscriber(subscriber.getFirstName(), 
			 subscriber.getLastName(),
			 subscriber.getUsername());
	 subscriberRepository.save(subscriberToAdd);
	 model.addAttribute("firstName", subscriber.getFirstName());
		model.addAttribute("lastName", subscriber.getLastName());
		model.addAttribute("username", subscriber.getUsername());
		return "subscriber/result";	
	 
	
//copied from slide
//	public String addNewSubscriber(Subscriber subscriber, Model model) {
//		subscriberRepository.save(new Subscriber(subscriber.getFirstName(), 
//	        subscriber.getLastName(), subscriber.getUserName(), subscriber.getSignedUp()));
//		model.addAttribute("firstName", subscriber.getFirstName());
//		model.addAttribute("lastName", subscriber.getLastName());
//		model.addAttribute("username", subscriber.getUsername());
//		return "subscriber/result";		 
			 
			 
			 
			 
	}
}
