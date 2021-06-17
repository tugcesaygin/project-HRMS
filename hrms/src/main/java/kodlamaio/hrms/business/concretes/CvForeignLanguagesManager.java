package kodlamaio.hrms.business.concretes;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CvForeignLanguagesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvForeignLanguagesDao;
import kodlamaio.hrms.entities.concretes.CvForeignLanguages;
@Service
public class CvForeignLanguagesManager implements CvForeignLanguagesService {

	private CvForeignLanguagesDao cvForeignLanguagesDao;
	@Autowired
	public CvForeignLanguagesManager(CvForeignLanguagesDao cvForeignLanguagesDao) {
		super();
		this.cvForeignLanguagesDao = cvForeignLanguagesDao;
	}
	
	@Override
	public Result add(CvForeignLanguages cvForeignLanguages) {
		this.cvForeignLanguagesDao.save(cvForeignLanguages);
		return new SuccessResult("Foreign Language has been added.");
	}
	
	@Override
	public Result update(CvForeignLanguages cvForeignLanguages) {
		this.cvForeignLanguagesDao.save(cvForeignLanguages);
		return new SuccessResult("Foreign Language has been updated.");
	}
	
	@Override
	public Result delete(int id) {
		this.cvForeignLanguagesDao.deleteById(id);
		return new SuccessResult("Foreign has been updated.");
	}
	
	@Override
	public DataResult<List<CvForeignLanguages>> getAllByJobSeekersId(int jobSeekersId) {
		return new SuccessDataResult<List<CvForeignLanguages>>(this.cvForeignLanguagesDao.getAllByJobSeekersId(jobSeekersId));
	}
	
	@Override
	public DataResult<List<CvForeignLanguages>> getAll() {
	
		return new SuccessDataResult<List<CvForeignLanguages>>(this.cvForeignLanguagesDao.findAll());
    	}
	
	@Override
	public DataResult<List<CvForeignLanguages>> getByForeignLanguagesId(int foreignLanguagesId) {
		return new SuccessDataResult<List<CvForeignLanguages>>(this.cvForeignLanguagesDao.getByForeignLanguagesId(foreignLanguagesId));
	}
	
	
	

}
