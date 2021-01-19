package com.cg.cars.service;
/**
 * The UserServiceImpl class provide access to repository method to CRUD User details
 */
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.cars.beans.User;
import com.cg.cars.dao.IUserRepository;
import com.cg.cars.exception.DuplicateUserFoundException;
import com.cg.cars.exception.UserNotFoundException;

@Service("service")
public class IUserServiceImpl  implements IUserService{
	
	private static final Logger logger = LogManager.getLogger(IUserServiceImpl.class);
	
	@Autowired
    private IUserRepository dao;
	
	@Override
	
	public String addUser(User user) throws DuplicateUserFoundException {
	 User user1=dao.save(user);
	 if(user1!=null) {
		 logger.info("User Added Successfully...!");
		 return "addUser";
	 }
	 else {
		 throw new DuplicateUserFoundException(DuplicateUserFoundException.MESSAGE);
	}
}
	@Override
	public User getUserById(long id) throws UserNotFoundException {
	  Optional<User> user=dao.findById(id);
	  if(user.isPresent()) {
		  logger.info("Retrieved User By Id Successfully..!");
		  return user.get();
	  }
	  throw new UserNotFoundException(UserNotFoundException.MESSAGE);
	}

	@Override
	public String signIn(User user) throws UserNotFoundException{
		User user1=dao.save(user);
		if(user1!=null) {
			logger.info("User Signin Successfully..!");
			return "User signIn";
	}
	else{
		throw new UserNotFoundException(UserNotFoundException.MESSAGE);
	}
}

	@Override
	public String changePassword(long id, User user) throws UserNotFoundException {
		if(user!=null) {
			user.setPassword(user.getPassword());
			logger.info("Password Changed Successfully..!");
		return "User password updated";
	}
		else 
			return "not password updated";
	}

	@Override
	public User removeUser(long id) throws DuplicateUserFoundException{
		User user1=dao.findById(id).orElseThrow(()-> new DuplicateUserFoundException(DuplicateUserFoundException.MESSAGE));
		dao.delete(user1);
		logger.info("User Deleted Successfully..!");
		return user1;
	}

	@Override
	public boolean updateUser(long id , User forUpdate) throws UserNotFoundException {
		if(dao.existsById ((long) id)) {
			logger.info("User Updated Successfully...!");
			return (dao.save(forUpdate)!=null)?true:false;
		   }
		   throw new UserNotFoundException(UserNotFoundException.MESSAGE);
		}

	@Override
	public User signOut(User user) throws UserNotFoundException {
		logger.info("User Signout Successfully..!");
		return null;
	}
	

}