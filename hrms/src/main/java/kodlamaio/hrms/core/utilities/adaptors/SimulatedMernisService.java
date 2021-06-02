package kodlamaio.hrms.core.utilities.adaptors;



import java.time.LocalDate;

import kodlamaio.hrms.Mernis.PersonVerification;

public class SimulatedMernisService  implements MernisValidationService{

	@Override
	public boolean CheckIfRealPerson(String identityNo, String name, String lastName, LocalDate yearOfBirth) {
		PersonVerification person = new PersonVerification();
		
		boolean result = true ;

		try {
			result = person.verificatePerson(identityNo,name,lastName,yearOfBirth);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	}

