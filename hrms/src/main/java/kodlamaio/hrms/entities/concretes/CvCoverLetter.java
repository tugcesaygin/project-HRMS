package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.core.entities.Base;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "cv_cover_letter")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) 
public class CvCoverLetter extends Base{

	@Column(name= "content")
	private String content;
	
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "job_seekers_id")
	private JobSeekers jobSeekers;
	
}
