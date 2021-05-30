package kodlamaio.hrms.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@RestController
@RequestMapping("/api/job_seekers")
public class JobSeekersController {

	private JobSeekersService jobSeekersService;
	
	public JobSeekersController(JobSeekersService jobSeekersService) {
		super();
		this.jobSeekersService= jobSeekersService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobSeekers>>getAll(){
		return this.jobSeekersService.getAll(); 
		
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody JobSeekers jobSeekers) {
		return this.jobSeekersService.add(jobSeekers);
	}
	
	
	
	
}
