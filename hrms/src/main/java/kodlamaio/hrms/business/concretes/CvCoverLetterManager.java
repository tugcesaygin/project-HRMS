package kodlamaio.hrms.business.concretes;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CvCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvCoverLetterDao;
import kodlamaio.hrms.entities.concretes.CvCoverLetter;


@Service
public class CvCoverLetterManager implements CvCoverLetterService{

	private CvCoverLetterDao cvCoverLetterDao;
	
	@Autowired
	public CvCoverLetterManager(CvCoverLetterDao cvCoverLetterDao) {
		super();
		this.cvCoverLetterDao = cvCoverLetterDao;
	}

	@Override
	public Result add(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.save(cvCoverLetter);
		return new SuccessResult("Cover Letter has been added.");
		
	}

	@Override
	public Result delete(CvCoverLetter cvCoverLetter) {
		this.cvCoverLetterDao.delete(cvCoverLetter);
		return new SuccessResult("Cover letter has been deleted.");
	}

	

	@Override
	public DataResult<CvCoverLetter> getById(int id) {
		return new SuccessDataResult<CvCoverLetter>(this.cvCoverLetterDao.getById(id));
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAllByJobSeekersId(int jobSeekersId) {
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.getAllByJobSeekersId(jobSeekersId));
	}

	@Override
	public DataResult<List<CvCoverLetter>> getAll() {
		return new SuccessDataResult<List<CvCoverLetter>>(this.cvCoverLetterDao.findAll());
	}

	
	
	
	
	
	
	
	
}



