package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPositions;

@CrossOrigin
@RestController
@RequestMapping("/api/job_positions")
public class JobPositionsController {

	
	private JobPositionsService positionsService;
	
	@Autowired
	public JobPositionsController(JobPositionsService positionsService){
		super();
		this.positionsService = positionsService;
		
	}
	
	@GetMapping("/getall")
	public DataResult<List<JobPositions>> getAll(){
		return this.positionsService.getAll();
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody JobPositions job_positions) {
		return this.positionsService.add(job_positions);
	}
	
	
	
	
}
