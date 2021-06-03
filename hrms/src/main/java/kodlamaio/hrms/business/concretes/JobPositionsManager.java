package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionsDao;
import kodlamaio.hrms.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService  {

	private JobPositionsDao jobPositionsDao;
	
	@Autowired
	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao=jobPositionsDao;
	}
	
	
	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccessDataResult<List<JobPositions>>
		(this.jobPositionsDao.findAll(),"Job Positions Listed.");
	}


	@Override
	public Result add(JobPositions jobPositions) {
		if(getByJobPositionsTitle(jobPositions.getJobTitles()).getData() !=null){
			return new ErrorResult(jobPositions.getJobTitles()+"This position alreadytaken.");
		}
		this.jobPositionsDao.save(jobPositions);
		return new SuccessResult("Job position is successfully added.");
	}


	@Override
	public DataResult<JobPositions> getByJobPositionsTitle(String jobTitles) {
		return new SuccessDataResult<JobPositions>(this.jobPositionsDao.findByJobTitles(jobTitles));
	}





	
}
