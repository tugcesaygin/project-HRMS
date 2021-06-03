package kodlamaio.hrms.Mernis;

import java.time.LocalDate;

public class PersonVerification {

	public boolean verificatePerson(String identity_no ,String name ,String last_name ,LocalDate year_of_birth) {
		System.out.println(name + "" + last_name  + "has been verified");
		return true;
	}


}
