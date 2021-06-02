package kodlamaio.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobPositions;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.Verification;

@Service
public class AuthManager implements AuthService{

	private User user;
	private Employers employers;
	private JobSeekers jobSeekers;
	private Verification verificationCode;
	private EmployerService employerService;
	private JobSeekersService jobSeekersService;
	private VerificationService verificationService;
	private SystemEmployee systemEmployee;
	private SystemEmployeeService employeeService;
	private JobPositions jobPositions;
	@Autowired
	public AuthManager(User user , Employers employers, Verification verificationCode,JobSeekers jobSeekers, 
			EmployerService employerService, JobSeekersService jobSeekersService ,VerificationService verificationService, 
			SystemEmployee systemEmployee, JobPositions jobPositions) {
		super();
		this.employers=employers;
		this.employerService=employerService;
		this.jobSeekers=jobSeekers;
		this.jobSeekersService=jobSeekersService;
		this.user=user;
		this.verificationCode=verificationCode;
		this.verificationService=verificationService;
		this.systemEmployee=systemEmployee;
		this.jobPositions=jobPositions;
		
	}
	
	
	
	@Override
	public Result employerRegister(Employers employer) {
		 
	
		
		
		return null;
	}

	
	
	
	
	
	@Override
	public Result jobSeekerRegister(JobSeekers jobSeeker) {
		
		return null;
	}



	
	
	
}
