package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkills;

public interface CvProgrammingSkillsService {
	Result add(CvProgrammingSkills cvProgrammingSkills);
	Result update(CvProgrammingSkills cvProgrammingSkills);
	Result delete(int id);
	
	//DataResult<List<CvProgrammingSkills>>getById(int id);
	DataResult<List<CvProgrammingSkills>>getAll();
	DataResult<List<CvProgrammingSkills>>getAllByJobSeekersId(int jobSeekersId);
	
	
}
