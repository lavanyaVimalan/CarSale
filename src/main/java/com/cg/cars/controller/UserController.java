package com.cg.cars.controller;
/**
 * This is the controller class for User module
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.beans.User;
import com.cg.cars.exception.DuplicateUserFoundException;
import com.cg.cars.exception.UserNotFoundException;
import com.cg.cars.service.IUserService;

@RestController
@RequestMapping(path="/users")
public class UserController {
	@Autowired
 private IUserService service;
	
	/**
	 * This method add user 
	 * @param user
	 * @return
	 * @throws DuplicateUserFoundException
	 */
	//http://localhost:8000/users/addUser-method POST

@PostMapping("/addUser")
public  ResponseEntity <String> addUser(@RequestBody User user) throws DuplicateUserFoundException{
	String user1=service.addUser(user);
	ResponseEntity<String> response;
	if(user!=null) {
		response=new ResponseEntity<String>("User with"+user.getUserId()+" is added.",HttpStatus.CREATED);
	}
	else {
		response=new ResponseEntity<String>("User with"+user.getUserId()+"is not added",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return response;
}
   /**
    * This method get user based on Id
    * @param id
    * @return
    * @throws UserNotFoundException
    */

//http://localhost:8000/users/getUser-method GET
@GetMapping("/getUser/{id}")
public ResponseEntity<User> getUserId(@PathVariable(value="id") long id) throws UserNotFoundException{
	User user=service.getUserById(id);
	if(user==null) {
		return new ResponseEntity("User with"+user.getUserId()+"is not found.",HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<User>(user,HttpStatus.OK);
}

/**
 * This method delete the user
 * 
 */
   //http://localhost:8000/users/deleteUser-method DELETE
@DeleteMapping("/deleteUser/{id}")
public ResponseEntity<String> removeUser(@PathVariable(value="id") long id) throws DuplicateUserFoundException{
	User  user =service.removeUser(id);
	ResponseEntity<String> response;
	if(user !=null) {
		response=new ResponseEntity<String>("User with"+ user.getUserId()+"is deleted.",HttpStatus.OK);
	}
	else {
		response=new ResponseEntity<String>("User with "+ user.getUserId()+"is not deleted.",HttpStatus.NOT_FOUND);
	}
	return response;
}

/**
 * This method update the user
 * @param id
 * @param user
 * @return
 * @throws UserNotFoundException
 */
    //http://localhost:8000/users/updateUser/id-method PUT
@PutMapping("/updateUser/{id}")
public ResponseEntity<User> updateUser(@PathVariable(value="id")long id,@RequestBody User user) throws UserNotFoundException{
	if(service.updateUser(id,user)){
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	else
	return new ResponseEntity("User with"+user.getUserId()+"is not found.",HttpStatus.NOT_FOUND);
}
  
}