package kodlamaio.hrms.api.controllers;

import java.time.LocalDate;
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

	

	
	@PostMapping("/getByJobAdvertId")
	public DataResult<JobAdvertisement> getByJobadvertId(@RequestParam int jobadvertId){
		return this.jobAdvertisementService.getByJobadvertId(jobadvertId);
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobAdvertisement jobAdvertisement){
		return this.add(jobAdvertisement);
		
	}
	
	// public Result update(JobAdvertisement jobAdvertisement){}
	
	
	// public Result delete(int jobadvertId){}
	
	
	// public Result changeOpenToClose(int jobadvertId){}

	@PostMapping("/getAllOpenJobAdvertisementByEmployers")
	public DataResult<List<JobAdvertisement>>getByIsOpenByEmployers(boolean isOpen, int employerId){
		return this.jobAdvertisementService.getByIsOpenAndEmployers_Id(isOpen, employerId);
	}
	
	//@PostMapping("/getAllOpenJobAdvertisementByCompanyName")
	//public DataResult<List<JobAdvertisement>>getByAllOpenJobAdvertisementByCompanyName(){
	//	return this.jobAdvertisementService.getByIsOpenByCompanyName();
	//}
	
	@PostMapping("/getAllOpenJobAdvertisementByApplicationDeadline")
	public DataResult<List<JobAdvertisement>>getByIsOpenByApplicationDeadline(boolean isOpen, LocalDate applicationDeadline){
		return this.jobAdvertisementService.getByIsOpenAndApplicationDeadline(isOpen, applicationDeadline);
	}
	
	
}
