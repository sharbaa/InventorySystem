package com.inventory.inventorymgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventory.inventorymgmt.model.Inventory;

/**
 * 
 * @author badsharma
 *
 */
public interface InventoryRepository extends MongoRepository<Inventory, Integer>{

	public Inventory findByInvetoryId(Integer invetoryId);
}
