package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name="job_advertisements")

public class JobAdvertisement  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "jobadvert_id")
	private int jobadvertId;
	
	@Column(name="company_name")
	private String companyName;
	
	
	@Column(name="open_positions")
	private int OpenPositions;
	
	@Column(name="release_date")
	private LocalDate releaseDate;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name = "is_open")
	private boolean isOpen;

	
	@ManyToOne()
	@JoinColumn(name ="job_positions_id")
	private JobPositions jobPositions;
	
	
	@ManyToOne()
	@JoinColumn(name="employers_id")
	private Employers employers;
	
	@ManyToOne()
	@JoinColumn(name="city_id")
	private City city;

}
