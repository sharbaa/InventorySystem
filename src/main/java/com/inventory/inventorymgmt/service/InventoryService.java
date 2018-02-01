package com.inventory.inventorymgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.repository.InventoryRepository;

/**
 * 
 * @author badsharma
 *
 */
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	/**
	 * 
	 * @return
	 */
	public List<ProductInfo>  getInventoryDetails(){
		return inventoryRepository.findAll();
	}

	/**
	 * 
	 * @param productInfo
	 */
	public void  saveInventoryDetails(ProductInfo productInfo){
		 inventoryRepository.save(productInfo);
	}
	
	
}
