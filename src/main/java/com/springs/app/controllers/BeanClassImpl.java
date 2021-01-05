package com.springs.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class BeanClassImpl implements BeanClass{
	
	@Value("${prop_name: Raja Shekhar}")
	public String name;
	
	public String getData(){
		return name;
	}

}
