package kodlamaio.hrms.business.abstracts;


import java.time.LocalDate;
import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

public interface JobAdvertisementService {


	
	DataResult<JobAdvertisement> getByJobadvertId(int jobadvertId);
	
	Result add(JobAdvertisement jobAdvertisement);
	Result update(JobAdvertisement jobAdvertisement);
	Result delete(int jobadvertId);
	Result changeOpenToClose(int jobadvertId);


	DataResult<List<JobAdvertisement>>getByIsOpenAndEmployers_Id(boolean isOpen, int employerId);
	
	//DataResult<List<JobAdvertisement>>getByIsOpenAndCompanyName();
	
	DataResult<List<JobAdvertisement>>getByIsOpenAndApplicationDeadline(boolean isOpen , LocalDate applicationDeadline);
	
}
