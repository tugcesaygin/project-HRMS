package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.entities.concretes.JobPositions;

@RestController
@RequestMapping("/api/JobPositions")
public class JobPositionsController {

	
	private JobPositionsService positionsService;
	
	@Autowired
	public JobPositionsController(JobPositionsService positionsService){
		super();
		this.positionsService = positionsService;
		
	}
	
	@GetMapping("/getall")
	public List<JobPositions>getAll(){
		
		return this.positionsService.getAll();
	}
	
	
	
	
}
