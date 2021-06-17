package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvExperience;

public interface CvExperienceDao extends JpaRepository<CvExperience, Integer> {

	CvExperience getByExperienceId(int experienceId);
	List<CvExperience>getAllByJobSeekersId(int jobSeekersId);
	List<CvExperience>getAllByJobSeekersIdOrderByEndAtDesc(int jobSeekersId);

	
	
}
