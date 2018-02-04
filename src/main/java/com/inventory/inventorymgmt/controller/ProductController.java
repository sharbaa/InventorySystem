package com.inventory.inventorymgmt.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.service.ProductInfoService;



/**
 * 
 * @author badsharma
 *
 */
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductInfoService productInfoService;
	
	
	@RequestMapping(value="/insert" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void insertProduct(@RequestBody ProductInfo product){
		productInfoService.insertProduct(product);	
	}
	

	@RequestMapping(value="/find/{id}" , method = RequestMethod.GET , consumes=MediaType.APPLICATION_JSON_VALUE)
	public ProductInfo getProductDetailById(@PathVariable Integer id){
		return productInfoService.getProductDetailById(id);
	}
	
	@RequestMapping(value="/findAll" , method = RequestMethod.GET , consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<ProductInfo> getProductDetails(){
		return productInfoService.getProductDetails();
	}

	@RequestMapping(value="/update" , method = RequestMethod.PUT , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void updateProductDetails(@RequestBody ProductInfo product){
		productInfoService.updateProductDetails(product);
	}
	
	
	@RequestMapping(value="/remove/{id}" , method = RequestMethod.DELETE , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void removeProductDetailById(@PathVariable Integer id){
		productInfoService.removeProductDetailById(id);
	}
	
	
	
}
