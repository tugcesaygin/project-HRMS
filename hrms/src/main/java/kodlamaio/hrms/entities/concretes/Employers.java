package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "employers")
@EqualsAndHashCode(callSuper = false) 
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id") 

public class Employers extends User{

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="company_name")
	private String companyName;
	
	@Column(name= "web_site")
	private String webSite;
	
	@Column(name= "tel_no")
	private String telNo;
	
	@OneToMany(mappedBy= "employers")
	private List<JobAdvertisement>jobAdvertisement;
	
	
	
	
	
}
