package kodlamaio.hrms.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.Verification;

public interface VerificationDao extends JpaRepository<Verification, Integer> {

}
