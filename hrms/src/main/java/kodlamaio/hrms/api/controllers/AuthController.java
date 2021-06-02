package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import kodlamaio.hrms.entities.concretes.SystemEmployee;
public class AuthController {

	private AuthService authService;
	public AuthController (AuthService authService) {
		super();
		this.authService=authService;
	}
	
	
	
	@PostMapping("/registerEmployer")
	public Result add(@RequestBody Employers employers) {
		return this.authService.employerRegister(employers);
	}
	
	@PostMapping("/registerJobSeeker")
	public Result add(@RequestBody JobSeekers jobSeekers) {
		return this.authService.jobSeekerRegister(jobSeekers);
	}
	
	
}
