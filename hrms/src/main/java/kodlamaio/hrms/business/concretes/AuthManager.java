package kodlamaio.hrms.business.concretes;

import java.time.LocalDate;

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
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobPositions;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.User;

import kodlamaio.hrms.entities.concretes.VerificationCode;

@Service
public class AuthManager implements AuthService{

	private User user;
	private Employers employers;
	private JobSeekers jobSeekers;
	private VerificationCode verificationCode;
	private EmployerService employerService;
	private JobSeekersService jobSeekersService;
	private VerificationCodeService verificationCodeService;
	private SystemEmployee systemEmployee;
	private SystemEmployeeService employeeService;
	private JobPositions jobPositions;
	private UserService userService;
	private MernisValidationService mernisValidationService;
	private SimulatedMernisService mernisService;
	private VerificationService verificationService;
	

	@Autowired
	public AuthManager(User user , Employers employers, VerificationCode verificationCode,JobSeekers jobSeekers, 
			EmployerService employerService, JobSeekersService jobSeekersService ,VerificationCodeService verificationCodeService, 
			SystemEmployee systemEmployee, JobPositions jobPositions, UserService userService, MernisValidationService mernisValidationService,
			SimulatedMernisService mernisService, VerificationService verificationService) {
		
		super();
		this.employers=employers;
		this.employerService=employerService;
		this.jobSeekers=jobSeekers;
		this.jobSeekersService=jobSeekersService;
		this.user=user;
		this.verificationCode=verificationCode;
		this.verificationCodeService=verificationCodeService;
		this.systemEmployee=systemEmployee;
		this.jobPositions=jobPositions;
		this.userService=userService;
		this.mernisValidationService=mernisValidationService;
		this.mernisService=mernisService;
		this.verificationService=verificationService;
		
	}
	
	
	
	@Override
	public Result employerRegister(Employers employer,String confirmPassword) {
		 if(!CheckIfFullInfoForEmployers(employer)) {
			 return new ErrorResult("Missing information.");
		 }
		 if(!CheckIfEmailandDomainSame(employer.getEmail(), employer.getWebSite())) {
			 return new ErrorResult("Your e-mail adress don't have the same domain as your Web Site. ");
		 }
		 if(!CheckIfEmailExist(employer.getEmail())) {
			 return new ErrorResult("This e-mail is invalid");
		 }
		 if(!checkIfEqualPasswordAndConfirmPassword(employer.getPassword(), confirmPassword)) {
			 return new ErrorResult("Passwords don't match. Please make sure you enter the same password.");
		 }
	
		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, employer.getId(), employer.getEmail());
		return new SuccessResult("Registration has been successfully completed");
		 
		
	}

	
	
	
	
	
	@Override
	public Result jobSeekerRegister(JobSeekers jobSeeker, String confirmPassword) {
		if(!CheckIfFullInfoForJobSeekers(jobSeeker, confirmPassword)) {
			return new ErrorResult("Missing information.");
		}
		if(!verificatePerson(jobSeeker.getIdentityNo(), jobSeeker.getName(),jobSeeker.getLastName(),
				jobSeeker.getYearOfBirth())==false) {
			return new ErrorResult("Identity No couldn't be verified.");
		}
		if(!CheckIfIdentityNoExist(jobSeeker.getIdentityNo())) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		if (!CheckIfEmailExist(jobSeeker.getEmail())) {
			return new ErrorResult(jobSeekers.getEmail() + " already exists.");
		}
		
		jobSeekersService.add(jobSeeker);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobSeeker.getId(), jobSeeker.getEmail());
		return new SuccessResult("Registration has been successfully completed");

	}


	
	

	private boolean CheckIfEmailExist(String email) {
		
		if(this.userService.getUserByEmail(email).getData()==null) {
			return true;
		}
		return false;
	}
	
	private boolean verificatePerson(String identityNo ,String name ,String lastName , LocalDate yearOfBirth) {
	
		if(mernisValidationService.CheckIfRealPerson(identityNo, name, lastName, yearOfBirth)) {
			System.out.println("Person exist.");
			return true;
		}
		System.out.println("Error : Person is not found.");
		return false;
		
	}
	
	private boolean CheckIfIdentityNoExist(String identityNo) {
		if(this.jobSeekersService.getJobseekerByIdentityNo(identityNo).getData()==null) {
			return true;
		}
		return false;
		
	}
	
	private boolean CheckIfFullInfoForJobSeekers(JobSeekers jobSeekers , String confirmPassword) {
		if(jobSeekers.getName()!=null && jobSeekers.getLastName()!=null && jobSeekers.getIdentityNo()!= null&& 
				jobSeekers.getYearOfBirth()!=null&& jobSeekers.getEmail()!=null&& jobSeekers.getPassword()!=null
				&& confirmPassword !=null) {
			return true;
		}
		return false;
	}
	
	private boolean CheckIfFullInfoForEmployers(Employers employers ) {
		if(employers.getCompany_name()!=null && employers.getWebSite()!= null&&
				employers.getEmail()!=null && employers.getTelNo()!=null&&
				employers.getPassword()!=null) {
			return true;
			}
			return false;
	}
	
	private boolean CheckIfEmailandDomainSame(String email,String webSite) {
		String[] emailArr = email.split("@", 2);
		if((emailArr[1].equals(employers.getWebSite().contains(webSite.subSequence(4,webSite.length()))))) {
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
