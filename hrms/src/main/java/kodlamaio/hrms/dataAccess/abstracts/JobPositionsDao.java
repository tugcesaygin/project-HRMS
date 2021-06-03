package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions,Integer> {


	JobPositions getById(int id);

	JobPositions findByJobTitles(String jobTitles);
	

}
