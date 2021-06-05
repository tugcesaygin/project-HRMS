package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvForeignLanguages;

public interface CvForeignLanguagesService  {
	
	Result add(CvForeignLanguages cvForeignLanguages);
	
	Result update(CvForeignLanguages cvForeignLanguages);
	
	Result delete(int id);
	
	
	DataResult<List<CvForeignLanguages>>getAllByJobSeekersId(int jobSeekersId);
	//DataResult<List<CvForeignLanguages>>getAll();
	DataResult<List<CvForeignLanguages>>getById(int id);

}
