package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data

@AllArgsConstructor
@NoArgsConstructor
@Table(name = "job_seekers")
@EqualsAndHashCode(callSuper = false) 
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id") 


public class JobSeekers extends User {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "lastName")
	private String lastName;
	
	@Column(name = "identityNo")
	private String identityNo;
	
	@Column(name = "yearOfBirth")
	private LocalDate yearOfBirth;
	
	

}
