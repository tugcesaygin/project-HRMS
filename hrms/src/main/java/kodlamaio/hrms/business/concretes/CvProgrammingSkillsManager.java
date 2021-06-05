package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvProgrammingSkillsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvProgrammingSkillsDao;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkills;

@Service
public class CvProgrammingSkillsManager implements CvProgrammingSkillsService {
 
	private CvProgrammingSkillsDao cvProgrammingSkillsDao;
	
	@Autowired
	public CvProgrammingSkillsManager(CvProgrammingSkillsDao cvProgrammingSkillsDao) {
		super();
		this.cvProgrammingSkillsDao = cvProgrammingSkillsDao;
		
	}

	@Override
	public Result add(CvProgrammingSkills cvProgrammingSkills) {
	this.cvProgrammingSkillsDao.save(cvProgrammingSkills);
	return new SuccessResult("Programming Skill has been added.");
	}

	@Override
	public Result update(CvProgrammingSkills cvProgrammingSkills) {
		this.cvProgrammingSkillsDao.save(cvProgrammingSkills);
		return new SuccessResult("Programming Skill has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.cvProgrammingSkillsDao.deleteById(id);
		return new SuccessResult("Programming skill has been deleted.");
	}

	

	

	@Override
	public DataResult<List<CvProgrammingSkills>> getAllByJobSeekersId(int jobSeekersId) {
		return new SuccessDataResult<List<CvProgrammingSkills>>(this.cvProgrammingSkillsDao.getAllByJobSeekersId(jobSeekersId));
	}
	
	
	
	
	
	
}
