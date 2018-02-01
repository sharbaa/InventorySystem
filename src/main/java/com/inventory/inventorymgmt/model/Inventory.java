package com.inventory.inventorymgmt.model;

import java.io.Serializable;
import java.util.List;

public class Inventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6528021435831017698L;

	private String invetoryId;
	private List<ProductInfo> productInfo;
	private Integer quantity;

	public String getInvetoryId() {
		return invetoryId;
	}

	public void setInvetoryId(String invetoryId) {
		this.invetoryId = invetoryId;
	}

	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}

	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((invetoryId == null) ? 0 : invetoryId.hashCode());
		result = prime * result + ((productInfo == null) ? 0 : productInfo.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
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
		Inventory other = (Inventory) obj;
		if (invetoryId == null) {
			if (other.invetoryId != null)
				return false;
		} else if (!invetoryId.equals(other.invetoryId))
			return false;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Inventory [invetoryId=" + invetoryId + ", productInfo=" + productInfo + ", quantity=" + quantity + "]";
	}
	
	

}
