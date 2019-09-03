package com.meli.tracing.domain;

public class IPRequestInfoEntity {
	
	private String ipNumber;
	
	private String actualDateTime;
	
	private String countryName;
	
	private String countryCode;
	
	private String countryLanguages;
	
	private String countryCurrencies;
	
	private String countryActualDateTime;
	
	private String distanceFromBsAs;

	/**
	 * @return the ipNumber
	 */
	public String getIpNumber() {
		return ipNumber;
	}

	/**
	 * @param ipNumber the ipNumber to set
	 */
	public void setIpNumber(String ipNumber) {
		this.ipNumber = ipNumber;
	}

	/**
	 * @return the actualDateTime
	 */
	public String getActualDateTime() {
		return actualDateTime;
	}

	/**
	 * @param actualDateTime the actualDateTime to set
	 */
	public void setActualDateTime(String actualDateTime) {
		this.actualDateTime = actualDateTime;
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
	 * @return the countryLanguages
	 */
	public String getCountryLanguages() {
		return countryLanguages;
	}

	/**
	 * @param countryLanguages the countryLanguages to set
	 */
	public void setCountryLanguages(String countryLanguages) {
		this.countryLanguages = countryLanguages;
	}
	
	/**
	 * @return the countryCurrencies
	 */
	public String getCountryCurrencies() {
		return countryCurrencies;
	}

	/**
	 * @param countryCurrencies the countryCurrencies to set
	 */
	public void setCountryCurrencies(String countryCurrencies) {
		this.countryCurrencies = countryCurrencies;
	}

	/**
	 * @return the countryActualDateTime
	 */
	public String getCountryActualDateTime() {
		return countryActualDateTime;
	}

	/**
	 * @param countryActualDateTime the countryActualDateTime to set
	 */
	public void setCountryActualDateTime(String countryActualDateTime) {
		this.countryActualDateTime = countryActualDateTime;
	}

	/**
	 * @return the distanceFromBsAs
	 */
	public String getDistanceFromBsAs() {
		return distanceFromBsAs;
	}

	/**
	 * @param distanceFromBsAs the distanceFromBsAs to set
	 */
	public void setDistanceFromBsAs(String distanceFromBsAs) {
		this.distanceFromBsAs = distanceFromBsAs;
	}

}
