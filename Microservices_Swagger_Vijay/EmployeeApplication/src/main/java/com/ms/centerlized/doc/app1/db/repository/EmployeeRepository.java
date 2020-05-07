package com.ms.centerlized.doc.app1.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ms.centerlized.doc.app1.db.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}