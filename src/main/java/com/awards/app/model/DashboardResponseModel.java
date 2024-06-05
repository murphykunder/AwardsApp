package com.awards.app.model;

import java.util.Map;

public class DashboardResponseModel {

	private int totalRewardPoints;
	private Map<Integer, Map<String, Integer>> rewardPointsPerMonthPerCustomer;

	public DashboardResponseModel(int totalRewardPoints,
			Map<Integer, Map<String, Integer>> rewardPointsPerMonthPerCustomer) {
		super();
		this.totalRewardPoints = totalRewardPoints;
		this.rewardPointsPerMonthPerCustomer = rewardPointsPerMonthPerCustomer;
	}

	public int getTotalRewardPoints() {
		return totalRewardPoints;
	}

	public void setTotalRewardPoints(int totalRewardPoints) {
		this.totalRewardPoints = totalRewardPoints;
	}

	public Map<Integer, Map<String, Integer>> getRewardPointsPerMonthPerCustomer() {
		return rewardPointsPerMonthPerCustomer;
	}

	public void setRewardPointsPerMonthPerCustomer(Map<Integer, Map<String, Integer>> rewardPointsPerMonthPerCustomer) {
		this.rewardPointsPerMonthPerCustomer = rewardPointsPerMonthPerCustomer;
	}

}
