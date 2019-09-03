package com.meli.tracing.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.meli.tracing.cons.TracingConst;
import com.meli.tracing.domain.IPRequestInfoEntity;
import com.meli.tracing.domain.json.CountryInfoJsonEntity;
import com.meli.tracing.domain.json.CurrencyJsonEntity;
import com.meli.tracing.domain.json.IPCountryInfoJsonEntity;
import com.meli.tracing.domain.json.LanguageJsonEntity;
import com.meli.tracing.service.TracingService;
import com.meli.tracing.utils.TracingUtils;

@RestController
public class TracingController {
	
	@Autowired
	@Qualifier("tracingService")
	private TracingService tracingService;
	
	@GetMapping("/process/{ipNumber}")
	public IPRequestInfoEntity processInternetProtocolNumber(@PathVariable String ipNumber) {
		
		if (!TracingUtils.isValidIP(ipNumber)) {
			throw new RuntimeException("IP number format error");
		}
		
		LocalDateTime actualDateTime = LocalDateTime.now();
		
		IPRequestInfoEntity returnInfo = new IPRequestInfoEntity();
		returnInfo.setIpNumber(ipNumber);
		returnInfo.setActualDateTime(TracingUtils.dateTimeFormatted(actualDateTime));
		
		IPCountryInfoJsonEntity ipCountryInfo = tracingService.getIPInfo(ipNumber);
		returnInfo.setCountryCode(ipCountryInfo.getCountryCode());
		returnInfo.setCountryName(ipCountryInfo.getCountryName());
		
		CountryInfoJsonEntity countryInfo = tracingService.getCountryInfo(ipCountryInfo.getCountryCode());
		returnInfo.setCountryLanguages(processLanguages(countryInfo.getLanguages()));
		returnInfo.setCountryActualDateTime(processCountryTimeZones(countryInfo.getTimezones(), actualDateTime));
		returnInfo.setCountryCurrencies(processCountryCurrencies(countryInfo.getCurrencies()));
		
		Float lat = new Float(countryInfo.getLatlng()[0]);
		Float lng = new Float(countryInfo.getLatlng()[1]);
		
		Float distanceFromBsAs = TracingUtils.distFrom(lat, lng);
		returnInfo.setDistanceFromBsAs(distanceFromBsAs.toString() + TracingConst.BSAS_KMS_LAT_LONG_DIST.replace("{lat}", lat.toString()).replace("{lng}", lng.toString()));
		
		tracingService.saveCountryRequest(distanceFromBsAs, ipCountryInfo);
		
		return returnInfo;
	}
	
	@GetMapping("/nearest")
	public String getNearestRequest() {
		return tracingService.getNearestRequest();
	}
	
	@GetMapping("/furthest")
	public String getFurthestRequest() {
		return tracingService.getFurthestRequest();
	}
	
	@GetMapping("/average")
	public String getAverageRequests() {
		return tracingService.getAverageRequests();
	}
	
	private String processCountryCurrencies(CurrencyJsonEntity[] currencies) {
		
		String currenciesString = new String();
		String currencyValue = new String();
		CurrencyJsonEntity currency = null;
		
		for (int i = 0; i < currencies.length; i++) {
			currency = currencies[i];
			
			currencyValue = tracingService.getCurrencyInfo(currency.getCode());
			
			if (currencyValue.equals(new String())) {
				currenciesString = currenciesString + currency.getCode();
			} else {
				currenciesString = currenciesString + currency.getCode() + TracingConst.CURRENCY_COMPARISON.replace("{currencyCode}", currency.getCode()).replace("{currencyValue}", currencyValue);
			}
			
			if (i < currencies.length-1) {
				currenciesString = currenciesString + ", ";
			}
		}
		
		return currenciesString;
	}
	
	private String processCountryTimeZones(String[] timeZones, LocalDateTime actualDateTime) {
		
		String countryTimeZoneString = new String();
		
		for (int i = 0; i < timeZones.length; i++) {
			countryTimeZoneString = countryTimeZoneString + TracingUtils.zonedDateTimeFormatted(actualDateTime, timeZones[i]);
			countryTimeZoneString = countryTimeZoneString + " (" + timeZones[i] + ")";
			if (i < timeZones.length-1) {
				countryTimeZoneString = countryTimeZoneString + " o ";
			}
		}
		
		return countryTimeZoneString;
	}
	
	private String processLanguages(LanguageJsonEntity[] languages) {
		
		String languagesString = new String();
		LanguageJsonEntity language = null;
		
		for (int i = 0; i < languages.length; i++) {
			language = languages[i];
			languagesString = languagesString + language.getName() + " (" + language.getIso639_1() + ")";
			if (i < languages.length-1) {
				languagesString = languagesString + ", ";
			}
		}
		
		return languagesString;
  	}

}
