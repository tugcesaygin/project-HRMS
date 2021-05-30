package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@Table(name= "employers")

public class Employers extends User{

	@Column(name="company_name")
	private String company_name;
	
	@Column(name= "webSite")
	private String webSite;
	
	@Column(name= "telNo")
	private String telNo;
	
	
	
	
	
}
