package com.inventory.inventorymgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	
	@RequestMapping(value="/inventorydetails" , method = RequestMethod.GET , consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<ProductInfo> getInventoryDetails(){
		return inventoryService.getInventoryDetails();
	}
	
	@RequestMapping(value="/insert/inventorydetails" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addInventory(ProductInfo productInfo){
		 inventoryService.saveInventoryDetails(productInfo);
	}

	
}
