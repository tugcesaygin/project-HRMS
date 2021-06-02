package kodlamaio.hrms.core.utilities.adaptors;

import java.time.LocalDate;

public interface MernisValidationService {
	
	boolean CheckIfRealPerson(String identityNo , String name, String lastName, LocalDate yearOfBirth);
}
