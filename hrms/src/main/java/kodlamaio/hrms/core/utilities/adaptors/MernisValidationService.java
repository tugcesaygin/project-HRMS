package kodlamaio.hrms.core.utilities.adaptors;

public interface MernisValidationService {
	boolean CheckIfRealPerson(String identityNo , String name, String lastName, int yearOfBirth);
}
