package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employers;

@Service
public class EmployerManager implements EmployerService{

	private EmployerDao employersDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employersDao=employerDao;
	}
	
	
	@Override
	public DataResult<List<Employers>> getAll() {
		
		return new SuccessDataResult<List<Employers>>(this.employersDao.findAll(),"Employers Listed.");
	}

	@Override
	public Result add(Employers employers) {
		this.employersDao.save(employers);
		return new SuccessResult("Employers added.");
	}

}
