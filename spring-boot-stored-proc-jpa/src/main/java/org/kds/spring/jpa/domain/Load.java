package org.kds.spring.jpa.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.Data;


@NamedNativeQueries(
	    value={
	            // cast is used for Hibernate, to prevent No Dialect mapping for JDBC type: 1111
	            @NamedNativeQuery(
	                  name = "Load.get_load",
	                 query = "select get_load_fn(?)",
	                 resultClass = Employees.class
	            )
	     }
		)	            
@Entity
@Table(name = "load", schema = "public")
@Data	  
public class Load implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 2888335902997364772L;

	@Id
	@Column(name = "load_id")
	public Long id;
	
	@Column(name = "load_description")
	public String loadDescription;
	
	@Column(name = "customer_id")
	public Long customerId;
	
	@Column(name = "customer_address_id")
	public Long customerAddressId;
	
	@Column(name = "load_status_id")
	public Long loadStatusId;
	
	@Column(name = "sales_rep_id")
	public Long salesRepId;
	
	@Column(name = "carrier_id")
	public Long carrieId;
	
	@Column(name = "equipment_id")
	public Long equipmentId;
	
	@Column(name = "total_revenue")
	public BigDecimal totalRevenue;
	
	@Column(name = "total_cost")
	public BigDecimal totalCost;
	
	@Column(name = "max_rate")
	public BigDecimal maxRate;
	
	@Column(name = "target_rate")
	public BigDecimal targetRate;
	
	@Column(name = "load_size")
	public String loadSize;
	
	@Column(name = "trip_mileage")
	public BigDecimal tripMileage;

	
	public Load() {
		   
	   }
	
	public Load(long id, String loadDescription, long customerId, long customerAddressId, long loadStatusId,
			long salesRepId, long carrieId, long equipmentId) {
		super();
		this.id = id;
		this.loadDescription = loadDescription;
		this.customerId = customerId;
		this.customerAddressId = customerAddressId;
		this.loadStatusId = loadStatusId;
		this.salesRepId = salesRepId;
		this.carrieId = carrieId;
		this.equipmentId = equipmentId;
	}

	@Override
	public String toString() {
		return "Load [id=" + id + ", loadDescription=" + loadDescription + ", customerId=" + customerId
				+ ", customerAddressId=" + customerAddressId + ", loadStatusId=" + loadStatusId + ", salesRepId="
				+ salesRepId + ", carrieId=" + carrieId + ", equipmentId=" + equipmentId + "]";
	}

}
