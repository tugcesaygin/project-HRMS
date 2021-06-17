package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name= "cities")
@AllArgsConstructor
@NoArgsConstructor

public class City {

	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy= "city")
	private List<JobAdvertisement>jobAdvertisement;
	
	
}
