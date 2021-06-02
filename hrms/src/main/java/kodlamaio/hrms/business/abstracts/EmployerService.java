package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import java.util.List;
import kodlamaio.hrms.entities.concretes.Employers;

public interface EmployerService {
	
	DataResult<List<Employers>> getAll();
	Result add(Employers employers);
}
