package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.LinksForCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.LinkForCvDao;
import kodlamaio.hrms.entities.concretes.LinkForCv;

@Service
public class LinkForCvManager implements LinksForCvService{

	private LinkForCvDao linkForCvDao;
	@Autowired
	public LinkForCvManager (LinkForCvDao linkForCvDao) {
		super();
		this.linkForCvDao = linkForCvDao;
	}
	@Override
	public Result add(LinkForCv linkForCv) {
		this.linkForCvDao.save(linkForCv);
		return new SuccessResult("Link has been added.");
	}
	@Override
	public Result update(LinkForCv linksForCv) {
		this.linkForCvDao.save(linksForCv);
		return new SuccessResult("Link has been updated");
	}
	@Override
	public DataResult<List<LinkForCv>> getAllByJobSeekersId(int jobSeekersId) {
		
		return new SuccessDataResult<List<LinkForCv>>(this.linkForCvDao.getAllByJobSeekersId(jobSeekersId));
	}
	@Override
	public DataResult<List<LinkForCv>> getAll() {
		
		return new SuccessDataResult<List<LinkForCv>>(this.linkForCvDao.findAll());
	}
	
	
	
}
