package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemEmployeeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemEmployeeDao;
import kodlamaio.hrms.entities.concretes.SystemEmployee;

@Service
public class SystemEmployeeManager implements SystemEmployeeService{

	private SystemEmployeeDao employeeDao;
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao employeeDao) {
		super();
		this.employeeDao=employeeDao;
	}
	
	
	
	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>
		(this.employeeDao.findAll(),"System Employee Listed.");
		
	}

	@Override
	public Result add(SystemEmployee employee) {
		this.employeeDao.save(employee);
		return new SuccessResult("System Employee added.");
	}



}
