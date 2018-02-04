package com.inventory.inventorymgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorymgmt.model.Inventory;
import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.model.UserDetails;
import com.inventory.inventorymgmt.repository.UserRepository;

/**
 * 
 * @author badsharma
 *
 */
@Service
public class UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	InventoryService inventoryService;
	
	
	/**
	 * 
	 * @param userToken
	 * @return
	 */
	public UserDetails getUserInfo(String userToken){
		return userRepository.findByUserToken(userToken);
	}
	
	
	/**
	 * 
	 * @param userToken
	 * @return
	 */
	public List<Inventory> getInventoryInfo(String userToken){
		List<Inventory> inventoryList = null;
		UserDetails userDetail = userRepository.findOne(userToken);
		if(userDetail == null){
		 inventoryList = inventoryService.getInventoryDetails();	
		}
		return inventoryList;
	}
	
	
	/**
	 * 
	 * @param userToken
	 * @param productInfo
	 */
	public void addProductForUser(String userToken,List<ProductInfo> productInfo){
		
		UserDetails userDetail = new UserDetails();
		userDetail.setUserToken(userToken);
		userDetail.setProductInfo(productInfo);
	
		List<Inventory> inventoryList = inventoryService.getInventoryDetails();
		
		for (Inventory inventory : inventoryList) {
			for (ProductInfo product : productInfo) {
				if (product.getProductId().equals(inventory.getProductInfo().getProductId())){
				
					inventory.setInvetoryId(inventory.getInvetoryId());
					inventory.setQuantity(inventory.getQuantity()-product.getQunatity());
					inventory.setProductInfo(product);

				}
				inventoryService.saveInventoryDetails(inventory);
			}
		}

		userRepository.save(userDetail);
		
	}
	
	
}
