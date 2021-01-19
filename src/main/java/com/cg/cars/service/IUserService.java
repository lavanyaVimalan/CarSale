package com.cg.cars.service;
/**
 * This is an interface which define CRUD methods for user service
 */
import com.cg.cars.beans.User;
import com.cg.cars.exception.DuplicateUserFoundException;
import com.cg.cars.exception.UserNotFoundException;

public interface IUserService {
	public String addUser(User user) throws DuplicateUserFoundException;
	public String signIn(User user) throws UserNotFoundException;
	public User signOut(User user) throws UserNotFoundException;
	public String changePassword(long id,User user) throws UserNotFoundException;
	public User removeUser(long id) throws DuplicateUserFoundException;
	public User getUserById(long id) throws UserNotFoundException;
	public boolean updateUser(long password,User forUpdate) throws UserNotFoundException;
	
	

}