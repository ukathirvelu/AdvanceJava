package com.freetipscentral;

@FunctionalInterface
public interface InterestCalculator {
	float calculateInterestAmount(float amount, float interestRate);
}
