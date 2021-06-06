package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.core.cvImage.ImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvImageDao;
import kodlamaio.hrms.entities.concretes.CvImage;
@Service
public class CvImageManager implements CvImageService {


	private CvImageDao cvImageDao;
	private ImageService imageService;
	private ModelMapper modelMapper;

	
	@Autowired
	public CvImageManager(CvImageDao cvImageDao,ImageService imageService, ModelMapper modelMapper) {
		
		this.cvImageDao = cvImageDao;
		this.imageService = imageService;
		this.modelMapper = modelMapper;
	}


	@Override
	public Result add(CvImage cvImage) {
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Photo added.");
	}


	@Override
	public Result delete(CvImage cvImage) {
		this.cvImageDao.delete(cvImage);
		return new SuccessResult("Photo deleted.");
	}


	@Override
	public Result add(CvImage cvImage, MultipartFile file) {
		Map<String, String> result = (Map<String, String>) imageService.save(file).getData();
		String url = result.get("url");
		cvImage.setUrl(url);
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Photo has been added.");
	}


	@Override
	public DataResult<CvImage> getById(int id) {
		return new SuccessDataResult<CvImage>(this.cvImageDao.getById(id));
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll());
	
	
}
}