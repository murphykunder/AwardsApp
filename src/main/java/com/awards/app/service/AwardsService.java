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
		transaction = Arrays.asList(new Transaction("Levin", 26, LocalDate.parse("2023-05-04"), 0),
				new Transaction("Levin", 105, LocalDate.parse("2023-05-02"), 0),
				new Transaction("Lois", 117, LocalDate.parse("2023-05-12"), 0),
				new Transaction("Levin", 179, LocalDate.parse("2023-04-05"), 0),
				new Transaction("Jackson", 33, LocalDate.parse("2023-05-19"), 0),
				new Transaction("Murphy", 123, LocalDate.parse("2023-04-20"), 0),
				new Transaction("Haley", 84, LocalDate.parse("2023-05-04"), 0),
				new Transaction("Jackson", 150, LocalDate.parse("2023-03-22"), 0),
				new Transaction("Murphy", 85, LocalDate.parse("2023-03-08"), 0),
				new Transaction("Murphy", 172, LocalDate.parse("2023-03-28"), 0),
				new Transaction("Reece", 63, LocalDate.parse("2023-05-25"), 0),
				new Transaction("Murphy", 111, LocalDate.parse("2023-04-06"), 0),
				new Transaction("Murphy", 159, LocalDate.parse("2023-04-13"), 0),
				new Transaction("Levin", 84, LocalDate.parse("2023-04-11"), 0),
				new Transaction("Jackson", 112, LocalDate.parse("2023-03-29"), 0),
				new Transaction("Levin", 167, LocalDate.parse("2023-05-20"), 0),
				new Transaction("Jackson", 157, LocalDate.parse("2023-04-08"), 0),
				new Transaction("Jackson", 127, LocalDate.parse("2023-04-09"), 0),
				new Transaction("Jackson", 48, LocalDate.parse("2023-03-09"), 0),
				new Transaction("Jackson", 74, LocalDate.parse("2023-03-15"), 0)

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
		return transaction.stream()
				.filter((t) -> t.getTransactionMonth() == monthValue && t.getCustomerName().equals(customerName))
				.collect(Collectors.toList());

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
