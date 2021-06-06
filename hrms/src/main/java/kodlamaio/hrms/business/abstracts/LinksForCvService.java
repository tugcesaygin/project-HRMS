package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.LinkForCv;
public interface LinksForCvService {

	Result add(LinkForCv linkForCv);
	Result update(LinkForCv linksForCv);
	DataResult<List<LinkForCv>>getAllByJobSeekersId(int jobSeekersId);
	DataResult<List<LinkForCv>>getAll();
	
}
