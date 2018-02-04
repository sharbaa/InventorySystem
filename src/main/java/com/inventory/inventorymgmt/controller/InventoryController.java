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
import com.inventory.inventorymgmt.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;
	
	
	@RequestMapping(value="/inventorydetails" , method = RequestMethod.GET , consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Inventory> getInventoryDetails(){
		return inventoryService.getInventoryDetails();
	}
	
	@RequestMapping(value="/insert/inventorydetails/{id}/{quantity}" , method = RequestMethod.POST , consumes=MediaType.APPLICATION_JSON_VALUE)
	public void addInventory(@RequestBody ProductInfo productInfo ,@PathVariable Integer id,@PathVariable Integer quantity){
		Inventory inventory = new Inventory();
		inventory.setInvetoryId(id);
		inventory.setProductInfo(productInfo);
		inventory.setQuantity(quantity);
		inventoryService.saveInventoryDetails(inventory);
	}
	
}
