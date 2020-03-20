package com.mt.unmaze.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mt.unmaze.repository.BranchRepository;

import io.swagger.unmaze.production.model.BranchMaster;;

@Service
public class BranchServiceImplementation implements BranchService {
	
	@Autowired
	private BranchRepository branchRepository;
	
	@Override
	public List<BranchMaster> getAllBranch() {
		List<com.mt.unmaze.entity.BranchMaster> entitybranch = branchRepository.findAll();
		List<BranchMaster> branches = new ArrayList<>();
		entitybranch.stream().forEach(ebranch -> {
			BranchMaster branchmaster  = new BranchMaster();
			branchmaster.setBranchMasterId(ebranch.getBranchMasterId());
			branches.add(branchmaster);
		});
		//BeanUtils.copyProperties(entitybranch, branches);
		return branches;
	}

	@Override
	public BranchMaster getBranchById(int branchId) {
		com.mt.unmaze.entity.BranchMaster entitybranch = branchRepository.findById(branchId).get();
		BranchMaster branch = new BranchMaster();
		BeanUtils.copyProperties(entitybranch, branch);
		return branch;
	}

	@Override
	public void addBranch(BranchMaster branch) {
		com.mt.unmaze.entity.BranchMaster entitybranch = new com.mt.unmaze.entity.BranchMaster();
		BeanUtils.copyProperties(branch, entitybranch);
		branchRepository.save(entitybranch);
	}

	@Override
	public void updateBranch(BranchMaster branch) {
			com.mt.unmaze.entity.BranchMaster entitybranch = new com.mt.unmaze.entity.BranchMaster();
			BeanUtils.copyProperties(branch, entitybranch);
			branchRepository.save(entitybranch);
	}

	@Override
	public void deleteBranch(int branchId) {
		branchRepository.deleteById(branchId);
		
	}

}
