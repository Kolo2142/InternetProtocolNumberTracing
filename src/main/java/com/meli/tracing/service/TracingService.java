package com.meli.tracing.service;

import com.meli.tracing.domain.json.CountryInfoJsonEntity;
import com.meli.tracing.domain.json.IPCountryInfoJsonEntity;

public interface TracingService {
	
	IPCountryInfoJsonEntity getIPInfo(String internetProtocolNumber);
	
	CountryInfoJsonEntity getCountryInfo(String countryCode);
	
	void saveCountryRequest(Float distance, IPCountryInfoJsonEntity countryInfo);
	
	String getCurrencyInfo(String currencyCode);
	
	String getNearestRequest();
	
	String getFurthestRequest();
	
	String getAverageRequests();

}
