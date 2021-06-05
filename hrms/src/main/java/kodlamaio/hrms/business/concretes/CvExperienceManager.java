package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvExperienceDao;
import kodlamaio.hrms.entities.concretes.CvExperience;
@Service
public class CvExperienceManager implements CvExperienceService{

	private CvExperienceDao cvExperienceDao;
	@Autowired
	public CvExperienceManager(CvExperienceDao cvExperienceDao) {
		super();
		this.cvExperienceDao = cvExperienceDao;
		
	}

	@Override
	public Result add(CvExperience cvExperience) {
	 this.cvExperienceDao.save(cvExperience);
	 return new SuccessResult("Experience has been added.");
	}



	@Override
	public DataResult<List<CvExperience>> getAllByJobSeekersId(int jobSeekersId) {
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByJobSeekersId(jobSeekersId));
	}

	@Override
	public DataResult<List<CvExperience>> getAllByJobSeekersIdOrderByEndAtDesc(int jobSeekersId) {
		
		return new SuccessDataResult<List<CvExperience>>(this.cvExperienceDao.getAllByJobSeekersIdOrderByEndAtDesc(jobSeekersId));
	}
	
	
	
	
}
