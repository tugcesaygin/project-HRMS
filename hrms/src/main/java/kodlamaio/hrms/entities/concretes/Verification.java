package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

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
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name="verification")
public class Verification {

	@Column(name="user_id")
	private int user_id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="isVerified")
	private boolean isVerified;
	
	@Column(name="verificationDate")
	private LocalDate verificationDate;
	
	
	
}
