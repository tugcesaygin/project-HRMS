package kodlamaio.hrms.business.abstracts;



import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobSeekers;


public interface AuthService {

	Result employerRegister(Employers employer, String confirmPssword );
	Result jobSeekerRegister(JobSeekers jobSeeker, String confirmPassword);
	
	
}
