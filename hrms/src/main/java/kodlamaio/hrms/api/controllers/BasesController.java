package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.BaseService;
import kodlamaio.hrms.core.entities.Base;

import kodlamaio.hrms.core.utilities.results.Result;

@RestController
@RequestMapping("/api/bases")
public class BasesController {

	private BaseService baseService;
	
	public BasesController(BaseService baseService) {
		super();
		this.baseService=baseService;
	}
	
	@GetMapping("/getall")
	public List<Base>getAll(){
		return this.baseService.getAll();
	}
	
	
	@PostMapping("/verification")
	public Result emailVerification(@RequestParam  Base base,@RequestParam  String code) {
		return this.baseService.emailVerification(base, code);
	}
	
	
	
	
	
}
