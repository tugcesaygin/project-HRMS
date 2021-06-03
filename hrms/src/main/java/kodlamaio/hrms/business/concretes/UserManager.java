package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.UserDao;
import kodlamaio.hrms.entities.concretes.User;

@Service
public class UserManager implements UserService {

	private UserDao usersDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.usersDao=userDao;
	}

	
	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.usersDao.findAll(), "User Listed.");
	}

	@Override
	public Result add(User users) {
		this.usersDao.save(users);
		return new SuccessResult("User added.");
	}

	@Override
	public Result delete(User users) {
		this.usersDao.delete(users);
		return new SuccessResult("User deleted.");
	}


	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>
		(this.usersDao.findUserByEmail(email));
		
	}

//	@Override
//	public Result update(User user) {
		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
}
