package com.mt.rideshare.db.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mt.rideshare.db.entity.ProviderRideInfo;

@Repository
public interface TripRepository extends JpaRepository<ProviderRideInfo, Integer>{
	@Query("SELECT m FROM ProviderRideInfo m WHERE m.fromLoc= :source and m.toLoc= :destination and m.tripTime >= :searchStartTime and m.tripTime <= :searchEndTime")
	List<ProviderRideInfo> getAvailableTrips(@Param("source") String source, @Param("destination") String destination,  @Param("searchStartTime") Date searchStartTime,
			@Param("searchEndTime") Date searchEndTime);
	@Query("SELECT p FROM ProviderRideInfo p WHERE p.id = :id")
	ProviderRideInfo findByTripId(@Param("id") int id);
}
