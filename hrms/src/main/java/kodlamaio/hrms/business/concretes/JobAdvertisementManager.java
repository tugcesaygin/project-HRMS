package kodlamaio.hrms.business.concretes;


import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	private JobAdvertisementDao jobAdvertisementDao;
	
	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao) {
		super();
		this.jobAdvertisementDao= jobAdvertisementDao;
	}
	
	


	@Override
	public Result add(JobAdvertisement jobAdvertisement) {
		if(!CheckAllInfo(jobAdvertisement)) {
			return new ErrorResult("Missing information!");
		}
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Job Advertisements has been added!");
		
	}

	@Override
	public Result update(JobAdvertisement jobAdvertisement) {
		this.jobAdvertisementDao.save(jobAdvertisement);
		return new SuccessResult("Jub Advertisements has been updated!");
	}

	@Override
	public Result delete(int jobadvertId) {
		this.jobAdvertisementDao.deleteById(jobadvertId);
		return new SuccessResult("Job Advertisement has been deleted.");
	}

	@Override
	public Result changeOpenToClose(int jobadvertId) {
	
		if(getByJobadvertId(jobadvertId)==null) {
			return new ErrorResult("Job Advert does not exist.");
		}
		if(getByJobadvertId(jobadvertId).getData().isOpen()==false) {
			return new ErrorResult("This job advert has been removed. ");
		}
		JobAdvertisement jobAdvertisement = getByJobadvertId(jobadvertId).getData();
		jobAdvertisement.setOpen(false);
		update(jobAdvertisement);
		return new SuccessResult("Job Advertisement has been successfully closed.");
	}

	@Override
	public DataResult<List<JobAdvertisement>> getByIsOpenAndEmployers_Id(boolean isOpen, int employerId) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsOpenAndEmployers_Id(isOpen, employerId));
		
	}

	//@Override
//	public DataResult<List<JobAdvertisement>> getByIsOpenByCompanyName() {
//		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsOpenByCompanyName());
	
	//}

	@Override
	public DataResult<List<JobAdvertisement>>getByIsOpenAndApplicationDeadline(boolean isOpen , LocalDate applicationDate) {
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.getByIsOpenAndApplicationDeadline(isOpen, applicationDate));
	}




	
	private boolean CheckAllInfo(JobAdvertisement jobAdvertisement) {
		if(jobAdvertisement.getJobPositions()!= null && jobAdvertisement.getCompanyName()!=null
				&& jobAdvertisement.getOpenPositions()!=0 &&jobAdvertisement.getApplicationDeadline()!=null ) {
			return true;
		}
		return false;
	}




	@Override
	public DataResult<JobAdvertisement> getByJobadvertId(int jobadvertId) {
		return new SuccessDataResult<JobAdvertisement>(this.jobAdvertisementDao.getByJobadvertId(jobadvertId));
	
	}





	
}
