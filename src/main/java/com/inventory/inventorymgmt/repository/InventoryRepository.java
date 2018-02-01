package com.inventory.inventorymgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventory.inventorymgmt.model.ProductInfo;

/**
 * 
 * @author badsharma
 *
 */
public interface InventoryRepository extends MongoRepository<ProductInfo, Integer>{

}
