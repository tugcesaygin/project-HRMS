package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.business.abstracts.VerificationCodeService;
import kodlamaio.hrms.core.utilities.adaptors.MernisValidationService;
import kodlamaio.hrms.core.utilities.adaptors.SimulatedMernisService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobPositions;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.User;
import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service

public class AuthManager implements AuthService{

	
	
	private EmployerService employerService;
	private JobSeekersService jobSeekersService;
	private VerificationCodeService verificationCodeService;
	
	private SystemEmployeeService employeeService;

	private UserService userService;
	private MernisValidationService mernisValidationService;
	private SimulatedMernisService mernisService;
	private VerificationService verificationService;
	private UserDao usersDao;

	@Autowired
	public AuthManager(  
			EmployerService employerService, JobSeekersService jobSeekersService ,VerificationCodeService verificationCodeService, 
			UserService userService, MernisValidationService mernisValidationService,
			SimulatedMernisService mernisService, VerificationService verificationService , UserDao usersDao) {
		
		super();
		
		this.employerService=employerService;
		
		this.jobSeekersService=jobSeekersService;
	
	
		this.verificationCodeService=verificationCodeService;


		this.userService=userService;
		this.mernisValidationService=mernisValidationService;
		this.mernisService=mernisService;
		this.verificationService=verificationService;
		
	}
	
	
	
	@Override
	public Result employersRegister(Employers employers,String confirmPassword) {
		 if(!CheckIfFullInfoForEmployers(employers)) {
			 return new ErrorResult("Missing information.");
		 }
		 if(!CheckIfEmailandDomainSame(employers.getEmail(), employers.getWeb_site())) {
			 return new ErrorResult("Your e-mail adress don't have the same domain as your Web Site. ");
		 }
		 if(!CheckIfEmailExist(employers.getEmail())) {
			 return new ErrorResult("This e-mail is invalid");
		 }
		 if(!checkIfEqualPasswordAndConfirmPassword(employers.getPassword(), confirmPassword)) {
			 return new ErrorResult("Passwords don't match. Please make sure you enter the same password.");
		 }
	
		employerService.add(employers);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employers.getId(), employers.getEmail());
		return new SuccessResult("Registration has been successfully completed");
		 
		
	}

	
	
	
	
	
	@Override
	public Result jobSeekersRegister(JobSeekers job_seekers, String confirmPassword) {
		if(!CheckIfFullInfoForJobSeekers(job_seekers, confirmPassword)) {
			return new ErrorResult("Missing information.");
		}
		if(!verificatePerson(job_seekers.getIdentity_no(), job_seekers.getName(),job_seekers.getLast_name(),
				job_seekers.getYear_of_birth())==false) {
			return new ErrorResult("Identity No couldn't be verified.");
		}
		if(!CheckIfIdentityNoExist(job_seekers.getIdentity_no())) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		if (!CheckIfEmailExist(job_seekers.getEmail())) {
			return new ErrorResult(job_seekers.getEmail() + " already exists.");
		}
		
		jobSeekersService.add(job_seekers);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, job_seekers.getId(), job_seekers.getEmail());
		return new SuccessResult("Registration has been successfully completed");

	}


	
	

	private boolean CheckIfEmailExist(String email) {
		
		if(this.userService.getUserByEmail(email).getData()==null) {
			return true;
		}
		return false;
	}
	
	private boolean verificatePerson(String identity_no ,String name ,String last_name , LocalDate year_of_birth) {
	
		if(mernisValidationService.CheckIfRealPerson(identity_no, name, last_name, year_of_birth)) {
			System.out.println("Person exist.");
			return true;
		}
		System.out.println("Error : Person is not found.");
		return false;
		
	}
	
	private boolean CheckIfIdentityNoExist(String identity_no) {
		if(this.jobSeekersService.getJobSeekersByIdentityNo(identity_no).getData()==null) {
			return true;
		}
		return false;
		
	}
	
	private boolean CheckIfFullInfoForJobSeekers(JobSeekers job_seekers , String confirmPassword) {
		if(job_seekers.getName()!=null && job_seekers.getLast_name()!=null && job_seekers.getIdentity_no()!= null&& 
				job_seekers.getYear_of_birth()!=null&& job_seekers.getEmail()!=null&& job_seekers.getPassword()!=null
				&& confirmPassword !=null) {
			return true;
		}
		return false;
	}
	
	private boolean CheckIfFullInfoForEmployers(Employers employers ) {
		if(employers.getCompany_name()!=null && employers.getWeb_site()!= null&&
				employers.getEmail()!=null && employers.getTel_no()!=null&&
				employers.getPassword()!=null) {
			return true;
			}
			return false;
	}
	
	private boolean CheckIfEmailandDomainSame(String email,String web_site) {
		String[] emailArr = email.split("@", 2);
		String domain = web_site.substring(4, web_site.length());

		if (emailArr[1].equals(domain)) {

			return true;
		}

		return false;
	}
	
	private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {

		if (!password.equals(confirmPassword)) {
			return false;
		}

		return true;
	}
	
		private void verificationCodeRecord(String code, int id, String email) {
		
		VerificationCode verificationCode = new VerificationCode(id, code, false);
		this.verificationCodeService.add(verificationCode);
		System.out.println("Verification code has been sent to " + email );
	
	}



}
