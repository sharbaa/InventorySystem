package com.inventory.inventorymgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorymgmt.model.Inventory;
import com.inventory.inventorymgmt.repository.InventoryRepository;

/**
 * 
 * @author badsharma
 *
 */
@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	
	
	/**
	 * 
	 * @return
	 */
	public List<Inventory>  getInventoryDetails(){
		return inventoryRepository.findAll();
	}

	/**
	 * 
	 * @param productInfo
	 */
	public void  saveInventoryDetails(Inventory inventoryInfo){
		 inventoryRepository.save(inventoryInfo);
	}
	
	
}
