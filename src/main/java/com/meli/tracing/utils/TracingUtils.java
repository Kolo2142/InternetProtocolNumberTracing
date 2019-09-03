package com.meli.tracing.utils;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.meli.tracing.cons.TracingConst;

public class TracingUtils {
	
	public static boolean isValidIP(String ipAddr) {
        
        Pattern ptn = Pattern.compile(TracingConst.IP_PATTERN);
        Matcher mtch = ptn.matcher(ipAddr);
        return mtch.find();
    }
	
	 public static Float distFrom(Float lat, Float lng) {
		 
		 double dLat = Math.toRadians(lat-TracingConst.BSAS_LAT);
		 double dLng = Math.toRadians(lng-TracingConst.BSAS_LONG);
		 double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		            Math.cos(Math.toRadians(TracingConst.BSAS_LAT)) * Math.cos(Math.toRadians(lat)) *
		            Math.sin(dLng/2) * Math.sin(dLng/2);
		 double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		 Float dist = (float) (TracingConst.EARTH_RADIUS * c);

		return dist;
	}
	 
	 public static String dateTimeFormatted(LocalDateTime dateTime) {
		 DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern(TracingConst.DATE_FORMAT);
		 return customFormatter.format(dateTime);
	 }
	 
	 public static String zonedDateTimeFormatted(LocalDateTime now, String timeZone) {
		 
		 ZoneOffset offset = null;
		 
		 if (timeZone.equals("UTC")){
			 offset = ZoneOffset.ofHours(3);
		 } else {
			 offset = ZoneOffset.ofHours(Integer.parseInt(timeZone.replace("UTC", "").replace(":00", "")) + 3);
		 }
		 
		 ZonedDateTime utc = now.atZone(ZoneOffset.UTC);

		 return dateTimeFormatted(LocalDateTime.ofInstant(utc.toInstant(), offset));
	 }

}
