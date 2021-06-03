package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService {

	private JobSeekersDao job_seekersDao;
	
	@Autowired
	public JobSeekersManager(JobSeekersDao job_seekersDao ) {
	super();
	this.job_seekersDao = job_seekersDao;
	}
	
	
	@Override
	public DataResult<List<JobSeekers>> getAll() {
		return new SuccessDataResult<List<JobSeekers>> (this.job_seekersDao.findAll(),"Job Seekers Listed.");
			
	}

	@Override
	public Result add(JobSeekers job_seekers) {
		this.job_seekersDao.save(job_seekers);
		return new SuccessResult("Job Seekers added.");
	}


	@Override
	public DataResult<JobSeekers> getJobSeekersByIdentityNo(String identity_no) {
		return new SuccessDataResult<JobSeekers>
		(this.job_seekersDao.findJobSeekersByIdentityNo(identity_no));
	}

}
