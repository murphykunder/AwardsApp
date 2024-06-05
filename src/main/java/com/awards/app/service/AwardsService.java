package com.awards.app.service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import com.awards.app.entity.Transaction;

import jakarta.annotation.PostConstruct;

@Service
public class AwardsService {

	private static List<Transaction> transaction;
	static {
		transaction = Arrays.asList(

				new Transaction("Mini", 80, LocalDate.now().minusMonths(4).minusDays(1)),
				new Transaction("Mickey", 250, LocalDate.now().minusMonths(4).minusDays(2)),
				new Transaction("Mini", 120, LocalDate.now().minusMonths(4).minusDays(3)),

				new Transaction("Mickey", 180, LocalDate.now().minusMonths(3).minusDays(4)),
				new Transaction("Donald", 100, LocalDate.now().minusMonths(3).minusDays(3)),
				new Transaction("Mickey", 50, LocalDate.now().minusMonths(3).minusDays(1)),
				new Transaction("Donald", 500, LocalDate.now().minusMonths(3).minusDays(2)),

				new Transaction("Mini", 140, LocalDate.now().minusMonths(2).minusDays(4)),
				new Transaction("Tom", 80, LocalDate.now().minusMonths(2).minusDays(3)),
				new Transaction("Donald", 140, LocalDate.now().minusMonths(2).minusDays(2)),
				new Transaction("Tom", 30, LocalDate.now().minusMonths(2).minusDays(1))

		);
	}

	@PostConstruct
	public void init() {
		transaction.stream().forEach(t -> calculateRewardPoint(t));
	}

	public List<Transaction> getAllRewards() {
		return transaction;
	}

	public List<Transaction> getRewardByCustomer(String customerName) {
		return transaction.stream().filter((t) -> t.getCustomerName().equals(customerName))
				.collect(Collectors.toList());
	}

	public List<Transaction> getRewardByMonth(int monthValue) {
		return transaction.stream().filter((t) -> t.getTransactionMonth() == monthValue).collect(Collectors.toList());
	}
	
	public List<Transaction> getRewardForCustomerForMonth(String customerName, int monthValue) {
		return transaction.stream().filter((t) -> t.getTransactionMonth() == monthValue && t.getCustomerName().equals(customerName)).collect(Collectors.toList());

	}

	public void calculateRewardPoint(Transaction transaction) {
		int amount = transaction.getAmount();
		if (amount > 100) {
			int p1 = amount - 100;
			int points = (p1 * 2) + (1 * 50);
			transaction.setRewardPoints(points);

		} else if (amount > 50 && amount <= 100) {
			transaction.setRewardPoints(1 * (amount - 50));
		}
	}

	public Map<Integer, Map<String, Integer>> calculateRewardPointsPerCustomerPerMonth() {
		return transaction.stream().collect(Collectors.groupingBy(Transaction::getTransactionMonth, Collectors
				.groupingBy(Transaction::getCustomerName, Collectors.summingInt(Transaction::getRewardPoints))));
	}

	public int calculateTotalRewardPoints() {
		return transaction.stream().mapToInt((t) -> t.getRewardPoints()).sum();
	}



}
