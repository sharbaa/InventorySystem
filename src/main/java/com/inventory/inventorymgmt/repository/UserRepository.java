package com.inventory.inventorymgmt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.model.UserDetails;

/**
 * 
 * @author badsharma
 *
 */
public interface UserRepository extends MongoRepository<UserDetails, String>{

	public UserDetails findByUserToken(String userToken);
	
	public UserDetails deleteUserDetailsByProductInfo(ProductInfo productInfo);
	
}
