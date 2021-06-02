package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;

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
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name="verification_code")
public class VerificationCode {


	public VerificationCode(int user_id, String code, boolean isVerified) {
		super();
		this.code=code;
		this.isVerified=isVerified;
		this.user_id=user_id;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int user_id;
	
	@Column(name="code")
	private String code;
	
	@Column(name="isVerified")
	private boolean isVerified;
	
	@Column(name="verificationDate")
	private LocalDate verificationDate;
	
	
	
}
