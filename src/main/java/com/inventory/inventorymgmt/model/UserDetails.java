package com.inventory.inventorymgmt.model;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author badsharma
 *
 */
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7888744418489253354L;
	private String userToken;
	private List<ProductInfo> productInfo;
	public String getUserToken() {
		return userToken;
	}
	public void setUserToken(String userToken) {
		this.userToken = userToken;
	}
	public List<ProductInfo> getProductInfo() {
		return productInfo;
	}
	public void setProductInfo(List<ProductInfo> productInfo) {
		this.productInfo = productInfo;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productInfo == null) ? 0 : productInfo.hashCode());
		result = prime * result + ((userToken == null) ? 0 : userToken.hashCode());
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
		UserDetails other = (UserDetails) obj;
		if (productInfo == null) {
			if (other.productInfo != null)
				return false;
		} else if (!productInfo.equals(other.productInfo))
			return false;
		if (userToken == null) {
			if (other.userToken != null)
				return false;
		} else if (!userToken.equals(other.userToken))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "UserDetails [userToken=" + userToken + ", productInfo=" + productInfo + "]";
	}
	
	
	
}
