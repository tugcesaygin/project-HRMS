package kodlamaio.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.Employers;
import java.util.List;
@RestController
@CrossOrigin
@RequestMapping("/api/employers")

public class EmployersController {

	private EmployerService employerService;
	
	@Autowired
	public EmployersController(EmployerService employerService) {
		super();
		this.employerService=employerService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<Employers>>getAll(){
		return this.employerService.getAll();
		
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody Employers employers) {
		return this.employerService.add(employers);
	}
	
	
	
}
