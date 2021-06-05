package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvProgrammingSkills;

public interface CvProgrammingSkillsDao extends JpaRepository<CvProgrammingSkills, Integer> {

	CvProgrammingSkills getById(int id);
	List<CvProgrammingSkills>getAllByJobSeekersId(int jobSeekersId);
	
}
