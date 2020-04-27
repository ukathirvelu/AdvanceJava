package com.sarves.cloud.load.repository;

import com.sarves.cloud.load.domain.Load;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadRepository extends JpaRepository<Load, Long> {
}
