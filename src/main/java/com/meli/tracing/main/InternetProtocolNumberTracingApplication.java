package com.meli.tracing.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages={"com.meli.tracing"})
@EnableJpaRepositories("com.meli.tracing.repository")
@EntityScan("com.meli.tracing")
public class InternetProtocolNumberTracingApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternetProtocolNumberTracingApplication.class, args);
	}

}
