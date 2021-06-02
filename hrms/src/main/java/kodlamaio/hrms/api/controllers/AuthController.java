package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	private AuthService authService;
	
	@Autowired
	public AuthController (AuthService authService) {
		super();
		this.authService=authService;
	}
	
	
	
	@PostMapping("/registerEmployers")
	public Result add(@RequestBody Employers employers ,@RequestBody  String confirmPassword) {
		return this.authService.employersRegister(employers, confirmPassword);
	}
	
	@PostMapping("/registerJobSeekers")
	public Result add(@RequestBody JobSeekers job_seekers , @RequestBody String confirmPassword) {
		return this.authService.jobSeekersRegister(job_seekers, confirmPassword);
	}
	
	
}
