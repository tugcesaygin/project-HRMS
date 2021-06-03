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

	private SystemEmployeeDao system_employeeDao;
	
	@Autowired
	public SystemEmployeeManager(SystemEmployeeDao system_employeeDao) {
		super();
		this.system_employeeDao=system_employeeDao;
	}
	
	
	
	@Override
	public DataResult<List<SystemEmployee>> getAll() {
		return new SuccessDataResult<List<SystemEmployee>>
		(this.system_employeeDao.findAll(),"System Employee Listed.");
		
	}

	@Override
	public Result add(SystemEmployee employee) {
		this.system_employeeDao.save(employee);
		return new SuccessResult("System Employee added.");
	}



}
