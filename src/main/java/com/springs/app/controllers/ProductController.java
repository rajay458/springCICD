package com.springs.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	private static Map<Integer, Product> productMap= new HashMap<Integer, Product>();
	
	static{
		Product almonds = new Product();
		almonds.setId(1);
		almonds.setName("Almonds");
		productMap.put(almonds.getId(),almonds);
		
		Product honey = new Product();
		honey.setId(2);
		honey.setName("Honey");
		productMap.put(honey.getId(), honey);
		
		Product pista = new Product();
		pista.setId(3);
		pista.setName("Pista");
		productMap.put(pista.getId(), pista);
		
		Product walnuts = new Product();
		walnuts.setId(4);
		walnuts.setName("Walnuts");
		productMap.put(walnuts.getId(), walnuts);
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<Object> getProducts(){
		return new ResponseEntity<Object>(productMap.values(),HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/products", method = RequestMethod.POST)
	   public ResponseEntity<Object> createProduct(@RequestBody Product product) {
		 productMap.put(product.getId(), product);
	      return new ResponseEntity<Object>(productMap.values(), HttpStatus.OK);
	   }
	 
	 @RequestMapping(value = "/products/{id}", method = RequestMethod.DELETE)
	   public ResponseEntity<Object> deleteProduct(@PathVariable("id") int id) {
		 productMap.remove(id);
	      return new ResponseEntity<Object>(productMap.values(), HttpStatus.OK);
	   }
	 
	 @RequestMapping(value = "/products", method = RequestMethod.PUT)
	   public ResponseEntity<Object> updateProduct(@RequestBody Product product) {
		 productMap.put(product.getId(), product);
	      return new ResponseEntity<Object>(productMap, HttpStatus.OK);
	   }
	 
	 @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
	   public ResponseEntity<Object> getProduct(@PathVariable("id") int id) {
	      return new ResponseEntity<Object>(productMap.get(id), HttpStatus.OK);
	   }

}
