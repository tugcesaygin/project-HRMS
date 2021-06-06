package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.CvEducation;

@RestController
@RequestMapping("/api/educations")
public class CvEducationsController {
	private CvEducationService cvEducationService;
	
	@Autowired
	public CvEducationsController(CvEducationService cvEducationService) {
		super();
		this.cvEducationService = cvEducationService;
		
	}
	
	@PostMapping("/add")
	Result add(@RequestBody  CvEducation cvEducation) {
		return this.cvEducationService.add(cvEducation);
	}
	
	@GetMapping("/getbyid")
	DataResult<List<CvEducation>>getAllByJobSeekersId(@RequestParam   int id){
		return this.cvEducationService.getAllByIdOrderByGraduationDateDesc(id);
		
	}
	
	@GetMapping("/getAllByIdOrderByGraduationDateDesc")
	DataResult<List<CvEducation>>getAllByIdOrderByGraduationDateDesc(int jobSeekersId){
		return this.cvEducationService.getAllByIdOrderByGraduationDateDesc(jobSeekersId);
	}

	@GetMapping("/getAll")
	DataResult<List<CvEducation>> getAll(){
		return this.cvEducationService.getAll();
	}
	
}
