package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.dataAccess.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao=userDao;
	}

	
	@Override
	public DataResult<List<User>> getAll() {
		
		return new SuccessDataResult<List<User>>(this.userDao.findAll(), "User Listed.");
	}

	@Override
	public Result add(User users) {
		this.userDao.save(users);
		return new SuccessResult("User added.");
	}

	@Override
	public Result delete(User users) {
		this.userDao.delete(users);
		return new SuccessResult("User deleted.");
	}


	@Override
	public DataResult<User> getUserByEmail(String email) {
		return new SuccessDataResult<User>
		(this.userDao.findUserByEmail(email));
		
	}

//	@Override
//	public Result update(User user) {
		// TODO Auto-generated method stub
//		return null;
//	}
	
	
	
}
