package kodlamaio.hrms.Mernis;

import java.time.LocalDate;

public class PersonVerification {

	public boolean verificatePerson(String identityNo ,String name ,String lastName ,LocalDate birthOfYear) {
		System.out.println(name + "" + lastName  + "has been verified");
		return true;
	}


}
