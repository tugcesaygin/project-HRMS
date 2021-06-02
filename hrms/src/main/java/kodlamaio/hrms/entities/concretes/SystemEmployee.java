package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="system_employee")
@AllArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@NoArgsConstructor
@Data

public class SystemEmployee extends User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "name")
	private String name;
	
	//@Column(name= "user_id")
	//private String user_id;

	
	@Column(name="lastName")
	private String lastName;
	
}
