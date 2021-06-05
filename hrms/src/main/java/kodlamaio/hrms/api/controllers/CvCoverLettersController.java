package kodlamaio.hrms.api.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvCoverLetterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvCoverLetter;

@RestController
@RequestMapping("/api/coverletters")
public class CvCoverLettersController {

	private CvCoverLetterService cvCoverLetterService;
	@Autowired
	public CvCoverLettersController(CvCoverLetterService cvCoverLetterService) {
		super();
		this.cvCoverLetterService = cvCoverLetterService;
	}
	
	@PostMapping("/add")
	public Result add(CvCoverLetter cvCoverLetter) {
		return this.cvCoverLetterService.add(cvCoverLetter);
	}

	@PostMapping("/delete")
	public Result delete(CvCoverLetter cvCoverLetter) {
		return this.cvCoverLetterService.delete(cvCoverLetter);
	}
	
	@GetMapping("/getById")
	public DataResult<CvCoverLetter> getById(int id){
		return this.cvCoverLetterService.getById(id);
	}
	
	@GetMapping("/>getAllByJobSeekersId")
	public DataResult<List<CvCoverLetter>>getAllByJobSeekersId(int jobSeekersId){
		return this.cvCoverLetterService.getAllByJobSeekersId(jobSeekersId);
	}
	
	
}