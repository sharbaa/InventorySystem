package com.inventory.inventorymgmt.model;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @author badsharma
 *
 * @param <ProductInfo>
 * @param <Inventory>
 */
public class UserWithProductAndInventory<ProductInfo,Inventory> implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1157321306727331365L;
	
	private List<ProductInfo> productInfo;
	private List<Inventory> inventoryInfo;
	
	
	
	public UserWithProductAndInventory(List<ProductInfo> productInfo, List<Inventory> inventoryInfo) {
		super();
		this.productInfo = productInfo;
		this.inventoryInfo = inventoryInfo;
	}
	
	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
	public List<Inventory> getInventoryInfo() {
		return inventoryInfo;
	}
	public void setInventoryInfo(List<Inventory> inventoryInfo) {
		this.inventoryInfo = inventoryInfo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((inventoryInfo == null) ? 0 : inventoryInfo.hashCode());
		result = prime * result + ((productInfo == null) ? 0 : productInfo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserWithProductAndInventory other = (UserWithProductAndInventory) obj;
		if (inventoryInfo == null) {
			if (other.inventoryInfo != null)
				return false;
		} else if (!inventoryInfo.equals(other.inventoryInfo))
			return false;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserWithProductAndInventory [productInfo=" + productInfo + ", inventoryInfo=" + inventoryInfo + "]";
	}
	
	
	
	
}
