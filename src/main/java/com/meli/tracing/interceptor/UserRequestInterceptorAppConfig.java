package com.meli.tracing.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class UserRequestInterceptorAppConfig implements WebMvcConfigurer {
	
	   @Autowired
	   UserRequestInterceptor requestInterceptor;

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(requestInterceptor);
	   }

}
