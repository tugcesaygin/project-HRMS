package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "identity_no")
	private String identityNo;
	
	@Column(name = "year_of_birth")
	private LocalDate yearOfBirth;
	
	@JsonIgnore
	@OneToMany()
	private List<CvEducation>cvEducation;
	
	@JsonIgnore
	@OneToMany()
	private List<CvExperience>cvExperience;
	
	@JsonIgnore
	@OneToMany()
	private List<CvForeignLanguages>cvForeignLanguages;

	@JsonIgnore
	@OneToMany
	private List<CvProgrammingSkills>cvProgrammingSkills;
}
