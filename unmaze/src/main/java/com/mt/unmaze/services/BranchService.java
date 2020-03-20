package com.mt.unmaze.services;

import java.util.List;

import io.swagger.unmaze.production.model.BranchMaster;

public interface BranchService {
	
	public List<BranchMaster> getAllBranch();
	
	public BranchMaster getBranchById(int branchId);
	
	public void addBranch(BranchMaster branch);
	
	public void updateBranch(BranchMaster branch);
	
	public void deleteBranch(int branchId);
}
