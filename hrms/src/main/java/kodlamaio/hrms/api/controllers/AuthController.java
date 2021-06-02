package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobSeekers;

public class AuthController {

	private AuthService authService;
	public AuthController (AuthService authService) {
		super();
		this.authService=authService;
	}
	
	
	
	@PostMapping("/registerEmployer")
	public Result add(@RequestBody Employers employers , String confirmPassword) {
		return this.authService.employerRegister(employers, confirmPassword);
	}
	
	@PostMapping("/registerJobSeeker")
	public Result add(@RequestBody JobSeekers jobSeekers , String confirmPassword) {
		return this.authService.jobSeekerRegister(jobSeekers, confirmPassword);
	}
	
	
}
