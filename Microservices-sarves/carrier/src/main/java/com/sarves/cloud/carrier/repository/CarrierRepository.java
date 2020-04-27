package com.sarves.cloud.carrier.repository;

import com.sarves.cloud.carrier.domain.Carrier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrierRepository extends JpaRepository<Carrier, Long> {
}
