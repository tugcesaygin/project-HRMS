package kodlamaio.hrms.core.utilities.adaptors;

import java.time.LocalDate;

public interface MernisValidationService {
	
	boolean CheckIfRealPerson(String identity_no , String name, String last_name, LocalDate year_of_birth);
}
