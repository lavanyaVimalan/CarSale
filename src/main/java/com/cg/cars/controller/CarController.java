package com.cg.cars.controller;
/** This is a Controller class for Payment module 
 * 
 * @author Rukumbai's
 *
 */

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.cars.beans.Car;
import com.cg.cars.exception.CarIdNotFoundException;
import com.cg.cars.exception.DuplicateCarIdFoundException;
import com.cg.cars.exception.InvalidCarTypeException;
import com.cg.cars.service.ICarService;
@CrossOrigin
@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private ICarService carService;
	
	/** This method adds the car details 
	 * 
	 * @param Car entity details
	 * 
	 * 
	 */
	

	//http://localhost:9090/cars/addCar - method POST
	@PostMapping("/addCar")
	public ResponseEntity<String> addCar(@RequestBody Car car) throws DuplicateCarIdFoundException {
		;
		ResponseEntity<String> result;
		if (car != null) {
			car = carService.addCar(car);
			result = new ResponseEntity<String>("Car with " + car.getCarId() + " is added", HttpStatus.CREATED);
		} else {
			result = new ResponseEntity<String>("Car details is not added", HttpStatus.BAD_REQUEST);
		}
		return result;
	}
	
	/** This method returns the car details 
	 * 
	 * @param Car - carId
	 * 
	 * 
	 */

	// http://localhost:9090/cars/getCarById - method GET
	@GetMapping("getCarById/{carId}")
	public ResponseEntity<Car> getCar(@PathVariable int carId) throws CarIdNotFoundException{
		return new ResponseEntity<Car>(carService.getCar(carId), HttpStatus.FOUND);
	}

	// http://localhost:9090/cars/getAllCars - method GET
	@GetMapping("getAllCars")
	public ResponseEntity<List<Car>> getAllCars() {
		return new ResponseEntity<List<Car>>(carService.getAllCars(), HttpStatus.OK);
	}

	/** This method returns the car details by model
	 * 
	 * @param Car - model
	 * 
	 * 
	 */	
	
	// http://localhost:9090/cars/getByModel - method GET
	@GetMapping("getByModel/{model}")
	public ResponseEntity<List<Car>> getCarsByModel(@PathVariable String model) throws InvalidCarTypeException{
		return new ResponseEntity<List<Car>>(carService.getCarsByModel(model), HttpStatus.OK);
	}

	/** This method returns the car details by brand
	 * 
	 * @param Car - brand
	 * 
	 * 
	 */
	// http://localhost:9090/cars/getByBrand - method GET
	@GetMapping("getByBrand/{brand}") 
	public ResponseEntity<List<Car>> getCarsByBrand(@PathVariable String brand) throws InvalidCarTypeException {
		return new ResponseEntity<List<Car>>(carService.getCarsByBrand(brand), HttpStatus.OK);
	}

	/** This method returns the car details by location
	 * 
	 * @param Car - registrationState
	 * 
	 * 
	 */
	// http://localhost:9090/cars/getByLocation - method GET
	@GetMapping("getByLocation/{registrationState}")
	public ResponseEntity<List<Car>> getCarsByLocation(@PathVariable String registrationState) throws InvalidCarTypeException{
		return new ResponseEntity<List<Car>>(carService.getCarsByLocation(registrationState), HttpStatus.OK);
	}
	
	
	/** This method deletes the car details 
	 * 
	 * @param Car entity details and Car - paymentId
	 * 
	 * 
	 */
	// http://localhost:9090/cars/deleteCar
	@DeleteMapping("deleteCar/{carId}")
	public ResponseEntity<String> removeCar(@PathVariable int carId) throws CarIdNotFoundException {
		carService.removeCar(carId);
		return new ResponseEntity<String>("Successfully deleted", HttpStatus.OK);
	}
	
	/** This method updates the car details 
	 * 
	 * @param Payment entity details and Payment - paymentId
	 * 
	 * 
	 */
	
	//http://localhost:9090/cars/updateCar - method UPDATE
	@PutMapping("updateCar/{id}")
	public ResponseEntity<Car> updateCar(@PathVariable int id, @RequestBody Car car) throws CarIdNotFoundException {
		return new ResponseEntity<Car>(carService.updateCar(id, car), HttpStatus.OK);
	}


}
