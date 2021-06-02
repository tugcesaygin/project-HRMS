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

	private JobPositionsDao positionsDao;
	
	@Autowired
	public JobPositionsManager(JobPositionsDao positionsDao) {
		super();
		this.positionsDao=positionsDao;
	}
	
	
	@Override
	public DataResult<List<JobPositions>> getAll() {
		return new SuccessDataResult<List<JobPositions>>
		(this.positionsDao.findAll(),"Job Positions Listed.");
	}


	@Override
	public Result add(JobPositions job_positions) {
		if(getByJobPositionsTitle(job_positions.getJob_titles()).getData() !=null){
			return new ErrorResult(job_positions.getJob_titles()+"This position alreadytaken.");
		}
		this.positionsDao.save(job_positions);
		return new SuccessResult("Job position is successfully added.");
	}


	@Override
	public DataResult<JobPositions> getByJobPositionsTitle(String job_titles) {
		return new SuccessDataResult<JobPositions>(this.positionsDao.findByTitle(job_titles));
	}





	
}
