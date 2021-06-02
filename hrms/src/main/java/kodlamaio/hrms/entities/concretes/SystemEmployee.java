package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="system_employee")
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name="user_id", referencedColumnName="id") 
@EqualsAndHashCode(callSuper = false) 

public class SystemEmployee extends User {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	@Column(name= "name")
	private String name;
	
	//@Column(name= "user_id")
	//private String user_id;

	
	@Column(name="lastName")
	private String lastName;
	
}
