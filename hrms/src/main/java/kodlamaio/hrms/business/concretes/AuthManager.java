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
	private SystemEmployeeService systemEmployeeService;
	private UserService userService;
	private MernisValidationService mernisValidationService;
	private SimulatedMernisService simulatedMernisService;
	private VerificationService verificationService;
	private UserDao userDao;

	@Autowired
	public AuthManager(  
			EmployerService employerService, JobSeekersService jobSeekersService ,VerificationCodeService verificationCodeService, 
			UserService userService, MernisValidationService mernisValidationService, SystemEmployeeService systemEmployeeService,
			SimulatedMernisService simulatedMernisService, VerificationService verificationService , UserDao userDao) {
		
		super();
		this.systemEmployeeService=systemEmployeeService;
		this.employerService=employerService;
		this.jobSeekersService=jobSeekersService;
		this.verificationCodeService=verificationCodeService;
		this.userService=userService;
		this.mernisValidationService=mernisValidationService;
		this.simulatedMernisService=simulatedMernisService;
		this.verificationService=verificationService;
		this.userDao=userDao;
		
	}
	
	
	
	@Override
	public Result employersRegister(Employers employers,String confirmPassword) {
		 if(!CheckIfFullInfoForEmployers(employers)) {
			 return new ErrorResult("Missing information.");
		 }
		 if(!CheckIfEmailandDomainSame(employers.getEmail(), employers.getWebSite())) {
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
	public Result jobSeekersRegister(JobSeekers jobSeekers, String confirmPassword) {
		if(!CheckIfFullInfoForJobSeekers(jobSeekers, confirmPassword)) {
			return new ErrorResult("Missing information.");
		}
		if(!verificatePerson(jobSeekers.getIdentityNo(), jobSeekers.getName(),jobSeekers.getLastName(),
				jobSeekers.getYearOfBirth())==false) {
			return new ErrorResult("Identity No couldn't be verified.");
		}
		if(!CheckIfIdentityNoExist(jobSeekers.getIdentityNo())) {
			return new ErrorResult("You have entered missing information. Please fill in all fields.");
		}
		if (!CheckIfEmailExist(jobSeekers.getEmail())) {
			return new ErrorResult(jobSeekers.getEmail() + " already exists.");
		}
		
		jobSeekersService.add(jobSeekers);
		String code = verificationService.sendCode();
		verificationCodeRecord(code, jobSeekers.getId(), jobSeekers.getEmail());
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
		if(this.jobSeekersService.getJobSeekersByIdentityNo(identityNo).getData()==null) {
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
		if(employers.getCompanyName()!=null && employers.getWebSite()!= null&&
				employers.getEmail()!=null && employers.getTelNo()!=null&&
				employers.getPassword()!=null) {
			return true;
			}
			return false;
	}
	
	private boolean CheckIfEmailandDomainSame(String email,String webSite) {
		String[] emailArr = email.split("@", 2);
		String domain = webSite.substring(4, webSite.length());

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
