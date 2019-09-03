package com.meli.tracing.cons;

public class TracingConst {
	
	public static final String IP_COUNTRY_INFO_URL = "ip.country.info.url";
	
	public static final String COUNTRY_INFO_URL = "country.info.url";
	
	public static final String CURRENCY_INFO_URL = "currency.info.url";
	
	public static final Float BSAS_LAT = new Float(-34);
	
	public static final Float BSAS_LONG = new Float(-64);
	
	public static final double EARTH_RADIUS = 6371;
	
	public static final String IP_PATTERN = "^(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})\\.(\\d{1,3})$";
	
	public static final String MAX_REQUEST_NUMBER = "max.request.number";
	
	public static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
	
	public static final String KMS = " kms ";
	
	public static final String BSAS_KMS_LAT_LONG_DIST = KMS + "(" + BSAS_LAT.toString() + "," + BSAS_LONG.toString() + ") a ({lat},{lng})";
	
	public static final String CURRENCY_COMPARISON = " (1 {currencyCode} = {currencyValue} U$S)";

}
