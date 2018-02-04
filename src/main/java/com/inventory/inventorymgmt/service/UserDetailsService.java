package com.inventory.inventorymgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorymgmt.model.Inventory;
import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.model.UserDetails;
import com.inventory.inventorymgmt.model.UserWithProductAndInventory;
import com.inventory.inventorymgmt.repository.InventoryRepository;
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
	public UserWithProductAndInventory<ProductInfo, Inventory> getInventoryInfo(String userToken){
		
		UserWithProductAndInventory<ProductInfo, Inventory> productAndInventory = null;
		UserDetails userDetail = userRepository.findByUserToken(userToken);
		List<Inventory> inventoryList  = inventoryService.getInventoryDetails();
		
		if(userDetail == null){
			productAndInventory = new UserWithProductAndInventory<>(null, inventoryList);
					
		}else{
			productAndInventory = new UserWithProductAndInventory<>(userDetail.getProductInfo(), inventoryList);
				
		}
		return productAndInventory;
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
			
			Inventory invntry = inventoryService.findByInventoryId(inventory.getInvetoryId());
			if(invntry !=null){
			inventoryService.removeInventoryDetails(invntry.getInvetoryId());
			
			for (ProductInfo product : productInfo) {
				if (product.getProductId().equals(inventory.getProductInfo().getProductId())){
				
					invntry.setInvetoryId(inventory.getInvetoryId());
					invntry.setQuantity(inventory.getQuantity()-product.getQunatity());
					invntry.setProductInfo(product);
					inventoryService.saveInventoryDetails(invntry);
				}
				
			}
		}
			
		}
	
		userRepository.save(userDetail);
		
	}
	
	
}
