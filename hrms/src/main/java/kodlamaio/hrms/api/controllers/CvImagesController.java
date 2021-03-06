package kodlamaio.hrms.api.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.business.abstracts.JobSeekersService;
import kodlamaio.hrms.core.cvImage.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.CvImage;

@RestController
@RequestMapping("/api/images")
public class CvImagesController {

	private CvImageService cvImageService;
	private JobSeekersService jobSeekersService;
	private ImageService imageService;
	@Autowired
	public CvImagesController(CvImageService cvImageService , ImageService imageService , JobSeekersService jobSeekersService) {
		super();
		this.cvImageService=cvImageService;
		this.jobSeekersService = jobSeekersService;
		this.imageService = imageService;
	}
	
	@PostMapping("/add")
	Result add(CvImage cvImage) {
		return this.cvImageService.add(cvImage);
	}
	
	@PostMapping("/delete")
	Result delete(CvImage cvImage) {
		return this.cvImageService.delete(cvImage);
	}
	
	

	@GetMapping("/getById")
	DataResult<CvImage> getById(@RequestParam("id")  int id){
		return this.cvImageService.getById(id);
	}

	@GetMapping("/getAll")
	DataResult<List<CvImage>> getAll(){
		return this.cvImageService.getAll();
	}
	
}
