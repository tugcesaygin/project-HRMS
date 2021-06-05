package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.Base;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface BaseService {

	List<Base>getAll();
	DataResult<Base> getById(int id);
	Result emailVerification(Base base,String code);
	
	
}
