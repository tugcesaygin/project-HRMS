package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.User;

public interface AuthService {


	Result employersRegister(Employers employers, String confirmPassword );
	Result jobSeekersRegister(JobSeekers job_seekers, String confirmPassword);
	
	
}
