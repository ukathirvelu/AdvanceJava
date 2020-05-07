package com.ms.centerlized.doc.app2.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ms.centerlized.doc.app2.db.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
