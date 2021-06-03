package kodlamaio.hrms.core.utilities.adaptors;



import java.time.LocalDate;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.Mernis.PersonVerification;

@Service
public class SimulatedMernisService  implements MernisValidationService{

	@Override
	public boolean CheckIfRealPerson(String identity_no, String name, String last_name, LocalDate year_of_birth) {
		PersonVerification person = new PersonVerification();
		
		boolean result = true ;

		try {
			result = person.verificatePerson(identity_no,name,last_name,year_of_birth);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	}

