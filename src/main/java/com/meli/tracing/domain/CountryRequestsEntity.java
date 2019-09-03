package com.meli.tracing.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CountryRequestsEntity {
	
	@Id
	private String countryCode;
	
	private String countryName;
	
	private Integer requestQuantity;
	
	private float distanceFromBsAs;

	/**
	 * @return the countryCode
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode the countryCode to set
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return the countryName
	 */
	public String getCountryName() {
		return countryName;
	}

	/**
	 * @param countryName the countryName to set
	 */
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	/**
	 * @return the requestQuantity
	 */
	public Integer getRequestQuantity() {
		return requestQuantity;
	}

	/**
	 * @param requestQuantity the requestQuantity to set
	 */
	public void setRequestQuantity(Integer requestQuantity) {
		this.requestQuantity = requestQuantity;
	}

	/**
	 * @return the distanceFromBsAs
	 */
	public float getDistanceFromBsAs() {
		return distanceFromBsAs;
	}

	/**
	 * @param distanceFromBsAs the distanceFromBsAs to set
	 */
	public void setDistanceFromBsAs(float distanceFromBsAs) {
		this.distanceFromBsAs = distanceFromBsAs;
	}

}
