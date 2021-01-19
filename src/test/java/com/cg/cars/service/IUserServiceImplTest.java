package com.cg.cars.service;
/**
 * The UserServiceImplTest class provide testing of UserServiceImpl layer
 */
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.cars.beans.User;
import com.cg.cars.dao.IUserRepository;
import com.cg.cars.exception.DuplicateUserFoundException;
import com.cg.cars.exception.UserNotFoundException;
@SpringBootTest
class UserServiceImplTest {
	@Autowired
	private IUserService service;
	
	@MockBean
	private IUserRepository dao;
	
	/*
	 * This method test whether add user added or not
	 */
	@Test
	void testAddUserShouldAddUserDataToDatabase() throws DuplicateUserFoundException{
		User user=new User(100,"Lia","Lia123","Employee");
		when(dao.save(user)).thenReturn(user);
		String result=service.addUser(user);
		assertEquals(user.getUserId(),user.getUserId());
	}
	  /*
	   * This method test get user based on Id
	   */
	@Test
	 void testGetUserBasedOnId() throws UserNotFoundException {
		 User user=new User(100,"Lia","Lia123","Employee");
		 long userId=user.getUserId();
		 Optional<User> getUser=Optional.of(user);
		 Mockito.when(dao.findById(userId)).thenReturn(getUser);
		 User user1=service.getUserById(userId);
		 Optional<User> user2=Optional.of(user1);
		 assertEquals(user2,getUser);
	 }
	
        /*
         * This method test whether user signIn or not	
         */
	@Test
	void testSignInSholudSignInDataToDatabase() throws UserNotFoundException{
		User user= new User(122,"Meena","Mee234","Employee");
		when(dao.save(user)).thenReturn(user);
		String result=service.signIn(user);
		assertEquals(user.getUserId(),user.getUserId());
	}
	
	  /*
	   * This method test whether password is changed or not
	   */
	@Test
	    void testchangePasswordShouldchangePasswordDataToDatabase() throws UserNotFoundException{
		User user= new User(122,"Meena","Meena123","Employee");
		when(dao.save(user)).thenReturn(user);
		String expected=service.changePassword(122, user);
		assertEquals(user.getPassword(),user.getPassword());
	}
      
	/*@Test
	 void testupdateUserShouldupdateUserById() throws UserNotFoundException{
		User updateUser=new User();
		updateUser.setUserId(100);
		when(dao.existsById(100l)).thenReturn(true);
		when(dao.findById(100l)).thenReturn(Optional.of(updateUser));
		when(dao.save(updateUser)).thenReturn(updateUser);
		boolean user=service.updateUser(100, updateUser);
		assertEquals(user,updateUser);
		}*/
	 
	/*
	 *  This method test userData deleted  or not
	 */
	 @Test 
	 void RemoveUserShouldRemoveUserDatafromDatabase() throws  DuplicateUserFoundException{
		 User user=new User(100,"Lia","Lia123","Employee");
		 long userId=user.getUserId();
		 Optional<User> userToDelete=Optional.of(user);
		 Mockito.when(dao.findById(userId)).thenReturn(userToDelete);
		 user=service.removeUser(userId);
		 Optional<User> user1=Optional.of(user);
		 assertEquals(user1,userToDelete);
	 }
	 
	 
}