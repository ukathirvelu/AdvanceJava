
package org.kds.spring.jpa.repository;


import java.util.List;

import org.kds.spring.jpa.domain.Employees;
import org.kds.spring.jpa.domain.Load;
import org.kds.spring.jpa.domain.LoadDTO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author KRArumugam
 *
 */
public interface LoadRepository extends JpaRepository<Load, Long>{

	
	LoadDTO getLoadById(Long id);
	

}
