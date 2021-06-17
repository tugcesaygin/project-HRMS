package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@EqualsAndHashCode(callSuper = false) 
@Table(name="cv_programming_skills")
public class CvProgrammingSkills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_skills_id")
	private int cvSkillsId;
	
	
	@Column(name="job_skills")
	private String jobSkills;
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="job_seekers_id")
	private JobSeekers jobSeekers;
	
}
