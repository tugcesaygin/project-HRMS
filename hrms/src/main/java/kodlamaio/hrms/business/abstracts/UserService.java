package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService {

	DataResult<List<User>>getAll();
	Result add(User users);
	Result delete(User users);
	//Result update(User user);
	DataResult<User> getUserByEmail(String email);
	
}
