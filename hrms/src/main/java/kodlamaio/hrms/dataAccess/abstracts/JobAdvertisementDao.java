package kodlamaio.hrms.dataAccess.abstracts;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementDao extends JpaRepository<JobAdvertisement, Integer> {

	
	
	JobAdvertisement getByJobadvertId(int jobadvertId);
	
	
	List<JobAdvertisement>getByIsOpenAndEmployers_Id(boolean isOpen, int employerId);
	
	//List<JobAdvertisement>getByIsOpenAndCompanyName();
	
	List<JobAdvertisement>getByIsOpenAndApplicationDeadline(boolean isOpen, LocalDate applicationDeadline);
	
	
}
