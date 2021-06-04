package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	List<JobAdvertisement> getAll();
	JobAdvertisement getByJobAdvertId(int jobadvertId);
	
	@Query("From JobAdvert where isOpen = true and employers_id =:id")
	List<JobAdvertisement>getAllOpenJobAdvertisementByEmployers();
	
	List<JobAdvertisement>getAllOpenJobAdvertisementByCompanyName();
	
	List<JobAdvertisement>getByAllOpenJobAdvertisementByApplicationDeadline();
	
	
}
