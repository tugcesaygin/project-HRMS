package kodlamaio.hrms.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.core.entities.Base;


public interface BaseDao extends JpaRepository<Base, Integer> {

	Base findById(Base base);
	Base findByEmail(String email);
	
}
