package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;




@Entity
@Data
@Table(name="cv_educations")
@EqualsAndHashCode(callSuper = false) 
@AllArgsConstructor
@NoArgsConstructor
public class CvEducation  {
	
	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "education_id")
	private int educationid;
	
	@NotBlank(message = "The field must be filled")
	@Column(name = "school_type")
	private String schoolType;
	
	
	@NotBlank(message = "The field must be filled")
	@Column(name = "beginning_date")
	private LocalDate beginningDate;
	

	@Column(name = "graduation_date")
	private LocalDate graduationDate;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "job_seekers_id")
	private JobSeekers jobSeekers;
	
	
	@ManyToOne()
	@JoinColumn(name = "city_id")
	private City city;
	
	

}
