package com.meli.tracing.service.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.meli.tracing.cons.TracingConst;
import com.meli.tracing.domain.CountryRequestsEntity;
import com.meli.tracing.domain.json.CountryInfoJsonEntity;
import com.meli.tracing.domain.json.IPCountryInfoJsonEntity;
import com.meli.tracing.repository.CountryRequestsRepository;
import com.meli.tracing.service.TracingService;

@Service("tracingService")
public class TracingServiceImpl implements TracingService {
	
	@Autowired 
	private Environment env;
	
	@Autowired
	private CountryRequestsRepository countryRequestsRepository;
	
	public IPCountryInfoJsonEntity getIPInfo(String internetProtocolNumber) {
		
		String jsonString = new String();
		
		try {

            URL url = new URL(env.getProperty(TracingConst.IP_COUNTRY_INFO_URL) + internetProtocolNumber);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
            	jsonString = jsonString + output;
            }
            conn.disconnect();

        } catch (Exception e) {
        	throw new RuntimeException("Failed : HTTP Error code 500");
        }
		
		return new Gson().fromJson(jsonString, IPCountryInfoJsonEntity.class);
	}
	
	public CountryInfoJsonEntity getCountryInfo(String countryCode) {
		
		String jsonString = new String();
		
		try {

            URL url = new URL(env.getProperty(TracingConst.COUNTRY_INFO_URL).replace("{countryCode}", countryCode));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;
            while ((output = br.readLine()) != null) {
            	jsonString = jsonString + output;
            }
            conn.disconnect();

        } catch (Exception e) {
        	throw new RuntimeException("Failed : HTTP Error code 500");
        }
		
		return new Gson().fromJson(jsonString, CountryInfoJsonEntity.class);
		
	}
	
	public void saveCountryRequest(Float distance, IPCountryInfoJsonEntity countryInfo) {
		
		CountryRequestsEntity ey = countryRequestsRepository.findByCountryCode(countryInfo.getCountryCode());
		
		if (ey != null) {
			ey.setRequestQuantity(ey.getRequestQuantity() + 1);
			countryRequestsRepository.save(ey);
		} else {
			ey = new CountryRequestsEntity();
			ey.setCountryCode(countryInfo.getCountryCode());
			ey.setCountryName(countryInfo.getCountryName());
			ey.setDistanceFromBsAs(distance);
			ey.setRequestQuantity(1);
			countryRequestsRepository.save(ey);
		}
	}
	
	public String getCurrencyInfo(String currencyCode) {
		
		String jsonString = new String();
		
		try {

            URL url = new URL(env.getProperty(TracingConst.CURRENCY_INFO_URL).replace("{currencyCode}", currencyCode));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() == 200) {
            	InputStreamReader in = new InputStreamReader(conn.getInputStream());
                BufferedReader br = new BufferedReader(in);
                String output;
                while ((output = br.readLine()) != null) {
                	jsonString = jsonString + output;
                }
            }
            conn.disconnect();

        } catch (Exception e) {
        	throw new RuntimeException("Failed : HTTP Error code 500");
        }
		
		if (!jsonString.equals(new String())) {
			jsonString = jsonString.split(",")[0].split(":")[2].replace("}","");
		}
		
		return jsonString;
	}
	
	public String getNearestRequest() {
		String distance = countryRequestsRepository.getNearestRequest();
		
		if (distance == null) {
			distance = "0";
		}
		
		return distance;
	}
	
	public String getFurthestRequest() {
		String distance = countryRequestsRepository.getFurthestRequest();
		
		if (distance == null) {
			distance = "0";
		}
		
		return distance;
	}
	
	public String getAverageRequests() {
		
		List<CountryRequestsEntity> countryRequestsList = countryRequestsRepository.findAll();
		
		Integer sum = new Integer(0);
		Integer totalRequestsQuantity = new Integer(0);
		
		for (CountryRequestsEntity countryRequest : countryRequestsList) {
			sum = sum + ((int) countryRequest.getDistanceFromBsAs() * countryRequest.getRequestQuantity());
			totalRequestsQuantity = totalRequestsQuantity + countryRequest.getRequestQuantity();
		}
		
		String average = new String();
		
		if (totalRequestsQuantity > 0) {
			average = Integer.valueOf(sum / totalRequestsQuantity).toString();
		} else {
			average = "0";
		}
		
		return average;
	}

}
