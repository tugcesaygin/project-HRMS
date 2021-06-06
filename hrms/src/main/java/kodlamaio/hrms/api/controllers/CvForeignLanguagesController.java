package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvForeignLanguagesService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.CvForeignLanguages;

@RestController
@RequestMapping("/api/foreignlanguages")
public class CvForeignLanguagesController {

	private CvForeignLanguagesService cvForeignLanguages;
	@Autowired
	public CvForeignLanguagesController(CvForeignLanguagesService cvForeignLanguagesService) {
		super();
		this.cvForeignLanguages = cvForeignLanguagesService;
	}
	
	@PostMapping("/add")
	public Result add(CvForeignLanguages cvForeignLanguages) {
		return this.cvForeignLanguages.add(cvForeignLanguages);
	}
	
	@PostMapping("/update")
	public Result update(CvForeignLanguages cvForeignLanguages) {
		return this.cvForeignLanguages.update(cvForeignLanguages);
	}
	
	
	@PostMapping("/delete")
	public Result delete(int id) {
		return this.cvForeignLanguages.delete(id);
	}
	
	
	@PostMapping("/getAllByJobSeekersId")
	public DataResult<List<CvForeignLanguages>>getAllByJobSeekersId(int jobSeekersId){
		return this.cvForeignLanguages.getAllByJobSeekersId(jobSeekersId);
	}
	
	
	@PostMapping("/getById")
	public DataResult<List<CvForeignLanguages>>getById(int id){
		return this.cvForeignLanguages.getById(id);
	}

	public DataResult<List<CvForeignLanguages>>getAll(){
		return this.cvForeignLanguages.getAll();
	}
	
}
