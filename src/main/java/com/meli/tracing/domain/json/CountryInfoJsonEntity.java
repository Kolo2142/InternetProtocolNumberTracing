package com.meli.tracing.domain.json;

public class CountryInfoJsonEntity {
	
	private CurrencyJsonEntity[] currencies;
	
	private LanguageJsonEntity[] languages;
	
	private String[] latlng;
	
	private String[] timezones;

	/**
	 * @return the currencies
	 */
	public CurrencyJsonEntity[] getCurrencies() {
		return currencies;
	}

	/**
	 * @param currencies the currencies to set
	 */
	public void setCurrencies(CurrencyJsonEntity[] currencies) {
		this.currencies = currencies;
	}

	/**
	 * @return the languages
	 */
	public LanguageJsonEntity[] getLanguages() {
		return languages;
	}

	/**
	 * @param languages the languages to set
	 */
	public void setLanguages(LanguageJsonEntity[] languages) {
		this.languages = languages;
	}

	/**
	 * @return the latlng
	 */
	public String[] getLatlng() {
		return latlng;
	}

	/**
	 * @param latlng the latlng to set
	 */
	public void setLatlng(String[] latlng) {
		this.latlng = latlng;
	}

	/**
	 * @return the timezones
	 */
	public String[] getTimezones() {
		return timezones;
	}

	/**
	 * @param timezones the timezones to set
	 */
	public void setTimezones(String[] timezones) {
		this.timezones = timezones;
	}

}
