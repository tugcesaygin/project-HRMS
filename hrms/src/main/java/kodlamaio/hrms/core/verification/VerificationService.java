package kodlamaio.hrms.core.verification;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.VerificationCode;

public interface VerificationService {
	void sendLink(String email);
	String sendCode();
	Result save(VerificationCode code);
	String verfyCode();
}
