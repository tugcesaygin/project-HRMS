package kodlamaio.hrms.business.abstracts;

import java.time.LocalDateTime;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.CvEducation;


public interface CvEducationService {


	Result add(CvEducation cvEducation);
	
	DataResult<List<CvEducation>>getAll();
	
	DataResult<List<CvEducation>>getAllByJobSeekersId(int jobSeekersId);
	
	DataResult<List<CvEducation>>getAllByJobSeekersIdOrderByGraduationDateDesc(LocalDateTime jobSeekersId);
	
}
