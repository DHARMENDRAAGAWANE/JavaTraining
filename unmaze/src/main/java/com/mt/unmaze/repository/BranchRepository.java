package com.mt.unmaze.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mt.unmaze.entity.BranchMaster;;

@Repository
public interface BranchRepository extends JpaRepository<BranchMaster, Integer> {

}
