package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.SystemEmployee;

@RestController
@RequestMapping("/api/employees")
public class SystemEmployeesController {

	private SystemEmployeeService employeeService;
	
	public SystemEmployeesController(SystemEmployeeService employeeService) {
		super();
		this.employeeService=employeeService;
		
		
	}

	@GetMapping("/getall")
	public DataResult<List<SystemEmployee>>getAll(){
		return this.employeeService.getAll(); 
		
	}
	
	
	@PostMapping("/add")
	public Result add(@RequestBody SystemEmployee systemEmployee) {
		return this.employeeService.add(systemEmployee);
	}
	
	
	
}
