package com.awards.app.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.awards.app.entity.Transaction;
import com.awards.app.model.DashboardResponseModel;
import com.awards.app.service.AwardsService;

@RestController
@RequestMapping("/awards")
public class AwardsController {
	
	@Autowired
	private AwardsService awardsService;
	
	@GetMapping("/")
	public ResponseEntity<List<Transaction>> getAllRewards() {
		return new ResponseEntity<List<Transaction>>(awardsService.getAllRewards(), HttpStatus.OK);
	}
	
	@GetMapping("/{customerName}")
	public ResponseEntity<List<Transaction>> getRewardForCustomer(@PathVariable String customerName) {
		List<Transaction> transactions = awardsService.getRewardByCustomer(customerName);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@GetMapping("/month/{monthValue}")
	public ResponseEntity<List<Transaction>> getRewardForMonth(@PathVariable int monthValue) {
		List<Transaction> transactions = awardsService.getRewardByMonth(monthValue);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}
	
	@GetMapping("/{customerName}/month/{monthValue}")
	public ResponseEntity<List<Transaction>> getRewardForCustomerForMonth(@PathVariable String customerName, @PathVariable int monthValue) {
		List<Transaction> transactions = awardsService.getRewardForCustomerForMonth(customerName, monthValue);
		return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
	}

	@GetMapping("/dashboard")
	public ResponseEntity<DashboardResponseModel> getDashBoard() {
		Map<Integer, Map<String, Integer>> rewardPointsPerCustomerPerMonth = awardsService.calculateRewardPointsPerCustomerPerMonth();
		int totalRewardPoints = awardsService.calculateTotalRewardPoints();
		DashboardResponseModel dashboardResponseModel = new DashboardResponseModel(totalRewardPoints,
				rewardPointsPerCustomerPerMonth);
		return new ResponseEntity<DashboardResponseModel>(dashboardResponseModel, HttpStatus.OK);
	}
	
}
