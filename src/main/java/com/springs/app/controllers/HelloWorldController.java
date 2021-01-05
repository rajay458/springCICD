package com.springs.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	BeanClass bc;

	@RequestMapping(value = "/")
	public String hello(){
		return bc.getData();
	}
	
	
}
