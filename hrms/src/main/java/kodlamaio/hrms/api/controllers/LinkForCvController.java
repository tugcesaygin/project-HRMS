package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LinksForCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LinkForCv;

@RestController
@RequestMapping("/api/links")
public class LinkForCvController {

	private LinksForCvService linksForCvService;

	@Autowired
	public LinkForCvController (LinksForCvService linksForCvService) {
		super();
		this.linksForCvService = linksForCvService;
	}
	
	@PostMapping("/add")
	public Result add(LinkForCv linkForCv) {
		return this.linksForCvService.add(linkForCv);
	}
	
	@PostMapping("/update")
	public Result update(LinkForCv linksForCv) {
		return this.linksForCvService.update(linksForCv);
	}
	
	@GetMapping("/getAllByJobSeekersId")
	public DataResult<List<LinkForCv>>getAllByJobSeekersId(int jobSeekersId){
		return this.linksForCvService.getAllByJobSeekersId(jobSeekersId);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<LinkForCv>>getAll(){
		return this.linksForCvService.getAll();
	}
}
