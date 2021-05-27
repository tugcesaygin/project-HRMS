package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="JobPositions")


public class JobPositions {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name= "job_titles")
	private String job_titles;
	
	@Column(name= "userId")
	private String userId;
	
	public JobPositions() {
		
	}

	public JobPositions(int id, String job_titles, String userId) {
		super();
		this.id = id;
		this.job_titles = job_titles;
		this.userId = userId;
	}
	
	
	
	
	
}
