package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.VerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.VerificationDao;
import kodlamaio.hrms.entities.concretes.Verification;

@Service
public class VerificationManager implements VerificationService {

	private VerificationDao verificationDao;
	
	public VerificationManager(VerificationDao verificationDao ) {
		super();
		this.verificationDao=verificationDao;
	}
	
	@Override
	public Result add(Verification code) {
		this.verificationDao.save(code);
		return new SuccessResult("Verification code saved.");
	
	}

}
