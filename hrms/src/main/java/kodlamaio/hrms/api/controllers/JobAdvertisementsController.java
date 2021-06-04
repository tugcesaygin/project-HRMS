package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;

@RestController
@RequestMapping("/api/job_advertisements")

public class JobAdvertisementsController {
	
	private JobAdvertisementService jobAdvertisementService;
	
	@Autowired
	public JobAdvertisementsController(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService=jobAdvertisementService;
	}

	
	@PostMapping("/getAll")
	public DataResult<List<JobAdvertisement>> getAll(){
		return this.jobAdvertisementService.getAll();
	}
	
	@PostMapping("/getByJobAdvertId")
	public DataResult<JobAdvertisement> getByJobAdvertId(@RequestParam int jobadvertId){
		return this.jobAdvertisementService.getByJobAdvertId(jobadvertId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.add(jobAdvertisement);
		
	}
	
	// public Result update(JobAdvertisement jobAdvertisement){}
	
	
	// public Result delete(int jobadvertId){}
	
	
	// public Result changeOpenToClose(int jobadvertId){}

	@PostMapping("/getAllOpenJobAdvertisementByEmployers")
	public DataResult<List<JobAdvertisement>>getAllOpenJobAdvertisementByEmployers(){
		return this.jobAdvertisementService.getAllOpenJobAdvertisementByEmployers();
	}
	
	@PostMapping("/getAllOpenJobAdvertisementByCompanyName")
	public DataResult<List<JobAdvertisement>>getAllOpenJobAdvertisementByCompanyName(){
		return this.jobAdvertisementService.getAllOpenJobAdvertisementByCompanyName();
	}
	
	@PostMapping("/getAllOpenJobAdvertisementByApplicationDeadline")
	public DataResult<List<JobAdvertisement>>getByAllOpenJobAdvertisementByApplicationDeadline(){
		return this.jobAdvertisementService.getByAllOpenJobAdvertisementByApplicationDeadline();
	}
	
	
}
