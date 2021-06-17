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
@Table(name = "cv_cover_letter")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false) 
public class CvCoverLetter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cv_cover_letter_id")
	private int cvCoverLetterId;
	
	@Column(name= "content")
	private String content;
	
	
	@JsonIgnore
	@ManyToOne()
	@JoinColumn(name = "job_seekers_id")
	private JobSeekers jobSeekers;
	
}
