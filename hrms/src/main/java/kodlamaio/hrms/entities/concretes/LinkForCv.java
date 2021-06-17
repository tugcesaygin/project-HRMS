package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false) 
@Table(name= "link_for_cv")

public class LinkForCv {
	
	@Column(name= "name")
	private String name;
	
	@Column(name = "url")
	private String url;
	
	@ManyToOne()
	@JoinColumn(name = "job_seekers_id")
	private JobSeekers jobSeekers;

}
