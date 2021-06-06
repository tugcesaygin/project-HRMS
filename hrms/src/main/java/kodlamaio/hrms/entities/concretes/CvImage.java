package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@Table(name="cv_image")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) 
public class CvImage extends Base{

	@Column(name = "url")
	private String url;
	
	@OneToOne
	@JoinColumn(name="job_seekers_id", referencedColumnName = "user_id")
	private JobSeekers jobSeekers;
	
}
