package com.inventory.inventorymgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventory.inventorymgmt.model.ProductInfo;


/**
 * 
 * @author badsharma
 *
 */
public interface ProductRepository extends MongoRepository<ProductInfo, Integer>{

}
