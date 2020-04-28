package org.cei.spring.soap.api.endpoint;

import org.cei.spring.soap.api.loaneligibility.Ackonwledgement;
import org.cei.spring.soap.api.loaneligibility.CustomerRequest;
import org.cei.spring.soap.api.service.LoanEligibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoanEligibilityEndpoint {
	
	private static final String NAMESPACE = "http://www.cei.org/spring/soap/api/LoanEligibility";
	
	@Autowired
	private LoanEligibilityService loanEligibilityService;
	
	@PayloadRoot(namespace = NAMESPACE, localPart = "CustomerRequest")
	@ResponsePayload
	public Ackonwledgement getLoanStatus(@RequestPayload CustomerRequest request) {
		
		return loanEligibilityService.checkLoanEligibility(request);
	}
}
