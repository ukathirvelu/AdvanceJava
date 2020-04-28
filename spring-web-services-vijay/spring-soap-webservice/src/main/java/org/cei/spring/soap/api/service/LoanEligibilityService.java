package org.cei.spring.soap.api.service;

import java.util.List;

import org.cei.spring.soap.api.loaneligibility.Ackonwledgement;
import org.cei.spring.soap.api.loaneligibility.CustomerRequest;
import org.springframework.stereotype.Service;

@Service
public class LoanEligibilityService {

	
	public Ackonwledgement checkLoanEligibility(CustomerRequest request) {
		
		Ackonwledgement ackonwledgement = new Ackonwledgement();
		List<String> mismatchCriteriaList = ackonwledgement.getCriteriaMismatch();
		
		if(!(request.getAge()>30 && request.getAge()<=60)) {
			mismatchCriteriaList.add("Person age should be between 30 and 60");
		}
		if(!(request.getYearlyIncome() > 200000)) {
			mismatchCriteriaList.add("Mininum income should be more than 200000");
		}
		if(!(request.getCibilScore() > 500)) {
			mismatchCriteriaList.add("Please try applying the loan after 6 months");
		}
		if(mismatchCriteriaList.size() > 0) {
			ackonwledgement.setApprovedAmount(0);
			ackonwledgement.setIsEligible(false);
		} else {
			ackonwledgement.setApprovedAmount(request.getYearlyIncome()/6);
			ackonwledgement.setIsEligible(true);
			mismatchCriteriaList.clear();
		}
		return ackonwledgement;
	} 
}
