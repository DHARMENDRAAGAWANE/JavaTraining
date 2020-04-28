package com.mt.rideshare.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.rideshare.db.entity.ProviderRideInfo;
import com.mt.rideshare.db.entity.RideInfo;

@Repository
public interface RiderRepository extends JpaRepository<RideInfo, Integer>{

}
