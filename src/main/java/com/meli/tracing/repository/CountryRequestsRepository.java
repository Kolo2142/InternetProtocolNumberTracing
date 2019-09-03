package com.meli.tracing.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.meli.tracing.domain.CountryRequestsEntity;

@Repository
public interface CountryRequestsRepository extends JpaRepository<CountryRequestsEntity, Long> {
	
	public static final String GET_BY_COUNTRY_CODE = "SELECT cr FROM CountryRequestsEntity cr WHERE countryCode = :countryCode";
	
	public static final String GET_NEAREST_REQUEST = "SELECT MIN(cr.distanceFromBsAs) FROM CountryRequestsEntity cr";
	
	public static final String GET_FURTHEST_REQUEST = "SELECT MAX(cr.distanceFromBsAs) FROM CountryRequestsEntity cr";
	
	@Query(GET_BY_COUNTRY_CODE)
	CountryRequestsEntity findByCountryCode(@Param("countryCode") String countryCode);
	
	@Query(GET_NEAREST_REQUEST)
	String getNearestRequest();
	
	@Query(GET_FURTHEST_REQUEST)
	String getFurthestRequest();

}
