package com.cei.training.hibernatebatch.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

	private Integer custId;
	
	private String custName;
	
	private String custEmail;

	private Set<BillToAddress> billToAddress;

	public Customer(Integer custId, String custName, String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custEmail = custEmail;
	}

	@Column(name = "name")
	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	@Column(name = "email")
	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	@Id
	@Column(name = "cust_id")
	@SequenceGenerator(name = "id_seq", sequenceName = "customer_seq")
    public Integer getCustId() {
        return custId;
    }

	public void setCustId(Integer custId) {
		this.custId = custId;
	}

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public Set<BillToAddress> getBillToAddress() {
		return billToAddress;
	}

	public void setBillToAddress(Set<BillToAddress> billToAddress) {
		this.billToAddress = billToAddress;
	}

}
