package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvProgrammingSkillsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.concretes.CvProgrammingSkills;

@RestController
@RequestMapping("/api/programmingskills")
public class CvProgrammingSkillsController {

	private CvProgrammingSkillsService cvProgrammingSkillsService;
	
	@Autowired
	public CvProgrammingSkillsController(CvProgrammingSkillsService cvProgrammingSkillsService) {
		super();
		this.cvProgrammingSkillsService = cvProgrammingSkillsService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody   CvProgrammingSkills cvProgrammingSkills) {
		return this.cvProgrammingSkillsService.add(cvProgrammingSkills);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody  CvProgrammingSkills cvProgrammingSkills) {
		return this.cvProgrammingSkillsService.update(cvProgrammingSkills);
	}
	
	
	@PostMapping("/delete")
	public Result delete( @RequestParam  int id) {
		return this.cvProgrammingSkillsService.delete(id);
	}
	
	
	
	@GetMapping("/getAllByJobSeekersId")
	public DataResult<List<CvProgrammingSkills>>getAllByJobSeekersId(@RequestParam   int jobSeekersId){
		return this.cvProgrammingSkillsService.getAllByJobSeekersId(jobSeekersId);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvProgrammingSkills>>getAll(){
		return this.cvProgrammingSkillsService.getAll();
	}
	
	
}
