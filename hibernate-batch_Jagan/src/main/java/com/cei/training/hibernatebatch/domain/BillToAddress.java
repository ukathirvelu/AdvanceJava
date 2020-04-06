package com.cei.training.hibernatebatch.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "bill_to_addr")
@Data
public class BillToAddress {

	private Integer billToAddrId;

	private String billToAddrName;

	public Customer customer;

	@Id
	@Column(name = "bill_to_addr_id")
	@SequenceGenerator(name = "id_seq", sequenceName = "bill_to_addr_seq")
	public Integer getBillToAddrId() {
		return billToAddrId;
	}

	@Column(name = "name")
	public String getBillToAddrName() {
		return billToAddrName;
	}

	public void setBillToAddrName(String billToAddrName) {
		this.billToAddrName = billToAddrName;
	}

	public void setBillToAddrId(Integer billToAddrId) {
		this.billToAddrId = billToAddrId;
	}

	@ManyToOne
	@JoinColumn(name = "cust_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BillToAddress(Integer billToAddrId, String billToAddrName, Customer customer) {
		super();
		this.billToAddrId = billToAddrId;
		this.billToAddrName = billToAddrName;
		this.customer = customer;
	}

}
