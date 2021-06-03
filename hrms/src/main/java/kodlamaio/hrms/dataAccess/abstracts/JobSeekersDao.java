package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer> {


	JobSeekers findJobSeekersByIdentityNo(String identity_no);
	JobSeekers getById(int id);
	
}
