package com.inventory.inventorymgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.inventorymgmt.model.ProductInfo;
import com.inventory.inventorymgmt.repository.ProductRepository;

/**
 * 
 * @author badsharma
 *
 */
@Service
public class ProductInfoService {

	@Autowired
	ProductRepository productRepository;
	
	
	public void insertProduct(ProductInfo product){
		productRepository.save(product);	
	}
	
	public ProductInfo getProductDetailById(Integer id){
		return productRepository.findOne(id);
	}
	
	public List<ProductInfo> getProductDetails(){
		return productRepository.findAll();
	}

	public void updateProductDetails(ProductInfo product){
		productRepository.save(product);
	}
	
	public void removeProductDetailById(Integer id){
		 productRepository.delete(id);
	}
	
	
	
}
