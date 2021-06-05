package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="cv_foreign_languages")
@EqualsAndHashCode(callSuper = false) 
@AllArgsConstructor
@NoArgsConstructor
public class CvForeignLanguages extends Base{

	@Column(name="language")
	private String language;
	
	@Min(value=1)
	@Max(value=5)
	@Column(name="level")
	private int level;
	

	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name="job_seekers_id")
	private JobSeekers jobSeekers;
	
}
