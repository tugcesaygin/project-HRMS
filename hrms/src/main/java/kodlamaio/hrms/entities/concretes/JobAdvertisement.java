package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "job_advertisements")

public class JobAdvertisement  {
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name= "general_job_position_name")
	private String generalJobPositionName;
	
	@Column(name="number_of_open_positions")
	private int numberOfOpenPositions;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "is_open")
	private boolean isOpen;

	
	@ManyToOne()
	@JoinColumn(name="employers_id")
	private Employers employers;
	
	

}
