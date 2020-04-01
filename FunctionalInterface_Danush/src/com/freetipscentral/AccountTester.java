package com.freetipscentral;

public class AccountTester {
	public static void main(String args[]) {
		
		float amount = 20000f;
		float interestRate = 5f;
		Account account = new Account();
		
		
		account.setInterestCalculator(new InterestCalculator() {
			
			@Override
			public float calculateInterestAmount(float amount, float interestRate) {
				// TODO Auto-generated method stub
				return amount * interestRate;
			}
		});
		
		account.setInterestCalculator (
			(amt, intRate) -> amt * intRate
		);
		
		System.out.println(account.getInterestCalculator().calculateInterestAmount(amount, interestRate));
	}
}
