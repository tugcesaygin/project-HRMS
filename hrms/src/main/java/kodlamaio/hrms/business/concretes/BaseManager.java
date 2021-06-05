package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.BaseService;
import kodlamaio.hrms.core.dataAccess.BaseDao;
import kodlamaio.hrms.core.entities.Base;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.verification.VerificationService;

@Service
public class BaseManager implements BaseService {

	private BaseDao baseDao;
	private VerificationService verificationService;
	
	@Autowired
	public BaseManager(BaseDao baseDao , VerificationService verificationService) {
		super();
		this.baseDao=baseDao;
		this.verificationService=verificationService;
	}

	@Override
	public List<Base> getAll() {
		
		return this.baseDao.findAll();
	}

	@Override
	public DataResult<Base> getById(int id) {
		
		return new SuccessDataResult<Base>(this.baseDao.getOne(id));
	}

	@Override
	public Result emailVerification(Base base, String code) {
		
	if(code==null) {
		return new ErrorResult("Can not be blank.");
	}
	if(code.equals(verificationService.verfyCode())) {
		return new ErrorResult("Verification code is wrong!");
	}
	Base base2 = getById(base.getId()).getData();
	if(baseDao.getById(base2.getId())==null) {
		return new ErrorResult("Not Present.");
	}
	else {
		base.setStatus(true);
		return new SuccessResult("Email verification Succeed.");
	}
	}
	
	
}
