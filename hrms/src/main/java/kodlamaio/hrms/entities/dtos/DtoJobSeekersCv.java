package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.CvCoverLetter;
import kodlamaio.hrms.entities.concretes.CvEducation;
import kodlamaio.hrms.entities.concretes.CvExperience;
import kodlamaio.hrms.entities.concretes.CvForeignLanguages;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkills;
import kodlamaio.hrms.entities.concretes.JobSeekers;

public class DtoJobSeekersCv {

	public JobSeekers jobSeekers;
	public List<CvEducation>cvEducation;
	public List<CvExperience>cvExperience;
	public List<CvForeignLanguages>cvForeignLanguages;
	public List<CvProgrammingSkills>cvProgrammingSkills;
	public List<CvCoverLetter>cvCoverLetter;

	
}
