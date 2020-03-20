package com.mt.unmaze.controllers;

import java.util.List;

import org.dom4j.Branch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.mt.unmaze.services.BranchServiceImplementation;

import io.swagger.unmaze.production.api.BranchApi;
import io.swagger.unmaze.production.model.BranchMaster;

//import javax.validation.Valid;

@Controller
public class BranchApiController implements BranchApi {
	
	@Autowired
	private BranchServiceImplementation branchService;

	public ResponseEntity<List<BranchMaster>> getAllBranch() {
		return new ResponseEntity<List<BranchMaster>>(branchService.getAllBranch(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<Branch> getBranchById(int branchId) {
		branchService.getBranchById(branchId);
		return new ResponseEntity<Branch>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> addBranch(BranchMaster body) {
		branchService.addBranch(body);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> updateBranch(BranchMaster branch) {
		branchService.updateBranch(branch);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	public ResponseEntity<Void> deleteBranch(int branchId) {
		branchService.deleteBranch(branchId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
