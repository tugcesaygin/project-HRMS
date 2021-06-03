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

	private User users;
	private Employers employers;
	private JobSeekers job_seekers;
	private VerificationCode verificationCode;
	private EmployerService employerService;
	private JobSeekersService jobSeekersService;
	private VerificationCodeService verificationCodeService;
	private SystemEmployee system_employee;
	private SystemEmployeeService employeeService;
	private JobPositions job_positions;
	private UserService userService;
	private MernisValidationService mernisValidationService;
	private SimulatedMernisService mernisService;
	private VerificationService verificationService;
	

	@Autowired
	public AuthManager(User users , Employers employers, VerificationCode verificationCode,JobSeekers job_seekers, 
			EmployerService employerService, JobSeekersService jobSeekersService ,VerificationCodeService verificationCodeService, 
			SystemEmployee system_employee, JobPositions job_positions, UserService userService, MernisValidationService mernisValidationService,
			SimulatedMernisService mernisService, VerificationService verificationService) {
		
		super();
		this.employers=employers;
		this.employerService=employerService;
		this.job_seekers=job_seekers;
		this.jobSeekersService=jobSeekersService;
		this.users=users;
		this.verificationCode=verificationCode;
		this.verificationCodeService=verificationCodeService;
		this.system_employee=system_employee;
		this.job_positions=job_positions;
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
	public Result jobSeekersRegister(JobSeekers job_seekers, String confirmPassword) {
		if(!CheckIfFullInfoForJobSeekers(job_seekers, confirmPassword)) {
			return new ErrorResult("Missing information.");
		}
		if(!verificatePerson(job_seekers.getIdentityNo(), job_seekers.getName(),job_seekers.getLastName(),
				job_seekers.getYearOfBirth())==false) {
			return new ErrorResult("Identity No couldn't be verified.");
		}
		if(!CheckIfIdentityNoExist(job_seekers.getIdentityNo())) {
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
	
	private boolean CheckIfFullInfoForJobSeekers(JobSeekers job_seekers , String confirmPassword) {
		if(job_seekers.getName()!=null && job_seekers.getLastName()!=null && job_seekers.getIdentityNo()!= null&& 
				job_seekers.getYearOfBirth()!=null&& job_seekers.getEmail()!=null&& job_seekers.getPassword()!=null
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
