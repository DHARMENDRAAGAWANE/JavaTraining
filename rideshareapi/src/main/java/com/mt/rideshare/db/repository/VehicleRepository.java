package com.mt.rideshare.db.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mt.rideshare.db.entity.User;
import com.mt.rideshare.db.entity.Vehicalinfo;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicalinfo, Integer> {

	List<Vehicalinfo> findByOwnerid(@Param("ownerId") User ownerId);
}
