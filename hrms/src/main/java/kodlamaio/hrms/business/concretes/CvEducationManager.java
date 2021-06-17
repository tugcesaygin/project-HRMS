package kodlamaio.hrms.business.concretes;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvEducationDao;
import kodlamaio.hrms.entities.concretes.CvEducation;


@Service
public class CvEducationManager implements CvEducationService {

	private CvEducationDao cvEducationDao;
	@Autowired
	public CvEducationManager(CvEducationDao cvEducationDao) {
		super();
		this.cvEducationDao = cvEducationDao;
	}

	@Override
	public Result add(CvEducation cvEducation) {
		this.cvEducationDao.save(cvEducation);
		return new SuccessResult("School has been added.");
	}



	@Override
	public DataResult<List<CvEducation>> getAllByJobSeekersId(int jobSeekersId) {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByJobSeekersId(jobSeekersId));
	}

	@Override
	public DataResult<List<CvEducation>> getAllByJobSeekersIdOrderByGraduationDateDesc(LocalDateTime jobSeekersId) {
		
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.getAllByJobSeekersIdOrderByGraduationDateDesc(jobSeekersId));
	}

	@Override
	public DataResult<List<CvEducation>> getAll() {
		return new SuccessDataResult<List<CvEducation>>(this.cvEducationDao.findAll());
	}
	
	
}
