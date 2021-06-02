package kodlamaio.hrms.business.abstracts;

import java.time.LocalDate;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

public interface AuthService {

	Result employerRegister(Employers employer );
	Result jobSeekerRegister(JobSeekers jobSeeker);
	
	
}
