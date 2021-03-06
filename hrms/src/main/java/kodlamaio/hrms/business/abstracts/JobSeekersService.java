package kodlamaio.hrms.business.abstracts;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersService {

	DataResult<List<JobSeekers>>getAll();
	Result add(JobSeekers job_seekers);
	DataResult<JobSeekers>getById(int id);
	DataResult<JobSeekers> getJobSeekersByIdentityNo(String identity_no);
}
