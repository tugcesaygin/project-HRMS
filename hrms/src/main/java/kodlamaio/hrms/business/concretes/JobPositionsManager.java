package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
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
	public Result add(JobPositions jobPositions) {
		this.positionsDao.save(jobPositions);
		return new SuccessResult("Job Position added.");
	}

	
}
