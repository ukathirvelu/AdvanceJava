package org.kds.spring.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.kds.spring.jpa.domain.Employees;

public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    private EntityManager em;


    @SuppressWarnings("unchecked")
	@Override
    public List<Employees> getAllEmployees() {
        StoredProcedureQuery findByYearProcedure =
                em.createNamedStoredProcedureQuery("getAllEmployees");
        return findByYearProcedure.getResultList();
    }
}
