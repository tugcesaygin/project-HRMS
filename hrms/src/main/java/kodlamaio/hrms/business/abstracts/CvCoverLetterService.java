package kodlamaio.hrms.business.abstracts;


import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvCoverLetter;

public interface CvCoverLetterService {

	Result add(CvCoverLetter cvCoverLetter);
	Result delete(CvCoverLetter cvCoverLetter);
	
	DataResult<List<CvCoverLetter>>getAll();
	DataResult<CvCoverLetter> getById(int cvCoverLetterId);
	DataResult<List<CvCoverLetter>>getAllByJobSeekersId(int jobSeekersId);
	
}
