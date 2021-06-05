package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvForeignLanguages;

public interface CvForeignLanguagesDao extends JpaRepository<CvForeignLanguages, Integer> {

	
	List<CvForeignLanguages>getAllByJobSeekersId(int jobSeekersId);
	List<CvForeignLanguages>getById(int id);
}
