package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.CvProgrammingSkills;

public interface CvProgrammingSkillsService {
	Result add(CvProgrammingSkills cvProgrammingSkills);
	Result update(CvProgrammingSkills cvProgrammingSkills);
	Result delete(int id);
	
	DataResult<List<CvProgrammingSkills>>getAllByJobSeekersId(int jobSeekersId);
	
	DataResult<List<CvProgrammingSkills>>getAll();
}
