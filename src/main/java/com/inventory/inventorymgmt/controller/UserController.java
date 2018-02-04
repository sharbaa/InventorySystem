package com.inventory.inventorymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventorymgmt.model.Inventory;
import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.model.UserDetails;
import com.inventory.inventorymgmt.model.UserWithProductAndInventory;
import com.inventory.inventorymgmt.service.UserDetailsService;



@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@RequestMapping(value="/userinventoryinfo/{userToken}" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserDetails getUserInventoryDetails(@PathVariable String userToken){
		return userDetailsService.getUserInfo(userToken);
	}
	
	@RequestMapping(value="/inventoryinfo/{userToken}" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserWithProductAndInventory<ProductInfo, Inventory> getInventoryDetails(@PathVariable String userToken){
		return userDetailsService.getInventoryInfo(userToken);
	}
	
	@RequestMapping(value="/addProduct" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addProduct(@RequestBody UserDetails userDeails){
		userDetailsService.addProductForUser(userDeails.getUserToken(), userDeails.getProductInfo());
	}

	@RequestMapping(value="/removeProduct" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deleteProduct(@RequestBody UserDetails userDeails){
		userDetailsService.deleteProductForUser(userDeails.getUserToken(), userDeails.getProductInfo());
	}
	
	
	
	
	
}
