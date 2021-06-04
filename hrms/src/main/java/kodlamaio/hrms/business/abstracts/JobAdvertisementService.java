package kodlamaio.hrms.business.abstracts;


import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {

	DataResult<List<JobAdvertisement>> getAll();
	
	DataResult<JobAdvertisement> getByJobAdvertId(int jobadvertId);
	
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int jobadvertId);
	Result changeOpenToClose(int jobadvertId);


	DataResult<List<JobAdvertisement>>getAllOpenJobAdvertisementByEmployers();
	
	DataResult<List<JobAdvertisement>>getAllOpenJobAdvertisementByCompanyName();
	
	DataResult<List<JobAdvertisement>>getByAllOpenJobAdvertisementByApplicationDeadline();
	
}
