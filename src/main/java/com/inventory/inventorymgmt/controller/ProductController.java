package com.inventory.inventorymgmt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventorymgmt.model.Product;
import com.inventory.inventorymgmt.repository.ProductRepository;



/**
 * 
 * @author badsharma
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	
	@RequestMapping(value="/insert" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void insertProduct(@RequestBody Product product){
		productRepository.save(product);	
	}
	
	
	

	@RequestMapping(value="/find/{id}" , method = RequestMethod.GET , consumes=MediaType.APPLICATION_JSON_VALUE)
	public Product getProductDetailById(@PathVariable Integer id){
		return productRepository.findOne(id);
	}
	

	@RequestMapping(value="/update" , method = RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateProductDetails(@RequestBody Product product){
		productRepository.save(product);
	}
	
	
	
	
	
	@RequestMapping(value="/remove/{id}" , method = RequestMethod.DELETE , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void removeProductDetailById(@PathVariable Integer id){
		 productRepository.delete(id);
	}
	
	
	
	
	
}
